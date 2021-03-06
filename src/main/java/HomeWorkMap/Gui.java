package HomeWorkMap;


import java.io.IOException;
import java.util.Scanner;

public class Gui {
    private static boolean trigger = true;
    private static Scanner scanner = new Scanner(System.in);
    private static Methods methods = new Methods();

    public static void main(String[] args) throws IOException {
        //считать данные из файла.
        methods.deserializableJson();
        System.out.println("Привет, Лёха! Тестируй меня полностью!");
        do {
            System.out.println("Выберите режим работы:\n"
                    + "1. Зарегистрироватьть новую учетную запись.\n"
                    + "2. Войти под существующей учетной записью.\n"
                    + "0. Выход из программы.");
            switch (scanner.nextInt()) {
                case 1:
                    //метод входа с уже существующей учетной записи.
                    if (methods.createNewAccount()){
                        methods.personMenu();
                    }
                    break;
                case 2:
                    //метод регистрации нового профиля.
                    if (methods.signIn()){
                        methods.personMenu();
                    }
                    break;
                case 0:
                    trigger = false;
                    System.out.println("Пока! <3");
                    break;
            }
        } while (trigger);
        methods.serializableJson();
    }
}
