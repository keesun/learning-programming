package whiteship.hibernate3;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import whiteship.HibernateConfig;

/**
 * @author Keesun Baik
 */
@Configuration
public class Hibernate3Config extends HibernateConfig {

	@Autowired(required = false) SessionFactoryConfigurer sessionFactoryConfigurer;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(mergePackagesToScan());
		sessionFactoryBean.setHibernateProperties(mergeProperties());
		if(sessionFactoryConfigurer != null) {
			sessionFactoryConfigurer.configure(sessionFactoryBean);
		}
		return sessionFactoryBean;
	}

	@Override
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
