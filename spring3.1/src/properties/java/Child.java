package properties.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author Keesun Baik
 */
@Configuration
public class Child {

	@Autowired
	Environment environment;

	@Bean
	public String name2(){
		return new String(environment.getProperty("name"));
	}
}
