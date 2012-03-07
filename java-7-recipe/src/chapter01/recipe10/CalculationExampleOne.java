package chapter01.recipe10;

/**
 * @author Keesun Baik
 */
public class CalculationExampleOne {
    static int num1 = 0;
    static int num2 = 4;

    public static void main(String[] args) {
        if (args.length > 1) {
            num1 = Integer.valueOf(args[0]);
            num2 = Integer.valueOf(args[1]);
        }
        // Call the addNumbers method
        // addNumbers  메서드 호출
        addNumbers();
        // Call the multiplyNumbers method
        // multiplyNumbers 메서드 호출
        multiplyNumbers();
    }

    /**
     * Adds num1 and num2, then prints the sum.
     * num1과 num2 더하고 그 합계를 출력한다.
     */
    public static void addNumbers() {
        int sum = num1 + num2;
        System.err.println("The sum of num1 and num2 is " + sum);
    }

    /**
     * Multiplies num1 and num2 then prints the product.
     * num1과 num2를 곱하고 출력한다.
     */
    public static void multiplyNumbers() {
        int product = num1 * num2;
        System.out.println("The product of num1 and num2 is " + product);
    }
}
