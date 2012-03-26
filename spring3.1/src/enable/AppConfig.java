package enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableWorkHard
public class AppConfig implements WorkServiceConfigurer{

	@Override
	public void configure(WorkHardService workHardService) {
		workHardService.setHardness(10);
	}
}