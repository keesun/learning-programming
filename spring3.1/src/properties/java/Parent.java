package properties.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author Keesun Baik
 */
@Configuration
@PropertySource("/properties/env.properties")
public class Parent {

	@Autowired Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Value("${name}") String name1;

	@Bean
	public String name1(){
		return new String(name1);
	}

}
