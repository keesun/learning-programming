package whiteship;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import whiteship.domain.Book;

import javax.sql.DataSource;

import static org.junit.Assert.assertNotNull;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AppConfigTest {

	@Autowired DataSource dataSource;
	@Autowired SessionFactory sessionFactory;
	@Autowired PlatformTransactionManager transactionManager;
	@Autowired PersistenceExceptionTranslator exceptionTranslator;

	@Test
	public void di(){
		assertNotNull(dataSource);
		assertNotNull(sessionFactory);
		assertNotNull(transactionManager);
		assertNotNull(exceptionTranslator);
	}
	
	@Test
	public void bookEntity(){
		Book book = new Book();
		book.setTitle("쉽게 따라하는 자바 웹 개발");
		sessionFactory.getCurrentSession().save(book);
	}
}
