package HomeWorkJavaCoreV3;

import java.io.*;
import java.util.ArrayList;

class ListOfKittens {
    static void listOfKittens() throws IOException {
        FileReader listOfKittens = new FileReader("ListOfKittens");
        System.out.println("List of kittens: ");
        ArrayList<String> kittens = new ArrayList<>();
        BufferedReader br = new BufferedReader(listOfKittens);
        String line;
        while ((line = br.readLine()) != null) {
            kittens.add(line);
        }
        br.close();
        String test;
        for (int i = 0; i < kittens.size(); i++) {
            test = kittens.get(i);
            System.out.println((i + 1) + ". " + test);
        }
    }
}

