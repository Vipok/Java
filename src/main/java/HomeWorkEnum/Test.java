package HomeWorkEnum;

public class Test {
    public static void main(String[] args) {
        for (Mounts mounts: Mounts.values()
             ) {
            System.out.println(mounts + " - " + mounts.getMountsRus());
        }
    }
}
