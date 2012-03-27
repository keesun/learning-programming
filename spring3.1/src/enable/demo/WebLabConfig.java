package enable.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author Keesun Baik
 */
@Configuration
public class WebLabConfig {

	@Autowired(required = false) WebLabConfigurer webLabConfigurer;

	@Bean
	public WebLab webLab(){
		WebLab webLab = new WebLab();
		webLab.setWork("RTCS");
		webLab.setHardness(5);

		if(webLabConfigurer != null) {
			webLabConfigurer.configurer(webLab);
		}

		return webLab;
	}
}
