package Map;

import com.google.gson.reflect.TypeToken;
import lombok.Getter;

public class JsonPath {
    //класс для библиотеки GSON для указания параметризированного типа.
    @Getter
    private static java.lang.reflect.Type TYPE = new TypeToken<ArrayPerson>(){
    }.getType();
}
