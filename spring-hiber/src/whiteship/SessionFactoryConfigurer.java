package whiteship;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(LocalSessionFactoryBuilder sessionFactoryBean);

	void hibernateProperties(HashMap<String, Object> hibernateProperties);

}
