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
		GenericApplicationContext context1 = new GenericXmlApplicationContext("/container/context1.xml");
		BeanDefinitionUtils.printBeanDefinitions(context1);

		System.out.println("Context2");
		GenericApplicationContext context2 = new GenericXmlApplicationContext("/container/context2.xml");
		BeanDefinitionUtils.printBeanDefinitions(context2);
	}

}
