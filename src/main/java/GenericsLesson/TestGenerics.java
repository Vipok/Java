package GenericsLesson;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Vipok
 */

public class TestGenerics {
    private static Object[] objects = new Object[4];

    public static void main(String[] args) {
        Generic<String> stringGeneric = new Generic<>("test");
        addObjectInArray(stringGeneric);
        Generic<Integer> integerGeneric = new Generic<>(43);
        addObjectInArray(integerGeneric);
        Generic<Double> doubleGeneric = new Generic<>(23.12);
        addObjectInArray(doubleGeneric);
        Generic<Boolean> booleanGeneric = new Generic<>(true);
        addObjectInArray(booleanGeneric);
        for (Object object : objects) {
            System.out.println("Значение: " + object + ", тип: " + object.getClass());
        }
    }

    //метод добавления данных в массив
    private static void addObjectInArray(Generic generic) {
        for (int j = 0; j < objects.length; j++) {
            if (objects[j] == null) {
                objects[j] = generic.getTestParams();
                j = objects.length;
            }
        }
    }
}

class Generic<T> {
    @Getter
    @Setter
    private T testParams;

    Generic(T testParams) {
        this.testParams = testParams;
    }
}

