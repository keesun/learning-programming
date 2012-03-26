package container;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Keesun Baik
 */
public class BeanDefinitionUtilsTest {

	@Test
	public void componentScanBeans(){
		System.out.println("Context1");
		GenericApplicationContext componentScanContext = new GenericXmlApplicationContext("/container/context1.xml");
		BeanDefinitionUtils.printBeanDefinitions(componentScanContext);

		System.out.println("Context2");
		GenericApplicationContext annotationConfigContext = new GenericXmlApplicationContext("/container/context2.xml");
		BeanDefinitionUtils.printBeanDefinitions(annotationConfigContext);


		for(String name : annotationConfigContext.getBeanDefinitionNames()) {
			System.out.printf("%s: %s\n", name, annotationConfigContext.getBean(name));
		}
	}

}
