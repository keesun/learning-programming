package properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class PropertiesTests {

	@Test
	public void keesun(){
		ConfigurableApplicationContext parentContext = new GenericXmlApplicationContext("classpath:/properties/parent.xml");
		ConfigurableApplicationContext childContext = new GenericXmlApplicationContext("classpath:/properties/child.xml");
		childContext.setParent(parentContext);

		String name1 = childContext.getBean("name1", String.class);
		String name2 = childContext.getBean("name2", String.class);
		
		assertThat(name1, is("keesun"));
		assertThat(name2, is("keesun"));
	}
}
