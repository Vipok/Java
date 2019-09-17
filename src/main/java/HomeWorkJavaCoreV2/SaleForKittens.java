package HomeWorkJavaCoreV2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//класс продажи котят
public class SaleForKittens {

    public SaleForKittens() throws IOException {

        File file = new File("KittensList.txt");
        File fileRecord = new File("Record.txt");
        File fileCheck = new File("SaleList.txt");
        Scanner scanner = new Scanner(System.in);
        Kittens kittens = new Kittens();
        System.out.println("Enter the ID of the kitten you want to sell: ");
        kittens.setId(scanner.nextLong());
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
        String strings = null;
        for (String[] params : kitten) {
            if (params[0].equals("Id: " + kittens.getId())) {
                strings = Arrays.toString(params);
                strings = strings.replaceAll("^\\[|]$", "");
                System.out.println(strings);
            }
        }
        stream.close();
        System.out.println("Do you want to sale this kitten? Y (yes) or N (no):");
        String confirm = scanner.next();
        switch (confirm) {
            case "Y":
                //удаление из общего списка
                BufferedReader reader = new BufferedReader(new FileReader(file));
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileRecord));
                for (String[] params : kitten) {
                    if (!params[0].equals("Id: " + kittens.getId())) {
                        writer.write(Arrays.toString(params).replaceAll("^\\[|]$", ""));
                    }
                }
                reader.close();
                writer.close();
                BufferedReader reader1 = new BufferedReader(new FileReader(fileRecord));
                BufferedWriter writer1 = new BufferedWriter(new FileWriter(file));
                String lineParams;
                while ((lineParams = reader1.readLine()) != null) {
                    writer1.write(lineParams);
                    writer1.newLine();
                }
                reader1.close();
                writer1.close();
                //удаление из списка на продажу
                FileInputStream streamCheck = new FileInputStream(fileCheck);
                int lengthCheck = streamCheck.available();
                byte[] dataCheck = new byte[lengthCheck];
                streamCheck.read(dataCheck);
                String textCheck = new String(dataCheck);
                ArrayList<String[]> kittenCheck = new ArrayList<>();
                String[] linesCheck = textCheck.split("\n");
                for (String line : linesCheck) {
                    String[] paramsCheck = line.split(", ");
                    kittenCheck.add(paramsCheck);
                }
                BufferedReader readerSale = new BufferedReader(new FileReader(fileCheck));
                BufferedWriter writerSale = new BufferedWriter(new FileWriter(fileRecord));
                for (String[] paramsCheck : kittenCheck) {
                    if (!paramsCheck[0].equals("Id: " + kittens.getId())) {
                        writerSale.write(Arrays.toString(paramsCheck).replaceAll("^\\[|]$", ""));
                    }
                }
                readerSale.close();
                writerSale.close();
                BufferedReader readerSale1 = new BufferedReader(new FileReader(fileRecord));
                BufferedWriter writerSale1 = new BufferedWriter(new FileWriter(fileCheck));
                String lineParamsSale;
                while ((lineParamsSale = readerSale1.readLine()) != null) {
                    writerSale1.write(lineParamsSale);
                    writerSale1.newLine();
                }
                readerSale1.close();
                writerSale1.close();
                streamCheck.close();
                System.out.println("Kitten " + kittens.getId() + " successfully sold!");
                break;
            case "N":
                System.out.println("Exit in the menu. \n");
                break;
            default:
                System.out.print("Not found this command. Enter 'Y' or 'N': \n");
                break;
        }
    }
}