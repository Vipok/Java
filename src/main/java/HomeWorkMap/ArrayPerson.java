package HomeWorkMap;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
class ArrayPerson {
    private List<Person> list = new ArrayList<>();

    @Getter
    @Setter
    static
    class Person implements Serializable {
        private String login;
        private String password;
        private String updatedDate;

        Person(String login, String password, String updatedDate) {
            this.login = login;
            this.password = password;
            this.updatedDate = updatedDate;
        }

        Person() {

        }
    }
}