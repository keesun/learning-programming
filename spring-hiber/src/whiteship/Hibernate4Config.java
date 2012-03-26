package whiteship;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author Keesun Baik
 */
@Configuration
public class Hibernate4Config {

	@Autowired DataSource dataSource;

	@Autowired SessionFactoryConfigurer sessionFactoryConfigurer;

	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryConfigurer.configure(sessionFactoryBean);
		return sessionFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
