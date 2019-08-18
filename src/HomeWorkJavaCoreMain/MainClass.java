package HomeWorkJavaCoreMain;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {

        ArrayList<Kittens> kittensArrayList = new ArrayList<>();
        int numberOfKitten;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Kittens.txt"));
            kittensArrayList = (ArrayList) ois.readObject();
        } catch (Exception e) {

        }
        boolean test = true;
        System.out.println();
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
                        String command2 = scanner.next();
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
                                    System.out.println("Success \n");
                                }
                                System.out.println(textMessage);
                                break;
                            case "-edit":
                                System.out.println("Enter the ID of the kitten whose parameters you want to change: ");
                                numberOfKitten = scanner.nextInt();
                                int d = 0;
                                for (Kittens listOfKittens : kittensArrayList) {
                                    if (d == numberOfKitten - 1) {
                                        System.out.println("Nickname: " + listOfKittens.getNickname() + "; Age: " + listOfKittens.getAge()
                                                + "; Growth: " + listOfKittens.getGrowth() + "; Weight: " + listOfKittens.getWeight() +
                                                "; Color: " + listOfKittens.getColor() + "\n");
                                    }
                                    d++;
                                }
                                System.out.println("Enter the ID of the parameter to be changed: ");
                                System.out.println("1. Nickname \n2. Age \n3. Growth \n4. Weight \n5. Color \n0. Exit");
                                int id = scanner.nextInt();
                                switch (id) {
                                    case 1:
                                        System.out.println("Enter a new nickname of the kitten: ");//кличка
                                        nickname = scanner.next();
                                        kittensArrayList.get(numberOfKitten - 1).setNickname(nickname);
                                        break;
                                    case 2:
                                        System.out.println("Enter a new age of the kitten: ");//возраст в днях
                                        age = scanner.nextInt();
                                        kittensArrayList.get(numberOfKitten - 1).setAge(age);
                                        if (age < 60) {
                                            kittensArrayList.get(numberOfKitten - 1).setSale(false);
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Enter a new growth of the kitten: ");//рост в сантиметрах
                                        growth = scanner.nextInt();
                                        kittensArrayList.get(numberOfKitten - 1).setGrowth(growth);
                                        break;
                                    case 4:
                                        System.out.println("Enter a new weight of the kitten: ");//масса в граммах
                                        weight = scanner.nextInt();
                                        kittensArrayList.get(numberOfKitten - 1).setWeight(weight);
                                        break;
                                    case 5:
                                        System.out.println("Enter a new color of the kitten: ");//цвет
                                        color = (scanner.next());
                                        kittensArrayList.get(numberOfKitten - 1).setColor(color);
                                        break;
                                    default:
                                        System.out.println("Not found this command. \n" + textMessage);
                                }
                                if ((id > 0) & (id <= 5)) {
                                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                                        oos.writeObject(kittensArrayList);
                                        oos.close();
                                        System.out.println("Success \n");
                                    }
                                } else if (id == 0) {
                                    System.out.println("Exit in menu.");
                                }

                                System.out.println("\n" + textMessage);
                                break;
                            case "-listKits":
                                System.out.println("| ID | Nickname | Age | Growth | Weight | Color| Sale | \nList of kittens: \n");
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
                                System.out.println("Enter the Id of the kitten you want to add for sale: ");
                                numberOfKitten = scanner.nextInt();
                                int g = 0;
                                for (Kittens listOfKittens : kittensArrayList) {
                                    if (g == numberOfKitten - 1) {
                                        System.out.println("Nickname: " + listOfKittens.getNickname() + "; Age: " + listOfKittens.getAge()
                                                + "; Growth: " + listOfKittens.getGrowth() + "; Weight: " + listOfKittens.getWeight() +
                                                "; Color: " + listOfKittens.getColor() + "\n");
                                    }
                                    g++;
                                }
                                System.out.println("Do you want add for sale this kitten? Y (yes) or N (no):");
                                String confirm = scanner.next();
                                switch (confirm) {
                                    case "Y":
                                        if (kittensArrayList.get(numberOfKitten - 1).getAge() >= 60 &
                                                !kittensArrayList.get(numberOfKitten - 1).getSale()) {
                                            kittensArrayList.get(numberOfKitten - 1).setSale(true);
                                            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                                                oos.writeObject(kittensArrayList);
                                                oos.close();
                                                System.out.println("Success");
                                            }
                                        } else {
                                            System.out.println("Kitten too young or already on sale! ");
                                        }
                                        break;
                                    case "N":
                                        System.out.println("Exit in menu.");
                                        break;
                                    default:
                                        System.out.println("Not found this command. \nExit in menu.");
                                }
                                System.out.println("\n" + textMessage);
                                break;
                            case "-listSale":
                                System.out.println("List of kittens for sale:");
                                int j = 0;
                                for (Kittens listOfKittens : kittensArrayList) {
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
                                System.out.println("Enter the ID of the kitten you want to sell: ");
                                numberOfKitten = scanner.nextInt();
                                int e = 0;
                                for (Kittens listOfKittens : kittensArrayList) {
                                    if (e == numberOfKitten - 1) {
                                        System.out.println("Nickname: " + listOfKittens.getNickname() + "; Age: " + listOfKittens.getAge()
                                                + "; Growth: " + listOfKittens.getGrowth() + "; Weight: " + listOfKittens.getWeight() +
                                                "; Color: " + listOfKittens.getColor() + "\n");
                                    }
                                    e++;
                                }
                                System.out.println("Do you want to sale this kitten? Y (yes) or N (no):");
                                confirm = scanner.next();
                                switch (confirm) {
                                    case "Y":
                                        if (kittensArrayList.get(numberOfKitten - 1).getSale()) {
                                            kittensArrayList.remove(numberOfKitten - 1);
                                            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                                                oos.writeObject(kittensArrayList);
                                                oos.close();
                                                System.out.println("Success");
                                            }
                                        } else {
                                            System.out.println("The kitten is not in the list for sale! \n");
                                        }
                                        break;
                                    case "N":
                                        System.out.println("Exit in menu.");
                                        break;
                                    default:
                                        System.out.println("Not found this command. \nExit in menu.");
                                }
                                System.out.println("\n" + textMessage);
                                break;
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
