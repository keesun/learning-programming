package enable;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Keesun Baik
 */
public class WorkConfigBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinition bd = new RootBeanDefinition(WorkHardService.class);
		int hardness = (Integer)importingClassMetadata.getAnnotationAttributes(EnableWorkHard.class.getName()).get("hardness");
		bd.getPropertyValues().addPropertyValue("hardness", hardness);
		registry.registerBeanDefinition("workHardService", bd);
	}
}
