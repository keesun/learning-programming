package enable;

/**
 * @author Keesun Baik
 */
public class WorkHardService {
	
	private int hardness;
	
	private String work = "work";

	public void setHardness(int hardness) {
		this.hardness = hardness;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void workHard(){
		for(int i = 0 ; i < hardness ; i++)
			System.out.printf(work + " ");
		System.out.printf("\n");
	}

}
