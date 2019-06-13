package JavaLessons;

public class Sort {
    public static void main(String[] args) {
        int[] a = {65,23,654,12,24,15,87,54,5,96};
        for (int i = 0; i < a.length; i++) {
            int b = a[i];
            for (int j = i - 1; j >= 0; j--) {
                int c = a[j];
                if(b < c){
                a[j + 1] = c;
                a[j] = b;
                }else {
                    break;
                }
            }
        }
        for (int d:a) {
            System.out.println(d + " ");
        }
    }
}
