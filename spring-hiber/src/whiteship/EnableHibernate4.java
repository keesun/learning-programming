package whiteship;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Keesun Baik
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(Hibernate4Config.class)
public @interface EnableHibernate4 {

}
