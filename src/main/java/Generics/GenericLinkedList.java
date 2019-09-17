package Generics;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericLinkedList {
    public static void main(String[] args) {
        List<Object> ArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате String:");
        ArrayList.add(scanner.next());
        System.out.println("Введите данные в формате int:");
        ArrayList.add(scanner.nextInt());
        System.out.println("Введите данные в формате double:");
        ArrayList.add(scanner.nextDouble());
        System.out.println("Введите данные в формате boolean:");
        ArrayList.add(scanner.nextBoolean());
        for (Object test : ArrayList) {
            System.out.println(test);
        }
    }
}
