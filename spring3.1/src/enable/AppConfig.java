package enable;

import org.springframework.context.annotation.Configuration;

/**
 * @author Keesun Baik
 */
@Configuration
public class AppConfig extends WorkConfig {

	@Override
	public WorkHardService workHardService() {
		WorkHardService service = super.workHardService();
		service.setHardness(100);
		return service;
	}
}
