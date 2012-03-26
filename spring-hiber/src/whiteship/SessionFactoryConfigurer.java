package whiteship;

import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(LocalSessionFactoryBean sessionFactoryBean);
}
