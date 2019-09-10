package HomeWorkJavaCoreMain;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
    private static List<Kittens> kittensArrayList = new ArrayList<>();

    public static void main(String[] args) {

        boolean test = true;
        kittensArrayList = getBuilders();
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
                                try {
                                    addKits();
                                } catch (DuplicatesException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println(textMessage);
                                break;
                            case "-edit":
                                edit();
                                System.out.println("\n" + textMessage);
                                break;
                            case "-listKits":
                                listKits();
                                System.out.println("\n" + textMessage);
                                break;
                            case "-addKitsInSale":
                                try {
                                    addKitsInSale();
                                } catch (AgeException e) {
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("\n" + textMessage);
                                break;
                            case "-listSale":
                                listSale();
                                System.out.println("\n" + textMessage);
                                break;
                            case "-sale":
                                sale();
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

    //МЕТОДЫ

    //Метод считывания объектов из файла
    private static List<Kittens> getBuilders() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Kittens.txt"));
            kittensArrayList = (ArrayList<Kittens>) ois.readObject();
        } catch (Exception e) {
            System.out.println("The Kittens.txt file does not exist or is empty.");
        }
        return kittensArrayList;
    }

    //Метод добавления котенка
    private static void addKits() throws DuplicatesException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the nickname of the kitten: ");//кличка
        String nickname = sc.next();
        System.out.println("Enter the age of the kitten: ");//возраст в днях
        int age = sc.nextInt();
        System.out.println("Enter the growth of the kitten: ");//рост в сантиметрах
        int growth = sc.nextInt();
        System.out.println("Enter the weight of the kitten: ");//масса в граммах
        int weight = sc.nextInt();
        System.out.println("Enter the color of the kitten: ");//цвет
        String color = (sc.next());
        boolean sale = false;
        boolean param = true;
        for (Kittens kittens : kittensArrayList) {
            if (nickname.equals(kittens.getNickname()) & (age == kittens.getAge())) {
                param = false;
            }
        }
        if (param) {
            kittensArrayList.add(new Kittens.Builder()
                    .nickname(nickname)
                    .age(age)
                    .growth(growth)
                    .weight(weight)
                    .color(color)
                    .sale(sale)
                    .build());
            writeFile();
        } else {
            throw new DuplicatesException("This kitten is already on the list!\n");
        }
    }

    //Метод изменения параметров котенка
    private static void edit() {
        System.out.println("Enter the ID of the kitten whose parameters you want to change: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int d = 0;
        for (Kittens listOfKittens : kittensArrayList) {
            if (d == number - 1) {
                System.out.println("Nickname: " + listOfKittens.getNickname() + "; Age: " + listOfKittens.getAge()
                        + "; Growth: " + listOfKittens.getGrowth() + "; Weight: " + listOfKittens.getWeight() +
                        "; Color: " + listOfKittens.getColor() + "\n");
            }
            d++;
        }
        System.out.println("Enter the ID of the parameter to be changed: ");
        System.out.println("1. Nickname \n2. Age \n3. Growth \n4. Weight \n5. Color \n0. Exit");
        number = sc.nextInt();
        switch (number) {
            case 1:
                System.out.println("Enter a new nickname of the kitten: ");//кличка
                String nickname = sc.next();
                kittensArrayList.get(number - 1).setNickname(nickname);
                break;
            case 2:
                System.out.println("Enter a new age of the kitten: ");//возраст в днях
                Integer age = sc.nextInt();
                kittensArrayList.get(number - 1).setAge(age);
                if (age < 60) {
                    kittensArrayList.get(number - 1).setSale(false);
                }
                break;
            case 3:
                System.out.println("Enter a new growth of the kitten: ");//рост в сантиметрах
                Integer growth = sc.nextInt();
                kittensArrayList.get(number - 1).setGrowth(growth);
                break;
            case 4:
                System.out.println("Enter a new weight of the kitten: ");//масса в граммах
                Integer weight = sc.nextInt();
                kittensArrayList.get(number - 1).setWeight(weight);
                break;
            case 5:
                System.out.println("Enter a new color of the kitten: ");//цвет
                String color = sc.next();
                kittensArrayList.get(number - 1).setColor(color);
                break;
            default:
                System.out.println("Not found this command. \n");
        }
        if ((number > 0) & (number <= 5)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                oos.writeObject(kittensArrayList);
                oos.close();
                System.out.println("Success \n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (number == 0) {
            System.out.println("Exit in menu.");
        }
    }

    //Метод, возвращающий список котят
    private static void listKits() {
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
    }

    //Метод добавления котенка в список на продажу
    private static void addKitsInSale() throws AgeException {
        System.out.println("Enter the Id of the kitten you want to add for sale: ");
        Scanner sc = new Scanner(System.in);
        int numberOfKitten = sc.nextInt();
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
        String confirm = sc.next();
        switch (confirm) {
            case "Y":
                if (kittensArrayList.get(numberOfKitten - 1).getAge() >= 60 &
                        !kittensArrayList.get(numberOfKitten - 1).getSale()) {
                    kittensArrayList.get(numberOfKitten - 1).setSale(true);
                    writeFile();
                } else {
                    throw new AgeException("Kitten too young or already on sale!");
                }
                break;
            case "N":
                System.out.println("Exit in menu.");
                break;
            default:
                System.out.println("Not found this command. \nExit in menu.");
        }
    }

    //Метод, возвращающий список котят, которые находятся на продаже
    private static void listSale() {
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
    }

    //Метод продажи котят
    private static void sale() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the kitten you want to sell: ");
        int numberOfKitten = sc.nextInt();
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
        String confirm = sc.next();
        switch (confirm) {
            case "Y":
                if (kittensArrayList.get(numberOfKitten - 1).getSale()) {
                    kittensArrayList.remove(numberOfKitten - 1);
                    writeFile();
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
    }

    private static void writeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
            oos.writeObject(kittensArrayList);
            System.out.println("Success \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}