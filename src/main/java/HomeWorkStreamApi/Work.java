package HomeWorkStreamApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Work {

    public static void main(String[] args) {
        String symbols = "0123456789";
        StringBuilder randString = new StringBuilder();
        int count = 60 + (int) (Math.random() * 42);
        for (int i = 0; i < count; i++)
            randString.append(symbols.charAt((int) (Math.random() * symbols.length())));

        System.out.println(randString);
        List<Character> characters = randString.chars().mapToObj(m -> (char) m).collect(Collectors.toList());
        Map<Character, Integer> counts = characters.stream().collect(HashMap::new, (m, c) -> {
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }, HashMap::putAll);
        System.out.println(characters.size());

        //отладка метода процентов
        ArrayList<Double> doubles = new ArrayList<>();


        for (Map.Entry<Character, Integer> i : counts.entrySet()) {
            System.out.println("Число: " + i.getKey() + ", Количество: " + i.getValue() + ", процент: " +
                    calculationOfPercent(i.getValue().doubleValue(), Double.parseDouble(String.valueOf(characters.size()))));

            //отладка метода процентов
          doubles.add(calculationOfPercent(i.getValue().doubleValue(), Double.parseDouble(String.valueOf(characters.size()))));
        }


        //отладка метода процентов
        double d = 0.0;
        for (Double aDouble : doubles) {
            d = d + aDouble;
        }
        System.out.println("\n" + d);
        //конец отладки
    }

    private static double calculationOfPercent(Double value, Double size) {
        return value * 100/size;
    }
}
