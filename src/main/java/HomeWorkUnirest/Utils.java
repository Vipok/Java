package HomeWorkUnirest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ObjectOfTranslation> object = new ArrayList<>();

    //десериализация
    private void deserializableJson() throws IOException {
        //выполнить чтение файла
    }

    //сериализация
    private void serializableJson() throws IOException {
        //выполнить запись в файл

    }

    private void translator() {

    }

    private void listOfTranslations() {

    }

    private void mainMenu() throws IOException {
        deserializableJson();
        boolean trigger;
        System.out.println("Добрый день. Выберите режим: \n1. Перевод текста.\n2.Архив старых переводов.\n0. Выход.");
        int value = scanner.nextInt();
        switch (value) {
            case 1:
                translator();
                serializableJson();
                break;
            case 2:
                listOfTranslations();
                break;
            case 0:
                trigger = false;
                break;
        }
    }

}
