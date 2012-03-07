package transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.config.TransactionConfig;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TransactionConfig.class)
public class MemberServiceImplTest {

	@Autowired MemberService memberService;

	@Test
	public void testDoIt() throws Exception {
		memberService.doIt();
	}
}
