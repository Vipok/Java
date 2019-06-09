public class FibonacciNumber {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 1;
        int result = num1 + num2;
        while (result < 150){
            System.out.print(result + ", ");
            num1 = num2;
            num2 = result;
            result = num1 + num2;

        }
    }
}
