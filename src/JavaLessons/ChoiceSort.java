package JavaLessons;

import java.util.Arrays;

public class ChoiceSort {
    public static void main(String[] args) {
        int[] unsortedArray = {2, 1, 4, 8, 7, 5, 6, 3};
        System.out.println(Arrays.toString(unsortedArray));
        choiceSort(unsortedArray);
    }
    public static void choiceSort(int[] arrayToSort) {
        //проходим по массиву
        //находим минимальный элемент
        //меняем местами первый и минимальный элемент
        //повторяем, пока не пройдем по всему массиву
        int indexMin;
        for (int index = 0; index < arrayToSort.length - 1; index++) {
            indexMin = index;
            for (int indexToScan = index; indexToScan < arrayToSort.length; indexToScan++) {
                if (arrayToSort[indexMin] > arrayToSort[indexToScan]) {
                    indexMin = indexToScan;
                }
            }
            int temp = arrayToSort[index];
            arrayToSort[index] = arrayToSort[indexMin];
            arrayToSort[indexMin] = temp;
        }
        System.out.println(Arrays.toString(arrayToSort));
    }
}