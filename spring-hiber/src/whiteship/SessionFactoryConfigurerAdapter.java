package whiteship;

import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import java.util.*;

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
