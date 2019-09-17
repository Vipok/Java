package Generics;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GenericLinkedList {
    public static void main(String[] args) {
        List<Object> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате String:");
        linkedList.add(scanner.next());
        System.out.println("Введите данные в формате int:");
        linkedList.add(scanner.nextInt());
        System.out.println("Введите данные в формате double:");
        linkedList.add(scanner.nextDouble());
        System.out.println("Введите данные в формате boolean:");
        linkedList.add(scanner.nextBoolean());
        for (Object test : linkedList) {
            System.out.println(test);
        }
    }
}
