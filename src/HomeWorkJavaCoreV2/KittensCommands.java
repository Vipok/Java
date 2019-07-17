package HomeWorkJavaCoreV2;

import java.io.IOException;
import java.util.Scanner;


public class KittensCommands extends Kittens {
    Scanner scanner = new Scanner(System.in);
    String textMessage = "List of available commands: \n" +
            "-addKits - Add kittens \n" +
            "-listKits - List of kittens \n" +
            "-saleKits - Sale of kittens \n" +
            "-listSaleKits - List of kittens for sale \n" +
            "-exit - Exit this program";


    public KittensCommands() throws IOException, ClassNotFoundException {

        boolean test = true;
        do {
            System.out.println("Enter -help to see a list of available commands. \n" +
                    "Enter -exit to exit this program.");
            String command1 = scanner.nextLine();
            switch (command1) {
                case "-help":
                    System.out.println(textMessage);
                    do {
                        String command2 = scanner.nextLine();
                        switch (command2) {
                            case "-addKits":
                                WriteFileKittens writeFileKittens = new WriteFileKittens();
                                System.out.println(textMessage);
                                break;
                            case "-listKits":
                                ReadFileKittens readFileKittens = new ReadFileKittens();
                                System.out.println("\n \n" + textMessage);
                                break;
                            case "-addKitsInSale":
                                AddKittensForSale addKittensInSale = new AddKittensForSale();
                                break;
                            case "-saleKits":
                                ListOfKittensForSale listOfKittensForSale = new ListOfKittensForSale();
                                break;
                            case "-listSaleKits":
                                ReadFileSale readFileSale = new ReadFileSale();
                                break;
                            case "-kitsChao":
                                
                            case "-exit":
                                test = false;
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
