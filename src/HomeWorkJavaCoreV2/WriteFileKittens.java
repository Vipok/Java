package HomeWorkJavaCoreV2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFileKittens {
    Scanner scanner = new Scanner(System.in);

    public WriteFileKittens() throws IOException {
        File file = new File("KittensList.txt");
        String test = "Test";
        do {Kittens kittens = new Kittens();
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
        String confirm = scanner.next();
        switch (confirm){
            case "Y":
                BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                writer.write(kittens.getNickname() + ", " + kittens.getAge() + ", " + kittens.getGrowth() + ", "
                        + kittens.getWeight() + ", " + kittens.getColor() + "\n");
                writer.flush();
                writer.close();
                test = "-exit";
                break;
            case "N":
                break;
            default:
                System.out.println("Not found this command. Enter 'Y' or 'N'");
                break;
        }
    }while(test != "-exit");
    }
}
