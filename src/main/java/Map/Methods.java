package Map;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Methods extends JsonPath {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Scanner scanner = new Scanner(System.in);
    private static Person person = new Person();
    private static String json;
    private ArrayPerson arrayPerson = new ArrayPerson();

    //вход с уже существующей записи
    void signIn() {
        System.out.println("Введите логин: ");
        String singInLogin = scanner.next();
        System.out.println("Введите пароль: ");
        String singInPassword = scanner.next();
        boolean trigger = false;
        for (int i = 0; i < arrayPerson.getList().size(); i++) {
            if (arrayPerson.getList().get(i).getLogin().equals(singInLogin)) {
                if (arrayPerson.getList().get(i).getPassword().equals(singInPassword)) {
                    System.out.println("Добро пожаловать, мистер " + singInLogin + "!");
                } else {
                    System.out.println("Вы ввели неверный пароль! Зарегистрируйте новый аккаунт или повторите попытку.");
                }
                i = arrayPerson.getList().size();
                trigger = true;
            }
        }
        if (!trigger) {
            System.out.println("Пользователя с таким логином не найдено. Зарегистрируйте новый аккаунт.\n");
        }
    }

    //создание новой записи
    void createNewAccount() {
        System.out.println("Введите логин: ");
        person.setLogin(scanner.next());
        System.out.println("Введите пароль: ");
        person.setPassword(scanner.next());
        System.out.println("Login: " + person.getLogin() + ", password: " + person.getPassword() + ". \n"
                + "Если согласны, нажмите 1. Если нет - 0.");
        int i = scanner.nextInt();
        if (i == 1) {
            arrayPerson.getList().add(new Person(person.getLogin(), person.getPassword(), getSysdate()));
            System.out.println("Рады пополнению наших рядов, мистер " + person.getLogin() + "!");
        } else if (scanner.nextInt() == 0) {
            System.out.print("Отмена операции.");
        } else {
            System.out.println("Вы ввели некорректный символ.");
        }
    }

    //метод десериализации
    void deserializableJson() throws IOException {
        try {
            FileReader fileReader = new FileReader("Person.json");
            JsonReader jsonReader = new JsonReader(fileReader);
            Type type = getTYPE();
            arrayPerson = GSON.fromJson(jsonReader, type);
            jsonReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            File file = new File("Person.json");
            file.createNewFile();
            System.out.println("Файл успешно создан.");
        }
    }

    //метод сериализации
    void serializableJson() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("Person.json");
            JsonWriter jsonWriter = new JsonWriter(fileWriter);
            Type type = getTYPE();
            GSON.toJson(arrayPerson, type, jsonWriter);
            jsonWriter.flush();
            jsonWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            File file = new File("Person.json");
            file.createNewFile();
            System.out.println("Новый файл успешно создан.");
        }

    }

    //метод вывода списка зарегистрированных пользователей (+ общее количество)
    private void listPerson() {
        json = GSON.toJson(arrayPerson);
        System.out.println(json);
        System.out.println("Количество зарегистрированных пользователей: " + arrayPerson.getList().size() + "\n");
    }

    //метод изменения параметров пользователя
    private void editPerson() {
        System.out.println("Введите номер пользователя, параметры которого нужно изменить:");
        int index = scanner.nextInt();
        if (index <= arrayPerson.getList().size() & index > 0) {
            System.out.println("Вы уверены, что хотите изменить параметры этого пользователя? (Y/N)\n"
                    + GSON.toJson(arrayPerson.getList().get(index - 1)));
        }
        if (scanner.next().equals("Y")) {
            editParamsPerson(index);
        } else if (scanner.next().equals("N")) {
            System.out.println("Выход в главное меню.\n");
        } else {
            System.out.println("Введен некорректный символ отмены.\n");
        }
    }

    //логика выбора параметра пользователя, который требуется изменить
    private void editParamsPerson(int index) {
        System.out.println("Выберете параметр, который хотите изменить:\n"
                + "1. Логин.\n2. Пароль.\n0. Отмена.");
        int answer = scanner.nextInt();
        if (answer == 1) {
            editLogin(index);
        } else if (answer == 2) {
            editPassword(index);
        } else if (answer == 0) {
            System.out.println("Выход в главное меню.\n");
        } else {
            System.out.println("Введен некорректный символ отмены.\n");
        }
    }

    //логика изменения логина
    private void editLogin(int index) {
        System.out.println("Введите новый оригинальный логин:");
        String newLogin = scanner.next();
        boolean check = true;
        for (int i = 0; i < arrayPerson.getList().size(); i++) {
            if (arrayPerson.getList().get(i).getLogin().equals(newLogin)) {
                check = false;
            }
        }
        if (check) {
            arrayPerson.getList().get(index - 1).setLogin(newLogin);
            arrayPerson.getList().get(index - 1).setUpdatedDate(getSysdate());
            System.out.println("Логин успешно изменен.");
        } else {
            System.out.println("Данный логин уже занят. Повторите шаги и в следующий раз введите оригинальный логин.");
        }
    }

    //логика изменения пароля
    private void editPassword(int index) {
        System.out.println("Введите новый пароль, отличный от старого:");
        String newPassword = scanner.next();
        if (!arrayPerson.getList().get(index - 1).getPassword().equals(newPassword)) {
            arrayPerson.getList().get(index - 1).setPassword(newPassword);
            arrayPerson.getList().get(index - 1).setUpdatedDate(getSysdate());
            System.out.println("Пароль успешно изменен.");
        } else {
            System.out.println("Новый пароль соответствует старому. Повторите шаги и в следующий раз введите "
                    + "оригинальный пароль.");
        }
    }

    //метод удаления пользователя
    private void deletePerson() {
        System.out.println("Введите номер пользователя, которого нужно удалить: ");
        int index = scanner.nextInt();
        if (index <= arrayPerson.getList().size() & index > 0) {
            System.out.println("Вы уверены, что хотите удалть этого пользователя? (Y/N)\n"
                    + GSON.toJson(arrayPerson.getList().get(index - 1)));
            if (scanner.next().equals("Y")) {
                arrayPerson.getList().remove(index - 1);
                System.out.println("Удаление успешно выполнено.\n");
            } else if (scanner.next().equals("N")) {
                System.out.println("Выход в главное меню.\n");
            } else {
                System.out.println("Введен некорректный символ отмены.\n");
            }
        } else {
            System.out.println("Указан некоррктный номер пользователя: либо больше 0, либо такого пользователя не "
                    + "существует.");
        }
    }

    //метод возврата текущей даты
    private String getSysdate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");
        String sysdate = simpleDateFormat.format(date);
        return sysdate;
    }

    //метод управления функциями залогиненного пользователя.
    void personMenu() {
        boolean trigger = true;
        do {
            System.out.println("Основные функции: \n1. Список всех пользователей. \n2. Редактировать параметры пользователя. \n"
                    + "3. Удалить пользователя. \n0. Выход в главное меню.");
            switch (scanner.nextInt()) {
                case 1:
                    listPerson();
                    break;
                case 2:
                    editPerson();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 0:
                    trigger = false;
                    break;
            }
        } while (trigger);

    }
}
