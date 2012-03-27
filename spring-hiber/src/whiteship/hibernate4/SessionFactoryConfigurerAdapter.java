package whiteship.hibernate4;

import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import whiteship.HibernatePropertiesConfigurer;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public class SessionFactoryConfigurerAdapter implements SessionFactoryConfigurer, HibernatePropertiesConfigurer {

	@Override
	public void hibernateProperties(HashMap<String, Object> hibernateProperties) {
	}

	@Override
	public void configure(LocalSessionFactoryBuilder sessionFactoryBuilder) {
	}

}
