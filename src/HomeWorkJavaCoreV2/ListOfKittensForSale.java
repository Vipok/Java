package HomeWorkJavaCoreV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class ListOfKittensForSale {

    ListOfKittensForSale() throws IOException {
        System.out.println("List of kittens for sale:");
        File sale = new File("SaleList.txt");
        FileInputStream stream = new FileInputStream(sale);
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);
        System.out.println(text);
    }
}
