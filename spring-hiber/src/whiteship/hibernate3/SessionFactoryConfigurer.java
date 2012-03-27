package whiteship.hibernate3;

import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

import java.util.HashMap;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(AnnotationSessionFactoryBean sessionFactoryBean);
}
