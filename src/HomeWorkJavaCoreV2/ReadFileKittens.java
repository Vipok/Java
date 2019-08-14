package HomeWorkJavaCoreV2;

import java.io.*;
//класс отображения общего списка котят
class ReadFileKittens {


    ReadFileKittens() throws IOException {
        File file = new File("KittensList.txt");
        System.out.println("List of kittens: ");
        FileInputStream stream = new FileInputStream(file);
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);
        System.out.println(text);
    }
}
