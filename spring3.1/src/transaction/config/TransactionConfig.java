package transaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "transaction")
public class TransactionConfig {

	@Bean
	public DataSourceTransactionManager tm1(DataSource ds1){
		return new DataSourceTransactionManager(ds1);
	}

	@Bean
	public DataSource ds1() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/test1");
		ds.setUsername("tester");
		ds.setPassword("tester");
		return ds;
	}

	@Bean
	public DataSourceTransactionManager tm2(DataSource ds2){
		return new DataSourceTransactionManager(ds2);
	}

	@Bean
	public DataSource ds2() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://localhost/test2");
		ds.setUsername("tester");
		ds.setPassword("tester");
		return ds;
	}

}
