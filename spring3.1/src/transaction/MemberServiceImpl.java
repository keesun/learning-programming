package transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

/**
 * @author Keesun Baik
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Resource PlatformTransactionManager tm1;
	@Resource PlatformTransactionManager tm2;


	public void doIt() {
		TransactionStatus ts1 = tm1.getTransaction(new DefaultTransactionDefinition());
		try {
			// DAO Operation That use DS1.

			TransactionStatus ts2 = tm2.getTransaction(new DefaultTransactionDefinition());
			try {
				// DAO Operation That use DS2.

				tm2.commit(ts2);
			} catch (DataAccessException dae) {
				tm2.rollback(ts2);
			}
			tm1.commit(ts1);
		} catch (DataAccessException dae) {
			tm1.rollback(ts1);
		}

	}

}
