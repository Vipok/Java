package Map;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Person implements Serializable {
    private String login;
    private String password;
    private String updatedDate;

    Person(String login, String password, String updatedDate) {
        this.login = login;
        this.password = password;
        this.updatedDate = updatedDate;
    }

    Person(){

    }
}

