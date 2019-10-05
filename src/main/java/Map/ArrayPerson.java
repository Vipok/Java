package Map;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
class ArrayPerson implements Serializable {
    List<Person> list = new ArrayList<>();
}