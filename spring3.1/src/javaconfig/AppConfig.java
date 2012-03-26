package javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Keesun Baik
 */
@Configuration
@ComponentScan(basePackageClasses = ScanPackage.class, excludeFilters = @ComponentScan.Filter(Configuration.class))
public class AppConfig {


}
