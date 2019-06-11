public class ShellSort {
    public static void main(String[] args) {
        int [] a = {5,6,4,8,1,9,3,2};
            int b = a.length/2;//4-2-1
            while (b > 0){
                for (int i = 0; i < a.length - b; i++){
                     for (int j = i; j >=0 && (a[j] > a[j + b]); j--){
                         int c = a[j];
                         a[j] = a[j + b];
                         a[j+b] = c;
                     }
                }
                b = b/2;
            }
        for (int n:a
        ) {
            System.out.print(n + " ");
        }
    }
}