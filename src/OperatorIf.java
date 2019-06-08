import java.util.Scanner;

public class OperatorIf {//замена if через switch
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число: ");
        int a = s.nextInt();
        switch (a%2){
            case 1:
                System.out.println("Вы ввели нечетное число: " +a);
                a = a + 1;
                System.out.println("Результат операции: " + a);
                break;
            default:
                System.out.println("Вы ввели четное число: " +a);
                a = a + 2;
                System.out.println("Результат операции: " + a);
                break;
        }
        }
    }

