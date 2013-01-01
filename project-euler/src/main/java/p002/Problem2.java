package p002;

/**
 * @author Keesun Baik
 */
public class Problem2 {

	public static void main(String[] args) {
		int first = 1;
		int second = 2;
		int now = first + second;
		int result = 2;
		while(now < 4000000) {
			if(now%2 == 0) {
				System.out.println(now);
				result += now;
			}
			first = second;
			second = now;
			now = first + second;
		}
		System.out.println(result);
	}


}
