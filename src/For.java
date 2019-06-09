import java.util.Scanner;

public class For {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите j: ");
        int j =s.nextInt();
        for (int i = 1; i <= j; i++){
            System.out.print(i + " ");
        }
    }
}
