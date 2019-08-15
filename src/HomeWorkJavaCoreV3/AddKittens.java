package HomeWorkJavaCoreV3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

class AddKittens {
//класс добавления котенка
    public static void addKittens() throws IOException {
        File kittensFile = new File("ListOfKittens");
        Scanner scanner = new Scanner(System.in);
        Kittens kittens = new Kittens();
        boolean test = true;
        System.out.println("Enter the nickname of the kitten: ");//кличка
        kittens.setNickname(scanner.next());
        System.out.println("Enter the age of the kitten: ");//возраст в днях
        kittens.setAge(scanner.nextInt());
        System.out.println("Enter the growth of the kitten: ");//рост в сантиметрах
        kittens.setGrowth(scanner.nextInt());
        System.out.println("Enter the weight of the kitten: ");//масса в граммах
        kittens.setWeight(scanner.nextInt());
        System.out.println("Enter the color of the kitten: ");//цвет
        kittens.setColor(scanner.next());
        System.out.println("Nickname: " + kittens.getNickname() + "\nAge (days): " + kittens.getAge() +
                "\nGrowth: " + kittens.getGrowth() + "\nWeight: " + kittens.getWeight() + "\nColor: " + kittens.getColor() +
                "\nEnter 'Y' to add the kitten or enter 'N' to exit this program: ");
        do {
            String confirm = scanner.next();
            switch (confirm) {
                case "Y":
                    FileOutputStream fos = new FileOutputStream(kittensFile, true);
                    String text = ("Nickname: " + kittens.getNickname() +
                            ", Age (days): " + kittens.getAge() +
                            ", Growth: " + kittens.getGrowth() + ", Weight: " + kittens.getWeight() +
                            ", Color: " + kittens.getColor() + ";\n");
                    byte[] newTextBytes = text.getBytes();
                    fos.write(newTextBytes);
                    fos.close();
                    test = false;
                    break;
                case "N":
                    test = false;
                    break;
                default:
                    System.out.println("Not found this command. Enter 'Y' or 'N'");
                    break;
            }
        } while (test);
    }
}
