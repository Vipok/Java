package HomeWorkJavaCoreV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class AddKittensForSale {
    private final static Integer age = 60;

    AddKittensForSale() throws IOException {
        File file = new File("KittensList.txt");
        File fileCheck = new File("SaleList.txt");
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
                do {
                    String confirm = scanner.next();
                    switch (confirm) {
                        case "Y":
                            String p = params[2];
                            p = p.replaceAll("\\D+", "");
                            long pp = Long.parseLong(p);
                            FileInputStream streamCheck = new FileInputStream(fileCheck);
                            int lengthCheck = streamCheck.available();
                            byte[] dataCheck = new byte[lengthCheck];
                            streamCheck.read(dataCheck);
                            String textCheck = new String(dataCheck);
                            ArrayList<String[]> kittenCheck = new ArrayList<>();
                            String[] linesCheck = textCheck.split("\n");
                            for (String lineCheck : linesCheck) {
                                String[] paramsCheck = lineCheck.split(", ");
                                kittenCheck.add(paramsCheck);
                            }
                            boolean b = false;
                            long valueSale = 0;
                            //add Kittens in sale list
                            for (String[] paramsCheck : kittenCheck) {
                                String pCheck = paramsCheck[0];
                                pCheck = pCheck.replaceAll("\\D+", "");
                                long ppCheck = Long.parseLong(pCheck);
                                if (ppCheck == kits.getId()) {
                                    System.out.println("This kitten already are in the list for sale");
                                    valueSale = ppCheck;
                                    notFound = false;
                                } else {

                                }
                            }
                            if (valueSale == 0) {
                                if (pp >= age) {
                                    File sale = new File("SaleList.txt");
                                    FileOutputStream fos = new FileOutputStream(sale, true);
                                    byte[] newTextBytes = (par + "\n").getBytes();
                                    fos.write(newTextBytes);
                                    fos.close();
                                    System.out.println("Kitten successfully put up for sale. \n");
                                    notFound = false;
                                } else {
                                    System.out.println("Kitten less than 2 mounts.");
                                    notFound = false;
                                }
                            } else {

                            }
                            break;
                        case "N":
                            System.out.println("Exit in the menu. \n");
                            notFound = false;
                            break;
                        default:
                            System.out.print("Not found this command. Enter 'Y' or 'N': \n");
                            break;
                    }
                } while (notFound);
                notFound = false;
                break;
            }
        }
        stream.close();
        while (notFound) {
            System.out.println("No match found.");
            notFound = false;
        }
    }
}