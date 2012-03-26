package enable;

import org.junit.Test;

/**
 * @author Keesun Baik
 */
public class WorkHardServiceTest {
	
	@Test
	public void work(){
		WorkHardService service = new WorkHardService();
		service.setHardness(5);
		service.workHard();
	}
}
