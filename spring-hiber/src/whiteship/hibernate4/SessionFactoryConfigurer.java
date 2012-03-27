package whiteship.hibernate4;

import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(LocalSessionFactoryBuilder sessionFactoryBuilder);

}
