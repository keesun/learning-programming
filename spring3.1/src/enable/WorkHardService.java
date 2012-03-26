package enable;

/**
 * @author Keesun Baik
 */
public class WorkHardService {
	
	private int hardness;

	public void setHardness(int hardness) {
		this.hardness = hardness;
	}

	public void workHard(){
		for(int i = 0 ; i < hardness ; i++)
			System.out.printf("work ");
		System.out.printf("\n");
	}

}
