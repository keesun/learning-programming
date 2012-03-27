package enable.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Keesun Baik
 */
@Configuration
@EnableWebLab
public class AppConfig implements WebLabConfigurer {

	@Override
	public void configurer(WebLab webLab) {
		webLab.setHardness(1);
		webLab.setWork("일");
	}
}
