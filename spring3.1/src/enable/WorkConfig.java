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
public class WorkConfig implements ImportAware {

	@Bean
	public WorkHardService workHardService(){
		WorkHardService service = new WorkHardService();
		service.setHardness(5);
		return service;
	}

	@Autowired WorkHardService workHardService;


	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		int hardness = (Integer)importMetadata.getAnnotationAttributes(EnableWorkHard.class.getName()).get("hardness");
		workHardService.setHardness(hardness);
	}
}
