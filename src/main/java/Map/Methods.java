package Map;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    private String login;
    private String password;
    private String json;
    private Scanner scanner = new Scanner(System.in);
    static List<Person> list = new ArrayList<>();

    //вход с уже существующей записи
    public void signIn() throws JsonProcessingException {
        System.out.println("Введите логин: ");
        login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        password = scanner.nextLine();
        System.out.println("Login: " + login + ", password: " + password + ". \n"
                + "Если согласны, нажмите 1. Если нет - 0.");
        if (scanner.nextInt() == 1) {
            ObjectMapper objectMapper = new ObjectMapper();
            list.add(new Person(login, password));
            json = objectMapper.writeValueAsString(list);
            System.out.println(json);
        } else if (scanner.nextInt() == 0) {
            System.out.print("");
        } else {
            System.out.println("Вы ввели некорректный символ.");
        }
    }

    //создание новой записи
    public void createNewAccount() {
        System.out.println("Введите оригинальный логин: ");
        login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        password = scanner.nextLine();
        System.out.println("Login: " + login + ", password: " + password + ". \n"
                + "Если согласны, нажмите 1. Если нет - 0.");
        if (scanner.nextInt() == 1) {

        }
    }

    //демо режим
    public void demoMode() {

    }

    //метод сериализации
    public static List<Person> serializableJson() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Person.txt"));
            list = (ArrayList<Person>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Файл Person.json не существует или пуст.");
        }
        return list;
    }

    //метод десериализации
    public void deserializableJson() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Person.txt"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод вывода списка зарегистрированных пользователей (+ общее количество)
    public void listPerson() {

    }

    //метод изменения параметров пользователя
    public void editPerson() {

    }

    //метод удаления пользователя
    public void deletePerson() {

    }
}
