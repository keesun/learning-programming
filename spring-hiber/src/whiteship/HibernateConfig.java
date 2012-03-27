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
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;

/**
 * @author Keesun Baik
 */
@Configuration
public abstract class HibernateConfig implements ImportAware {

	@Autowired protected DataSource dataSource;

	@Autowired(required = false) protected HibernatePropertiesConfigurer hibernatePropertiesConfigurer;

	protected  String[] value;
	protected String[] packageToScan;
	protected Class<?>[] packageToScanClasses;

	protected String propsLocation = "/hibernate.properties";

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		Map<String, Object> enableHibernate = importMetadata.getAnnotationAttributes(EnableHibernate4.class.getName());
		this.value = (String[]) enableHibernate.get("value");
		this.packageToScan = (String[]) enableHibernate.get("packageToScan");
		this.packageToScanClasses = (Class<?>[]) enableHibernate.get("packageToScanClasses");
		this.propsLocation = (String) enableHibernate.get("propsLocation");
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public abstract PlatformTransactionManager transactionManager(SessionFactory sessionFactory);

	protected String[] mergePackagesToScan() {
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
		return packages.toArray(new String[packages.size()]);
	}

	protected Properties loadFromPropertyFile(Properties hibernateProperties) {
		ClassPathResource hibernatePropertiesResource = new ClassPathResource(propsLocation);
		// Load hibernate properties from property file.
		if(hibernatePropertiesResource.exists()) {
			try {
				hibernateProperties.load(hibernatePropertiesResource.getInputStream());
			} catch (IOException e) {
				throw new IllegalArgumentException("Loading Hibernate Properties form hibernate.properties failed", e);
			}
		}
		return hibernateProperties;
	}

	protected void loadFromConfigurer(Properties hibernateProperties) {
		if(hibernatePropertiesConfigurer != null) {
			HashMap<String, Object> props = new HashMap<String, Object>();
			hibernatePropertiesConfigurer.hibernateProperties(props);
			for(String key : props.keySet()) {
				hibernateProperties.put(key, props.get(key).toString());
			}
		}
	}

	protected Properties mergeProperties() {
		Properties hibernateProperties = new Properties();
		loadFromPropertyFile(hibernateProperties);
		loadFromConfigurer(hibernateProperties);
		return hibernateProperties;
	}

}
