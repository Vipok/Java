package Algoritmy;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch test = new BinarySearch();
        int [] list = {24};
        for (int i = 0; i < list.length; i++)
            list[i] = i;
        test.binarySearch(list);
    }

    private void binarySearch(int [] t) {
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = t.length - 1;
        System.out.println("Введите число, которое нужно найти: ");
        int number = scanner.nextInt();
        int counter = 0;
        while (min <= max) {
            counter++;
            int mid = (min + max) / 2;
            int guess = t[mid];
            if (guess > number){
                max = mid - 1;
            }else if (guess < number){
                min = mid + 1;
            }else {
                System.out.println("Успех");
                System.out.println(guess);
                System.out.println("Counter = " + counter);
                max = -1;
            }
        }

    }
}
