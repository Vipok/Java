package HomeWorkJavaCoreV2;

import java.io.*;

public class ReadFileKittens {
    File file = new File("KittensList.txt");

    ReadFileKittens() throws IOException {
        System.out.println("List of kittens: ");
        boolean test = true;
        do {
            FileInputStream stream = new FileInputStream(file);
            int length = stream.available();
            byte[] data = new byte[length];
            stream.read(data);
            String text = new String(data);
            System.out.println(text);
            test = false;
        } while (test);
    }
}
