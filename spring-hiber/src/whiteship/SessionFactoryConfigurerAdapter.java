package whiteship;

import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public class SessionFactoryConfigurerAdapter implements SessionFactoryConfigurer {

	@Override
	public void hibernateProperties(HashMap<String, Object> hibernateProperties) {
	}

	@Override
	public void configure(LocalSessionFactoryBuilder sessionFactoryBuilder) {
	}

}
