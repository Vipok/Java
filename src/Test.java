public class Test {
    public static void main(String[] args) {
        int num = 1;
        for (int i = 1; num < 15; i++) {
            for (int j = 1; j < i; j++) {
                System.out.print(num + " ");
                num++;
                if (num == 15)
                    break;
            }
            System.out.println(" ");
        }
    }
}