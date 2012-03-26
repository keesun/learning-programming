package enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Keesun Baik
 */
@Configuration
public class WorkConfig {

	@Bean
	public WorkHardService workHardService(){
		WorkHardService service = new WorkHardService();
		service.setHardness(5);
		return service;
	}
}
