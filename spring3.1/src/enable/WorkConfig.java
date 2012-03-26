package enable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Keesun Baik
 */
@Configuration
public class WorkConfig {

	@Autowired WorkServiceConfigurer workServiceConfigurer;

	@Bean
	public WorkHardService workHardService(){
		WorkHardService service = new WorkHardService();
		service.setHardness(5);
		workServiceConfigurer.configure(service);
		return service;
	}

}
