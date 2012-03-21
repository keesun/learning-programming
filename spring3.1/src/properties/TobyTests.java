package properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author Keesun Baik
 */
public class TobyTests {

	@Test
	public void toby() {
		AnnotationConfigApplicationContext p = new AnnotationConfigApplicationContext();
		p.register(Parent.class);
		p.refresh();

		AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext();
		c.register(Child.class);
		c.setParent(p);
		c.refresh();
	}

	@Configuration
	@PropertySource("/properties/env.properties")
	static class Parent {

	}

	@Configuration
	static class Child {
		@Autowired
		Environment env;

		@PostConstruct
		public void init() {
			System.out.println(env.getProperty("name"));
		}
	}
}
