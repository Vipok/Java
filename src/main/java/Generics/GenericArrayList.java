package Generics;

public class GenericArrayList {
    public static void main(String[] args) {
        Object [] array = new Object[6];
        array[0] = "String";
        array[1] = 12;
        array[2] = 32.1;
        array[3] = true;
        array[4] = 'a';
        for (int i = 0; i < array.length - 1; i++){
            System.out.println(array[i]);
        }
    }
}
