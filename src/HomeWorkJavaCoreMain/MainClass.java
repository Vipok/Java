package HomeWorkJavaCoreMain;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        MainClass m = new MainClass();
        ArrayList<Kittens.Builder> kittensArrayList = new ArrayList<>();
        boolean test = true;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Kittens.txt"));
            kittensArrayList = (ArrayList<Kittens.Builder>) ois.readObject();
        } catch (Exception e) {
            e.getMessage();
        }
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
                                m.addKits(kittensArrayList);
                                System.out.println(textMessage);
                                break;
                            case "-edit":
                                m.edit(kittensArrayList);
                                System.out.println("\n" + textMessage);
                                break;
                            case "-listKits":
                                m.listKits(kittensArrayList);
                                System.out.println("\n" + textMessage);
                                break;
                            case "-addKitsInSale":
                                m.addKitsInSale(kittensArrayList);
                                System.out.println("\n" + textMessage);
                                break;
                            case "-listSale":
                                m.listSale(kittensArrayList);
                                System.out.println("\n" + textMessage);
                                break;
                            case "-sale":
                                m.sale(kittensArrayList);
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

    //Метод добавления котенка
    private void addKits(ArrayList<Kittens.Builder> kittens) {
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
        kittens.add(new Kittens.Builder()
                .nickname(nickname)
                .age(age)
                .growth(growth)
                .weight(weight)
                .color(color)
                .sale(sale));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
            oos.writeObject(kittens);
            System.out.println("Success \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Метод изменения параметров котенка
    private void edit(ArrayList<Kittens.Builder> kittens) {
        System.out.println("Enter the ID of the kitten whose parameters you want to change: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int d = 0;
        for (Kittens.Builder listOfKittens : kittens) {
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
                kittens.get(number - 1).nickname(nickname);
                break;
            case 2:
                System.out.println("Enter a new age of the kitten: ");//возраст в днях
                Integer age = sc.nextInt();
                kittens.get(number - 1).age(age);
                if (age < 60) {
                    kittens.get(number - 1).sale(false);
                }
                break;
            case 3:
                System.out.println("Enter a new growth of the kitten: ");//рост в сантиметрах
                Integer growth = sc.nextInt();
                kittens.get(number - 1).growth(growth);
                break;
            case 4:
                System.out.println("Enter a new weight of the kitten: ");//масса в граммах
                Integer weight = sc.nextInt();
                kittens.get(number - 1).weight(weight);
                break;
            case 5:
                System.out.println("Enter a new color of the kitten: ");//цвет
                String color = sc.next();
                kittens.get(number - 1).color(color);
                break;
            default:
                System.out.println("Not found this command. \n");
        }
        if ((number > 0) & (number <= 5)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                oos.writeObject(kittens);
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
    private void listKits(ArrayList<Kittens.Builder> kittens) {
        System.out.println("| ID | Nickname | Age | Growth | Weight | Color| Sale | \nList of kittens: \n");
        int i = 0;
        for (Kittens.Builder k : kittens) {
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
    private void addKitsInSale(ArrayList<Kittens.Builder> kittens) {
        System.out.println("Enter the Id of the kitten you want to add for sale: ");
        Scanner sc = new Scanner(System.in);
        int numberOfKitten = sc.nextInt();
        int g = 0;
        for (Kittens.Builder listOfKittens : kittens) {
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
                if (kittens.get(numberOfKitten - 1).getAge() >= 60 &
                        !kittens.get(numberOfKitten - 1).getSale()) {
                    kittens.get(numberOfKitten - 1).sale(true);
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                        oos.writeObject(kittens);
                        oos.close();
                        System.out.println("Success");
                    } catch (IOException e) {
                        e.printStackTrace();
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
    }

    //Метод, возвращающий список котят, которые находятся на продаже
    private void listSale(ArrayList<Kittens.Builder> kittens) {
        System.out.println("List of kittens for sale:");
        int j = 0;
        for (Kittens.Builder listOfKittens : kittens) {
            if (listOfKittens.getSale()) {
                j++;
                System.out.println(j + ". Nickname: " + listOfKittens.getNickname() + "; Age: " + listOfKittens.getAge()
                        + "; Growth: " + listOfKittens.getGrowth() + "; Weight: " + listOfKittens.getWeight() +
                        "; Color: " + listOfKittens.getColor());
            }
        }
    }

    //Метод продажи котят
    private void sale(ArrayList<Kittens.Builder> kittens) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the kitten you want to sell: ");
        int numberOfKitten = sc.nextInt();
        int e = 0;
        for (Kittens.Builder listOfKittens : kittens) {
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
                if (kittens.get(numberOfKitten - 1).getSale()) {
                    kittens.remove(numberOfKitten - 1);
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Kittens.txt"))) {
                        oos.writeObject(kittens);
                        oos.close();
                        System.out.println("Success");
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
    }
}