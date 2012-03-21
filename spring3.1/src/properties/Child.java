package properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Keesun Baik
 */
@Configuration
@PropertySource("classpath:/properties/env.properties")
public class Child {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Value("${name}") String name2;

	@Bean
	public String name2(){
		return new String(name2);
	}
}
