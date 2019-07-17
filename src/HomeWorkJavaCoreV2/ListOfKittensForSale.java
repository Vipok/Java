package HomeWorkJavaCoreV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ListOfKittensForSale {
    File sale = new File("SaleList.txt");

    public ListOfKittensForSale() throws IOException {
        boolean test = true;
        do {
            FileInputStream stream = new FileInputStream(sale);
            int length = stream.available();
            byte[] data = new byte[length];
            stream.read(data);
            String text = new String(data);
            System.out.println(text);
            test = false;
        } while (test);
    }
}
