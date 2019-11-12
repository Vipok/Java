package HomeWorkUnirest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

class Utils {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ObjectOfTranslation> translationList = new ArrayList<>();
    private static Properties property = new Properties();

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

    //метод вывода списка доступных языков в консоль.
    private static void languageList() {
        System.out.println("Список доступных языков: ");
        for (Language lang : Language.values()) {
            System.out.println(lang.getLanguage() + " - " + lang.getValue() + ";");
        }
    }

    //метод перевода
    private void translator() throws UnirestException {
        System.out.println("Выберите язык, с которого требуется осуществить перевод (значение из 2-х заглавных букв).\n");
        languageList();
        String languageIn = scanner.next();
        System.out.println("Выбранный вами язык: " + Language.valueOf(languageIn.toUpperCase()).getValue()
                + "\nВыберите язык, на который требуется осуществить перевод (значение из 2-х заглавных букв).\n");
        languageList();
        String languageOut = scanner.next();
        System.out.println("Выбранный вами язык: " + Language.valueOf(languageOut.toUpperCase()).getValue()
                + "\nВведите текст, который требуется перевести: ");
        String textIn = scanner.next();
        ObjectOfTranslation text = translationList.stream().filter(x -> x.getTextIn().equals(textIn)
                && x.getLanguageIn().equals(languageIn)
                && x.getLanguageOut().equals(languageOut)).findFirst().orElse(null);
        String textOut;
        if (text == null) {
            textOut = callYandexTranslatorObj(textIn, languageIn, languageOut).getText()[0];
            text = new ObjectOfTranslation.ObjectOfTranslationBuilder().languageIn(languageIn)
                    .languageOut(languageOut).textIn(textIn).textOut(textOut).build();
            translationList.add(text);
            serializableJson();
        }
        System.out.println("Перевод: " + text.getTextOut());
    }

    //метод выполнения вызова Яндекс Переводчика
    private String callYandexTranslator(String textIn, String languageIn, String languageOut) throws UnirestException {
        String responseRest = null;
        try {
            FileInputStream fis = new FileInputStream("J:\\Java\\ProjectJava\\src\\main\\resources\\unirest.properties");
            property.load(fis);
            final HttpResponse<JsonNode> response = Unirest.get(property.getProperty("url"))
                    .queryString("text", textIn.toLowerCase())
                    .queryString("key", property.getProperty("apikey")).queryString("lang",
                            languageIn.toLowerCase() + "-" + languageOut.toLowerCase())
                    .asJson();
            responseRest = response.getBody().getObject().getJSONArray("text").get(0).toString();
        } catch (IOException e) {
            System.err.println("Файл с настройками отсутствует.");
        }
        return responseRest;
    }

    //метод выполнения вызова Яндекс Переводчика, но через ObjectMapper.
    private static YandexTranslatorObjects callYandexTranslatorObj(String textIn, String languageIn, String languageOut)
            throws UnirestException {
        ObjectMapper mapper = new ObjectMapper();
        YandexTranslatorObjects objects = new YandexTranslatorObjects();
        try {
            FileInputStream fis = new FileInputStream("J:\\Java\\ProjectJava\\src\\main\\resources\\unirest.properties");
            property.load(fis);
            final HttpResponse<JsonNode> response = Unirest.get(property.getProperty("url"))
                    .queryString("text", textIn.toLowerCase())
                    .queryString("key", property.getProperty("apikey")).queryString("lang",
                            languageIn.toLowerCase() + "-" + languageOut.toLowerCase())
                    .asJson();
            JSONObject obj = response.getBody().getObject();
            objects = mapper.readValue(obj.toString(), YandexTranslatorObjects.class);
        } catch (IOException e) {
            System.err.println("Файл с настройками отсутствует.");
        }
        return objects;
    }

    //метод возврата списка переводов
    private void listOfTranslations() {
        translationList.forEach(objectOfTranslation -> System.out.println("Оригинал: " + objectOfTranslation.getTextIn()
                + "; Языки (с-на): " + objectOfTranslation.getLanguageIn() + "-" + objectOfTranslation.getLanguageOut()
                + "; Перевод: " + objectOfTranslation.getTextOut() + "\n"));
    }

    //метод главного меню
    void mainMenu() throws Exception {
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
