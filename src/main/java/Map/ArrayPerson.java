package Map;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
class ArrayPerson {
    List<Person> list = new ArrayList<>();
}