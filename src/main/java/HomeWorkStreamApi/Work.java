package HomeWorkStreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Work {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(1);
        Map<Integer, Integer> count = list.stream().collect(HashMap::new, (m, c) -> {
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }, HashMap::putAll);
        for (Map.Entry<Integer, Integer> i : count.entrySet()) {
            System.out.println("Число: " + i.getKey() + ", Количество: " + i.getValue());
        }
    }
}
