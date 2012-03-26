package enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Keesun Baik
 */
public class WorkConfigSelector implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
	   	String type = (String)importingClassMetadata.getAnnotationAttributes(EnableWorkHard.class.getName()).get("type");
		if(type.equals("work")) {
			return new String[]{WorkConfig.class.getName()};
		}
		if(type.equals("치열하게")) {
			return new String[]{WorkTogetherConfig.class.getName()};
		}
		throw new IllegalArgumentException();
	}
}
