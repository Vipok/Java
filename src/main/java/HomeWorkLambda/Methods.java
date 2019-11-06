package HomeWorkLambda;

import java.util.Scanner;

public class Methods {
    private static Scanner scanner = new Scanner(System.in);
    private static Methods methods = new Methods();
    private static int num;
    private static boolean b;//Значение для работы

    public static void main(String[] args) {
        System.out.println("Введите число");
        num = scanner.nextInt();
        System.out.println("Выбери номер метода (1, 2, 3)");
        int i = scanner.nextInt();
        switch (i) {
            case 1:
                b = verify1();
                if (b) {
                    System.out.println("Число делится без остатка на 15");
                } else System.out.println("Число не делится без остатка на 15");
                break;
            case 2:
                b = verify2();
                if (b) {
                    System.out.println("Число положительное");
                } else System.out.println("Число отрицательное или ноль");
                break;
            case 3:
                b = verify3();
                if (b) {
                    System.out.println("Число принадлежит к числам Фибоначчи");
                } else System.out.println("Число не принадлежит к числам Фибонначи");
                break;
            default:
                System.out.println("Пишешь не ту команду.");
        }
        if (b) {
            System.out.println();
        }
    }

    private static boolean verify1() {
        return methods.test(x -> {
            if (x % 15 == 0) {
                return true;
            } else return false;
        });
    }

    private static boolean verify2() {
        return methods.test(x -> {
            if (x > 0) {
                return true;
            } else return false;
        });
    }

    private static boolean verify3() {
        return methods.test(x -> {
            int count = 0;
            int countNext = 1;
            while (countNext < num) {
                int t;
                t = countNext;
                countNext = count + countNext;
                count = t;
            }
            if (x == countNext) {
                return true;
            } else return false;
        });
    }


    private boolean test(Check checks) {
        return checks.check(num);
    }
}
