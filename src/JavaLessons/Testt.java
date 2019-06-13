package JavaLessons;

public class Testt {
    public static void main(String[] args) {
        int[] j = {1, 23, 34, 10, 4, 31, 5, 19};
        int sum = 0;
        for (int b = 0; b < j.length; b++) {
            sum += j[b];
        }
        int d = sum / j.length;
        int min = 0;
        int max = j.length - 1;
        for (int i = 0; i < j.length - 1; i++) {
            int[] tr = new int[j.length];
            if (j[i] > d) {
                tr[max] = j[i];
                max--;
            } else {
                tr[min] = j[i];
                min++;
            }
        }
        for (int n : j
        ) {
            System.out.println(n);
        }
    }
}
