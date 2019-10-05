package Map;

import java.util.Scanner;

public class Gui {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //считать данные из файла.
        System.out.println("Привет, Лёха. Тестируй меня!\nВыберите режим работы:\n"
                + "1. Войти под существующей учетной записью."
                + "2. Зарегистрироватьть новую учетную запись."
                + "3. Демо-режим."
                + "0. Выход из программы.");
        switch (scanner.nextInt()){
            case 1:
                //метод входа с уже существующей учетной записи.
                break;
            case 2:
                //метод регистрации нового профиля.
                break;
            case 3:
                //метод включения деморежима.
                break;
            case 0:
                //выход из программы.
                break;
        }
    }
}
