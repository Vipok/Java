package HomeWorkJavaCoreV2;

import java.io.*;
import java.util.Date;
import java.util.Scanner;


 class WriteFileKittens
{


     WriteFileKittens() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("KittensList.txt");
        boolean test = true;
        do {
            Kittens kittens = new Kittens();
            kittens.setId(new Date().getTime());
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
                        FileOutputStream fos = new FileOutputStream(file, true);
                        String text = ("Id: " + kittens.getId() + ", Nickname: " + kittens.getNickname() +
                                ", Age (days): " + kittens.getAge() +
                                ", Growth: " + kittens.getGrowth() + ", Weight: " + kittens.getWeight() +
                                ", Color: " + kittens.getColor() + "\n");
                        byte[] newTextBytes = text.getBytes();
                        fos.write(newTextBytes);
                        fos.close();
                        test = false;
                        break;
                    case "N":
                        break;
                    default:
                        System.out.println("Not found this command. Enter 'Y' or 'N'");
                        break;
                }
            } while (test);
        } while (test);
    }
}
