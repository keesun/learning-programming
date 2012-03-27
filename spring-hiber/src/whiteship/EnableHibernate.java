package whiteship;

import org.springframework.context.annotation.Import;
import whiteship.hibernate4.Hibernate4Config;
import whiteship.hibernate4.HibernateVersion;

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
	 * @return
	 */
	String[] value() default {};

	String[] packageToScan() default {};

	Class<?>[] packageToScanClasses() default {};

	String propsLocation() default "/hibernate.properties";

	HibernateVersion hibernateVersion() default HibernateVersion.HIBERNATE4;

}
