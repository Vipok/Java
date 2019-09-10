package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericArrayList {
    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате String:");
        arrayList.add(scanner.next());
        System.out.println("Введите данные в формате int:");
        arrayList.add(scanner.nextInt());
        System.out.println("Введите данные в формате double:");
        arrayList.add(scanner.nextDouble());
        System.out.println("Введите данные в формате boolean:");
        arrayList.add(scanner.nextBoolean());
        for (Object test : arrayList) {
            System.out.println(test);
        }
    }
}
