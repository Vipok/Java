package HomeWorkJavaCoreMain;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        ArrayList<Kittens> kittensArrayList = new ArrayList<>();
        //считывание из файла в ArrayList
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Kittens.txt"))) {
            kittensArrayList = ((ArrayList<Kittens>) ois.readObject());

        } catch (Exception ignored) {
        }
        boolean test = true;
        do {
            System.out.println("Enter -help to see a list of available commands. \n" +
                    "Enter -exit to exit this program.");
            Scanner scanner = new Scanner(System.in);
            String command1 = scanner.nextLine();
            String textMessage = "List of available commands: \n" +
                    "-addKits - Add kittens \n" +
                    "-edit - To edit the parameters of kittens \n" +
                    "-listKits - List of kittens \n" +
                    "-addKitsInSale - Add kittens for sale \n" +
                    "-listSale - List of kittens for sale \n" +
                    "-sale - Sale of kittens \n" +
                    "-exit - Exit this program";
            switch (command1) {
                case "-help":
                    System.out.println(textMessage);
                    do {
                        String command2 = scanner.nextLine();
                        switch (command2) {
                            case "-addKits":
                                System.out.println("Enter the nickname of the kitten: ");//кличка
                                String nickname = (scanner.next());
                                System.out.println("Enter the age of the kitten: ");//возраст в днях
                                Integer age = scanner.nextInt();
                                System.out.println("Enter the growth of the kitten: ");//рост в сантиметрах
                                Integer growth = scanner.nextInt();
                                System.out.println("Enter the weight of the kitten: ");//масса в граммах
                                Integer weight = scanner.nextInt();
                                System.out.println("Enter the color of the kitten: ");//цвет
                                String color = (scanner.next());
                                Boolean sale = false;
                                kittensArrayList.add(new Kittens(nickname, age, growth, weight, color, sale));
                                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                                    oos.writeObject(kittensArrayList);
                                    System.out.println("Success");
                                }
                                System.out.println(textMessage);
                                break;
                            case "-edit":

                                System.out.println(textMessage);
                            case "-listKits":
                                int i = 0;
                                for (Kittens k : kittensArrayList) {
                                    i++;
                                    if (k.getSale()) {
                                        System.out.println(i + ". Nickname: " + k.getNickname() + "; Age: " + k.getAge() + "; Growth: " +
                                                k.getGrowth() + "; Weight: " + k.getWeight() + "; Color: " + k.getColor() +
                                                "; Sale: Yes");

                                    } else {
                                        System.out.println(i + ". Nickname: " + k.getNickname() + "; Age: " + k.getAge() + "; Growth: " +
                                                k.getGrowth() + "; Weight: " + k.getWeight() + "; Color: " + k.getColor() +
                                                "; Sale: No");
                                    }
                                }
                                System.out.println("\n" + textMessage);
                                break;
                            case "-addKitsInSale":
                                System.out.println("Enter the ID of the kitten whose parameters you want to change: ");
                                int numberOfKitten = scanner.nextInt();
                                if (kittensArrayList.get(numberOfKitten - 1).getAge() >=60 &
                                        !kittensArrayList.get(numberOfKitten - 1).getSale()){
                                kittensArrayList.get(numberOfKitten - 1).setSale(true);
                                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                                    oos.writeObject("");
                                    oos.writeObject(kittensArrayList);
                                    oos.close();
                                    System.out.println("Success");
                                }}
                                else {
                                    System.out.println("Kitten too young or already on sale! ");
                                }
                                System.out.println("\n" + textMessage);
                                break;
                            case "-listSale":
                                int j = 0;
                                for (Kittens listOfKittens : kittensArrayList) {
                                    j++;
                                    if (listOfKittens.getSale()) {
                                        j++;
                                        System.out.println(j + ". Nickname: " + listOfKittens.getNickname() + "; Age: " + listOfKittens.getAge()
                                                + "; Growth: " + listOfKittens.getGrowth() + "; Weight: " + listOfKittens.getWeight() +
                                                "; Color: " + listOfKittens.getColor());
                                    }
                                }
                                System.out.println("\n" + textMessage);
                                break;
                            case "-sale":
                                break;
                                //System.out.println(textMessage);
                            case "-exit":
                                test = false;
                                break;
                            default:
                                System.out.println("Not found this command. \n" + textMessage);
                                break;
                        }

                    } while (test);
                case "-exit":
                    test = false;
                    break;
                default:
                    System.out.println("Not found this command.");
            }
        } while (test);
        System.out.println("Good bye!");
    }
}
