package whiteship;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Keesun Baik
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(HibernateConfigSelector.class)
public @interface EnableHibernate {

	/**
	 * Alias to packageToScan
	 */
	String[] value() default {};

	String[] packageToScan() default {};

	Class<?>[] packageToScanClasses() default {};

	String propsLocation() default "/hibernate.properties";

	HibernateVersion hibernateVersion() default HibernateVersion.HIBERNATE4;

}
