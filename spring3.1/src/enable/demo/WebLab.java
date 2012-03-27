package enable.demo;

/**
 * @author Keesun Baik
 */
public class WebLab {
	
	String work;
	
	int hardness;
	
	public void work(){
		for(int i = 0 ; i < hardness ; i++ ) {
			System.out.println(work);
		}
	}

	public void setWork(String work) {
		this.work = work;
	}

	public void setHardness(int hardness) {
		this.hardness = hardness;
	}
}
