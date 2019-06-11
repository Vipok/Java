public class SortNew {
    public static void main(String[] args) {
        int[] a = {2,1,4,8,7,5,6,3};
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < i;j++){
                int c = a[i];
                int b = a[j];
                if(b > c){
                    a[i] = b;
                    a[j] = c;
                }
            }
        }
        for (int n:a
             ) {
            System.out.print(n + " ");

        };
    }
}
