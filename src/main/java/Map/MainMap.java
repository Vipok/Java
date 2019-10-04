package Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainMap {
    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayPerson arrayPerson = new ArrayPerson();
        Person person1 = new Person("Person1", "Pass1");
        Person person2 = new Person("Person2", "Pass2");
        arrayPerson.list.add(person1);
        arrayPerson.list.add(person2);
        String result = objectMapper.writeValueAsString(arrayPerson);
        System.out.println(result);
    }
}
