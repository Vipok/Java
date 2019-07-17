package HomeWorkJavaCoreV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AddKittensForSale {
    final static Integer age = 60;
    File file = new File("KittensList.txt");
    File sale = new File("SaleList.txt");

    public AddKittensForSale() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Kittens kits = new Kittens();
        System.out.println("Enter the Id of the kitten you want to add for sale: ");
        kits.setId(scanner.nextLong());
        FileInputStream stream = new FileInputStream(file);
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);

        ArrayList<String[]> kitten = new ArrayList<>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] params = line.split("; ");
            kitten.add(params);
        }
        boolean notFound = true;
        for (String[] params : kitten) {
            if (params[0].equals("Id: " + kits.getId())) {
                String par = Arrays.toString(params);
                System.out.println(Arrays.toString(params));
                System.out.println("Do you want to add this kitten to your list for sale? Y (yes) or N(no)");
                String confirm = scanner.next();
                switch (confirm) {
                    case "Y":
                        //Добавить проверку присутсвия котенка на продаже
                        System.out.println("Логика добавления кота");
                        String p = params[2];
                        p = p.replaceAll("\\D+", "");
                        int pp = Integer.parseInt(p);
                        if (pp >= age) {
                            System.out.println("Test");
                            FileOutputStream fos = new FileOutputStream(sale, true);
                            byte[] newTextBytes = par.getBytes();
                            fos.write(newTextBytes);
                            fos.close();
                            System.out.println("Kitten successfully put up for sale.");
                            //подумать над логикой выхода в меню (как вариант, использовать цикл).
                        }else {
                            System.out.println("Kitten less than 2 mounts.");
                        }
                        break;
                    case "N":
                        //Добавить логику выхода в меню
                        System.out.println("Выход в меню");
                        break;
                    default:
                        //Switch в цикл для повторной попытки ввести ответ
                        System.out.print("Not found this command. Enter 'Y' or 'N'");
                        break;
                }
                notFound = false;
                break;
            }
        }
        while (notFound) {
            System.out.println("No match found.");
            notFound = false;
        }
    }

}

