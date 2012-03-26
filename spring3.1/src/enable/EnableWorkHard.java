package enable;

import org.springframework.context.annotation.Import;

/**
 * @author Keesun Baik
 */
@Import(WorkConfig.class)
public @interface EnableWorkHard {
	
	int hardness() default 5;
}
