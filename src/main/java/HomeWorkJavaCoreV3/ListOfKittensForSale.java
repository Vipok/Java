package HomeWorkJavaCoreV3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class ListOfKittensForSale {
    static void listOfKittensForSale() throws IOException {
        FileReader listOfKittens = new FileReader("ListForSale");
        System.out.println("List of kittens for sale: ");
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
