package JavaLessons;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsLessons {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        //вывод в консоль через foreach
        for (String s : list) {
            System.out.println(s);
        }
//        Stream<String> stream = list.stream();
//        stream.forEach(x -> System.out.println(x));
        list.stream().forEach(x -> System.out.println(x));
    }
}
