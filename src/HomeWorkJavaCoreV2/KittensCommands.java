package HomeWorkJavaCoreV2;

import java.io.IOException;
import java.util.Scanner;


public class KittensCommands extends Kittens {
    Scanner scanner = new Scanner(System.in);


    public KittensCommands() throws IOException {
        String test = "Run";
        do {
            System.out.println("Enter -help to see a list of available commands. \n" +
                    "Enter -exit to exit this program.");
            String command1 = scanner.nextLine();
            switch (command1) {
                case "-help":
                    do {
                        System.out.println("List of available commands: \n" +
                                "-addKits - Add kittens \n" +
                                "-listKits - List of kittens \n" +
                                "-saleKits - Sale of kittens \n" +
                                "-listSaleKits - List of kittens for sale \n" +
                                "-exit - Exit this program");
                        String command2 = scanner.nextLine();
                        switch (command2) {
                            case "-addKits":
                                WriteFileKittens writeFileKittens = new WriteFileKittens();

                                break;
                            case "-listKits":
                                ReadFileKittens readFileKittens = new ReadFileKittens();
                                break;
                            case "-saleKits":
                                WriteFileSale writeFileSale = new WriteFileSale();
                                break;
                            case "-listSaleKits":
                                ReadFileSale readFileSale = new ReadFileSale();
                                break;
                            case "-exit":
                                test = "-exit";
                                break;
                            default:
                                System.out.println("Not found this command. \n" +
                                        "List of available commands: \n" +
                                        "Enter -help to see a list of available commands" +
                                        "-addKits - Add kittens \n" +
                                        "-listKits - List of kittens \n" +
                                        "-saleKits - Sale of kittens \n" +
                                        "-listSaleKits - List of kittens for sale \n" +
                                        "-exit - Exit this program");
                                break;
                        }

                    } while (test != "-exit");
                case "-exit":
                    test = "-exit";
                    break;
                default:
                    System.out.println("Not found this command.");
            }
        } while (test != "-exit");
        System.out.println("Good bye!");
    }
}
