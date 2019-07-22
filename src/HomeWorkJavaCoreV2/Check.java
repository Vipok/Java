package HomeWorkJavaCoreV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class Check {


    Check() throws IOException {
        File file = new File("SaleList.txt");
        FileInputStream stream = new FileInputStream(file);
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);
        ArrayList<String[]> kitten = new ArrayList<>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] params = line.split(", ");
            kitten.add(params);
        }
        for (String[] params : kitten) {
            String p = params[0];
            p = p.replaceAll("\\D+", "");
            long pp = Long.parseLong(p);
            System.out.println(pp);
        }
    }
}
