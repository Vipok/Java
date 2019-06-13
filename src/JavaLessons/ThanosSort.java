package JavaLessons;

import java.util.Arrays;

public class ThanosSort {
    public static void main(String[] args) {
        int[] unsortedArray = {2, 1, 4, 8, 7, 5, 6, 3};
    thanosSort(unsortedArray);
    }



    public static void thanosSort(int[] arrayToSort){
        int min = 0;
        int max = arrayToSort.length- 1;
        double sum = 0;
        for (int i = 0; i < arrayToSort.length;i++){
            sum += arrayToSort[i];
        }
        double c = sum/arrayToSort.length;
        int[] helpArray = new int[arrayToSort.length];
        for (int i = 0; i < arrayToSort.length;i++){
            if (arrayToSort[i]<=c){
            helpArray[min]=arrayToSort[i];
            min++;
            } else{
                helpArray[max]=arrayToSort[i];
                max--;
            }
        }
        System.out.println(Arrays.toString(helpArray));
    }
}
