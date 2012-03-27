package whiteship;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;

/**
 * @author Keesun Baik
 */
@Configuration
public class Hibernate4Config implements ImportAware {

	@Autowired private DataSource dataSource;

	@Autowired(required = false) private SessionFactoryConfigurer sessionFactoryConfigurer;

	private String[] value;

	private String[] packageToScan;

	private Class<?>[] packageToScanClasses;

	private String propsLocation = "/hibernate.properties";

	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);

		/**
		 * Set the LocalSessionFactoryBuilder's scanPackage with @EnableHibernate's value, packageToScan and packageToScanClasses attributes.
		 */
		List<String> packages = new ArrayList<String>();
		if(value != null) {
			packages.addAll(Arrays.asList(value));
		}
		if(packageToScan != null) {
			packages.addAll(Arrays.asList(packageToScan));
		}
		if(packageToScanClasses != null) {
			for(Class<?> clazz : packageToScanClasses) {
				packages.add(clazz.getPackage().getName());
			}
		}
		sessionFactoryBuilder.scanPackages(packages.toArray(new String[packages.size()]));

		/**
		 * Set the LocalSessionFactoryBuilder's hibernateProperties with property file,
		 * the default property file is hibernate.properties and is customizable with @EnableHibernate's props attributes.
		 */
		Properties hibernateProperties = new Properties();
		ClassPathResource hibernatePropertiesResource = new ClassPathResource(propsLocation);
		// Load hibernate properties from property file.
		if(hibernatePropertiesResource.exists()) {
			try {
				hibernateProperties.load(hibernatePropertiesResource.getInputStream());
			} catch (IOException e) {
				throw new IllegalArgumentException("Loading Hibernate Properties form hibernate.properties failed", e);
			}
		}
		// Load hibernate properties from SessinoFactoryConfigurer.
		if(sessionFactoryConfigurer != null) {
			HashMap<String, Object> props = new HashMap<String, Object>();
			sessionFactoryConfigurer.hibernateProperties(props);
			for(String key : props.keySet()) {
				hibernateProperties.put(key, props.get(key).toString());
			}
		}
		sessionFactoryBuilder.addProperties(hibernateProperties);

		/**
		 * Customize LocalSessionFactoryBuilder with SessionFactoryConfigurer.
		 */
		if(sessionFactoryConfigurer != null) {
			sessionFactoryConfigurer.configure(sessionFactoryBuilder);
		}
		return sessionFactoryBuilder.buildSessionFactory();
	}

	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	public PersistenceExceptionTranslator persistenceExceptionTranslator(){
		return new HibernateExceptionTranslator();
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		Map<String, Object> enableHibernate = importMetadata.getAnnotationAttributes(EnableHibernate4.class.getName());
		this.value = (String[]) enableHibernate.get("value");
		this.packageToScan = (String[]) enableHibernate.get("packageToScan");
		this.packageToScanClasses = (Class<?>[]) enableHibernate.get("packageToScanClasses");
		this.propsLocation = (String) enableHibernate.get("propsLocation");
	}
}
