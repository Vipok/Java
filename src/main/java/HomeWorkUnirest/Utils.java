package HomeWorkUnirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ObjectOfTranslation> translationList = new ArrayList<>();
    private static YandexUrlObjects yandexUrlObjects = new YandexUrlObjects();

    //десериализация
    private static void deserializableJson() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TranslationsList.txt"));
            translationList = (ArrayList<ObjectOfTranslation>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //сериализация
    private static void serializableJson() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TranslationsList.txt"))) {
            oos.writeObject(translationList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод перевода
    private void translator() throws UnirestException {
        String language = "\"Доступные языки:\nru - Русский;\nen - Английский;\n"
                + "es - Испанский;\nit - Итальянский;";
        System.out.println("Выберите язык, с которого требуется осуществить перевод (значение из 2-х заглавных букв).\n"
                + language);
        String languageIn = scanner.next();
        System.out.println("Выбранный вами язык: " + Language.valueOf(languageIn).getLanguageRus() + "\nВыберите язык, "
                + "на который требуется осуществить перевод (значение из 2-х заглавных букв).\n" + language);
        String languageOut = scanner.next();
        System.out.println("Выбранный вами язык: " + Language.valueOf(languageOut).getLanguageRus()
                + "\nВведите текст, который требуется перевести: ");
        String textIn = scanner.next();
        long count = translationList.stream().filter(x -> x.getTextIn().equals(textIn) && x.getLanguageIn().equals(languageIn)
                && x.getLanguageOut().equals(languageOut)).count();
        String textOut;
        if (count == 0) {
            textOut = callYandexTranslator(textIn, languageIn, languageOut);
            System.out.println("\nОжидайте: \nПеревод (из переводчика): " + textOut);
            translationList.add(new ObjectOfTranslation.ObjectOfTranslationBuilder().languageIn(languageIn)
                    .languageOut(languageOut).textIn(textIn).textOut(textOut).build());
            serializableJson();
        } else {
            textOut = translationList.stream().filter(x -> x.getTextIn().equals(textIn)).findFirst().get().getTextOut();
            System.out.println("\nОжидайте: \nПеревод (из листа): " + textOut);
        }
    }

    //метод выполнения вызова Яндекс Переводчика
    private String callYandexTranslator(String textIn, String languageIn, String languageOut) throws UnirestException {
        final HttpResponse<JsonNode> response = Unirest.get(yandexUrlObjects.getUrl())
                .queryString("text", textIn)
                .queryString("key", yandexUrlObjects.getApiKey()).queryString("lang",
                        languageIn + "-" + languageOut)
                .asJson();
        return response.getBody().getObject().getJSONArray("text").get(0).toString();
    }

    //метод возврата списка переводов
    private void listOfTranslations() {
        translationList.forEach(objectOfTranslation -> System.out.println("Оригинал: " + objectOfTranslation.getTextIn()
                + "; Языки (с-на): " + objectOfTranslation.getLanguageIn() + "-" + objectOfTranslation.getLanguageOut()
                + "; Перевод: " + objectOfTranslation.getTextOut() + "\n"));
    }

    //метод главного меню
    public void mainMenu() throws Exception {
        System.out.println("Добрый день.");
        deserializableJson();
        boolean trigger = true;
        do {
            System.out.println("Выберите режим: \n1. Перевод текста.\n2. Архив старых переводов.\n0. Выход.");
            int value = new Scanner(System.in).nextInt();
            switch (value) {
                case 1:
                    do {
                        translator();
                    } while (!submenu());
                    break;
                case 2:
                    listOfTranslations();
                    break;
                case 0:
                    trigger = false;
                    break;
            }
        } while (trigger);
    }

    //метод подменю (после выполняния перевода)
    private boolean submenu() {
        System.out.println("Вернуться в главное меню (Y) или продолжить выполнять перевод (N)?");
        String value = new Scanner(System.in).next();
        switch (value) {
            case "Y":
                return true;
            case "N":
                return false;
            default:
                System.out.println("Вы ввели некорректный символ. Осуществляется выход в главное меню...");
                return false;
        }
    }
}
