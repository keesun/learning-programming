package whiteship.hibernate4;

import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(LocalSessionFactoryBuilder sessionFactoryBuilder);

}
