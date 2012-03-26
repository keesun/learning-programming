package whiteship;

import org.hibernate.dialect.Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableHibernate4
public class AppConfig implements SessionFactoryConfigurer {

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Override
	public void configure(LocalSessionFactoryBean sessionFactoryBean) {
		sessionFactoryBean.setPackagesToScan("/whiteship/domain");
		Properties properties = new Properties();
		properties.setProperty(HibernateProperties.DIALECT, HibernateDialects.HypersonicSQL);
		properties.setProperty(HibernateProperties.SHOW_SQL, "true");
		sessionFactoryBean.setHibernateProperties(properties);
	}
}
