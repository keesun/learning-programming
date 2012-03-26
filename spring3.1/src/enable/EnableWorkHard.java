package enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Keesun Baik
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(WorkConfigSelector.class)
public @interface EnableWorkHard {
	
	int hardness() default 5;
	
	String type() default "work";
}
