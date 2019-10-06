package Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Gui extends Methods {
    private static boolean trigger = true;
    private static Scanner scanner = new Scanner(System.in);
    private static Methods methods = new Methods();

    public static void main(String[] args) throws JsonProcessingException {
        //считать данные из файла.
        serializableJson();
        do {
            System.out.println("Привет, Лёха. Тестируй меня!\nВыберите режим работы:\n"
                    + "1. Войти под существующей учетной записью.\n"
                    + "2. Зарегистрироватьть новую учетную запись.\n"
                    + "3. Демо-режим.\n"
                    + "0. Выход из программы.");
            switch (scanner.nextInt()) {
                case 1:
                    //метод входа с уже существующей учетной записи.
                    methods.signIn();
                    break;
                case 2:
                    //метод регистрации нового профиля.
                    break;
                case 3:
                    //метод включения деморежима.
                    break;
                case 0:
                    trigger = false;
                    System.out.println("Пока! <3");
                    break;
            }
        } while (trigger);
        methods.deserializableJson();
    }
}
