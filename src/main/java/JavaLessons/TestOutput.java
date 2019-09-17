package JavaLessons;

import java.io.*;
import java.util.Scanner;

public class TestOutput {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("text.txt");
        String text;
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        fw.write(text);
        fw.close();

        FileReader fr = new FileReader("text.txt");
        Scanner sc1 = new Scanner(fr);
        while (sc1.hasNextLine()) {
            System.out.println(sc1.nextLine());
            fr.close();
        }
    }
}
