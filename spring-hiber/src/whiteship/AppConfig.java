package whiteship;

import static org.hibernate.cfg.AvailableSettings.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import whiteship.domain.DomainPackage;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableHibernate4(packageToScan = "whiteship.domain")
public class AppConfig implements SessionFactoryConfigurer {

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}

	@Override
	public void configure(LocalSessionFactoryBuilder sessionFactoryBuilder) {
	}

	@Override
	public void hibernateProperties(HashMap<String, Object> hibernateProperties) {
		hibernateProperties.put(HBM2DDL_AUTO, "update");
		hibernateProperties.put(DIALECT, HibernateDialects.HypersonicSQL);
		hibernateProperties.put(SHOW_SQL, true);
	}
}
