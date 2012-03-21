package properties;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import properties.java.Child;
import properties.java.Parent;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class PropertiesTests {

	@Test
	public void keesunByXml(){
		GenericXmlApplicationContext parentContext = new GenericXmlApplicationContext();
		parentContext.load("classpath:/properties/xml/parent.xml");
		parentContext.refresh();

		GenericXmlApplicationContext childContext = new GenericXmlApplicationContext();
		childContext.load("classpath:/properties/xml/child.xml");
		childContext.setParent(parentContext);
		childContext.refresh();

		/**
		 * 여기 보세요.
		 */
//		assertThat(parentContext.getEnvironment().getProperty("name"), is("keesun"));

		String name1 = childContext.getBean("name1", String.class);
		String name2 = childContext.getBean("name2", String.class);
		
		assertThat(name1, is("keesun"));
		assertThat(name2, is("keesun"));
	}

	@Test
	public void keesunByJava(){
		AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
		parentContext.register(Parent.class);
		parentContext.refresh();

		String pname1 = parentContext.getBean("name1", String.class);
		assertThat(pname1, is("keesun"));

		AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
		childContext.register(Child.class);
		childContext.setParent(parentContext);
		childContext.refresh();

		/**
		 * 여기 보세요.
		 */
		assertThat(parentContext.getEnvironment().getProperty("name"), is("keesun"));

		String name1 = childContext.getBean("name1", String.class);
		String name2 = childContext.getBean("name2", String.class);

		assertThat(name1, is("keesun"));
		assertThat(name2, is("keesun"));
	}

}
