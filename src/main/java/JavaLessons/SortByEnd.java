package JavaLessons;

public class SortByEnd {
    public static void main(String[] args) {
        int[] a = {65,23,654,12,24,15,87,54,5,96};
        for (int i = a.length; i > 0; i--) {
            int b = a[i - 1];
            for (int j = i; j < a.length; j++) {
                int c = a[j];
                if(b < c){
                    a[j - 1] = c;
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
