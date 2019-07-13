package HomeWorkJavaCoreV2;

import java.io.*;

public class ReadFileKittens {
    public ReadFileKittens() throws IOException {
        //WriteFileKittens write = new WriteFileKittens();
        File file = new File("KittensList.txt");
        String test = "Test";
        do{
            String text;
            BufferedReader read = new BufferedReader(new FileReader(file));
            System.out.println("List of kittens:");
            while ((text = read.readLine())!=null){
                System.out.println(text);
            }
            read.close();
            test = "-exit";
        }while (test != "-exit");
    }
}
