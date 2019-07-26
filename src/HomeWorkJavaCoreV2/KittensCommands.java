package HomeWorkJavaCoreV2;

import java.io.IOException;
import java.util.Scanner;


class KittensCommands extends Kittens {


    KittensCommands() throws IOException {

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
                                WriteFileKittens writeFileKittens = new WriteFileKittens();
                                System.out.println(textMessage);
                                break;
                            case "-edit":
                                //написать логику редактирования параметров
                                EditParameters editParameters = new EditParameters();
                                System.out.println(textMessage);
                            case "-listKits":
                                ReadFileKittens readFileKittens = new ReadFileKittens();
                                System.out.println("\n" + textMessage);
                                break;
                            case "-addKitsInSale":
                                AddKittensForSale addKittensInSale = new AddKittensForSale();
                                System.out.println(textMessage);
                                break;
                            case "-listSale":
                                ListOfKittensForSale listOfKittensForSale = new ListOfKittensForSale();
                                System.out.println("\n" + textMessage);
                                break;
                            case "-sale":
                                //написать логику продажи котят
                                SaleForKittens saleForKittens = new SaleForKittens();
                                System.out.println(textMessage);
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
