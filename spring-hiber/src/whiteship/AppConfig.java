package whiteship;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import whiteship.domain.DomainPackage;

import javax.sql.DataSource;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableHibernate4(packageToScanClasses = DomainPackage.class)
public class AppConfig{

	@Bean
	public DataSource dataSource(){
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
	}

}
