package Generics;

public class GenericArray {

    public static void main(String[] args) {
        Object [] array = new Object[5];
        array[0] = "String";
        array[1] = 2;
        array[2] = 23.12;
        array[3] = Boolean.TRUE;
        array[4] = '3';
        for (Object o : array) {
            System.out.println(o.getClass() + "\nЗначение: " + o);
        }
    }
}
