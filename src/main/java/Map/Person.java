package Map;

import lombok.Getter;
import lombok.Setter;

public class Person {
    private int size;
    private int id = size + 1;
    @Setter
    @Getter
    private String login;
    @Setter
    @Getter
    private String password;

    Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String toString() {
        return "{\n\"login\": " + login + ",\n\"password\": " + password + "\n}";
    }
}

