package whiteship;

import org.springframework.context.annotation.Import;
import whiteship.hibernate3.Hibernate3Config;
import whiteship.hibernate4.Hibernate4Config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Keesun Baik
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(Hibernate3Config.class)
public @interface EnableHibernate4 {

	/**
	 * Alias to packageToScan
	 * @return
	 */
	String[] value() default {};
	
	String[] packageToScan() default {};

	Class<?>[] packageToScanClasses() default {};
	
	String propsLocation() default "/hibernate.properties";

}
