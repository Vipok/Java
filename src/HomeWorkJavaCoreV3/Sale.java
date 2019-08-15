package HomeWorkJavaCoreV3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Sale {
    static void sale() throws IOException {
        FileReader listOfKittens = new FileReader("ListOfKittens");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the kitten you want to sell: ");
        int numberOfKittens = scanner.nextInt();
        ArrayList<String> kittens = new ArrayList<>();
        BufferedReader br = new BufferedReader(listOfKittens);
        String line;
        while ((line = br.readLine()) != null) {
            kittens.add(line);
        }
        kittens.remove(numberOfKittens - 1);
        FileWriter listOfKittensWrite = new FileWriter("ListOfKittens");
        BufferedWriter bf = new BufferedWriter(listOfKittensWrite);
        bf.write("");
        String test;
        for (int i = 0; i < kittens.size(); i++) {
            test = kittens.get(i);
            bf.write(test);
        }
        bf.close();
        listOfKittensWrite.close();
        br.close();
        listOfKittens.close();
        /*
        Добавить логику удаления котенка из списка на продажу. Наверное, выбирать значение из списка на продажу,
        выполнять там удаление, а после уже приступать к первому списку. Это позволит отказаться от проверки наличия
        котенка в списке на продажу
        */
    }
}
