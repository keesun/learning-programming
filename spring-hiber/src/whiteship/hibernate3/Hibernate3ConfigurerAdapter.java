package whiteship.hibernate3;

import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import whiteship.HibernatePropertiesConfigurer;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public class Hibernate3ConfigurerAdapter implements SessionFactoryConfigurer, HibernatePropertiesConfigurer {

	@Override
	public void hibernateProperties(HashMap<String, Object> props) {
	}

	@Override
	public void configure(AnnotationSessionFactoryBean sessionFactoryBean) {
	}
}
