package whiteship.hibernate3;

import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;

/**
 * @author Keesun Baik
 */
public interface SessionFactoryConfigurer {

	void configure(AnnotationSessionFactoryBean sessionFactoryBean);
}
