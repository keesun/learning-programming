package whiteship.hibernate4;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import whiteship.HibernateConfig;

/**
 * @author Keesun Baik
 */
@Configuration
public class Hibernate4Config extends HibernateConfig {

	@Autowired(required = false) private SessionFactoryConfigurer sessionFactoryConfigurer;

	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBuilder sessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionFactoryBuilder.scanPackages(mergePackagesToScan());
		sessionFactoryBuilder.addProperties(mergeProperties());

		if(sessionFactoryConfigurer != null) {
			sessionFactoryConfigurer.configure(sessionFactoryBuilder);
		}
		return sessionFactoryBuilder.buildSessionFactory();
	}

	@Bean
	public PersistenceExceptionTranslator persistenceExceptionTranslator(){
		return new HibernateExceptionTranslator();
	}

	@Override
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}

}
