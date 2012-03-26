package whiteship;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import static org.junit.Assert.assertNotNull;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppConfigTest {

	@Autowired SessionFactory sessionFactory;
	@Autowired PlatformTransactionManager transactionManager;
	@Autowired PersistenceExceptionTranslator exceptionTranslator;

	@Test
	public void di(){
		assertNotNull(sessionFactory);
		assertNotNull(transactionManager);
		assertNotNull(exceptionTranslator);
	}
}
