package whiteship;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
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

	@Autowired DataSource dataSource;

	@Autowired(required = false) SessionFactoryConfigurer sessionFactoryConfigurer;

	@Bean
	public LocalSessionFactoryBuilder localSessionFactoryBuilder(){
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);

		Properties hibernateProperties = new Properties();

		ClassPathResource hibernatePropertiesResource = new ClassPathResource("/hibernate.properties");
		if(hibernatePropertiesResource.exists()) {
			try {
				hibernateProperties.load(hibernatePropertiesResource.getInputStream());
			} catch (IOException e) {
				throw new IllegalArgumentException("Loading Hibernate Properties form hibernate.properties failed", e);
			}
		}

		if(sessionFactoryConfigurer != null) {
			HashMap<String, Object> props = new HashMap<String, Object>();
			sessionFactoryConfigurer.hibernateProperties(props);

			for(String key : props.keySet()) {
				hibernateProperties.put(key, props.get(key).toString());
			}
		}

		sessionFactoryBuilder.addProperties(hibernateProperties);

		if(sessionFactoryConfigurer != null) {
			sessionFactoryConfigurer.configure(sessionFactoryBuilder);
		}

		return sessionFactoryBuilder;
	}

	@Autowired LocalSessionFactoryBuilder localSessionFactoryBuilder;

	@Bean
	public SessionFactory sessionFactory(LocalSessionFactoryBuilder sessionFactoryBuilder){
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
		String[] value = (String[]) importMetadata.getAnnotationAttributes(EnableHibernate4.class.getName()).get("value");
		String[] packageToScan = (String[]) importMetadata.getAnnotationAttributes(EnableHibernate4.class.getName()).get("packageToScan");
		Class<?>[] packageToScanClasses = (Class<?>[]) importMetadata.getAnnotationAttributes(EnableHibernate4.class.getName()).get("packageToScanClasses");

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

		// TODO DELETE
		for(String pkg : packages) {
			System.out.println(pkg);
		}

		localSessionFactoryBuilder.scanPackages(packages.toArray(new String[packages.size()]));
	}
}
