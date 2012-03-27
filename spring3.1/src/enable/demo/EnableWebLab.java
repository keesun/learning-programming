package enable.demo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Keesun Baik
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(WebLabConfig.class)
public @interface EnableWebLab {

}
