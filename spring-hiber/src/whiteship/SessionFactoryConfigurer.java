package whiteship;

import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(LocalSessionFactoryBuilder sessionFactoryBuilder);

	void hibernateProperties(HashMap<String, Object> hibernateProperties);

}
