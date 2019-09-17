package HomeWorkJavaCoreV3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class AddKittensForSale {

    static void addKittensForSale() throws IOException {
        FileReader listOfKittens = new FileReader("ListOfKittens");
        FileWriter listForSale = new FileWriter("ListForSale", true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Id of the kitten you want to add for sale: ");
        int numberOfKittens = scanner.nextInt();
        ArrayList<String> kittens = new ArrayList<>();
        BufferedReader br = new BufferedReader(listOfKittens);
        String line;
        while ((line = br.readLine()) != null) {
            kittens.add(line);
        }
        br.close();
        String object;
        object = kittens.get(numberOfKittens - 1);
        BufferedWriter bf = new BufferedWriter(listForSale);
        bf.write(object + "\n");
        bf.close();
        //добавить проверку на дубли (если котенок уже добавлен на продажу)
        //как вариант, создать еще один ArrayList, куда писать параметры объекта. Там можно будет сравнивать всю
        //строку на наличие дублей и отдельный параметр возраста (>=60)
    }
}
