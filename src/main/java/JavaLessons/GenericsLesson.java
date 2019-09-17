package JavaLessons;

import java.util.List;
import java.util.ArrayList;

public class GenericsLesson {
    public static void main(String[] args) {
        ///////////// Java 5 //////////////
        Animal outAnimal = new Animal();
        List animals = new ArrayList();
        animals.add("cat");
        animals.add("dog");
        animals.add("frog");
        animals.add(outAnimal);

        String animal = (String) animals.get(3);
        System.out.println(animal);

        ////////////  Generics  ////////////

        List<String> animals2 = new ArrayList<String>();
        animals2.add("cat");
        animals2.add("dog");
        animals2.add("frog");
        String animal2 = animals2.get(1);
        System.out.println(animal2);
    }

    //////////////// Java 7///////////////

    List<String> animals3 = new ArrayList<>();

}

class Animal {

}

