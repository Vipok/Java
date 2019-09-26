package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

//имплементируется от Iterable для создания Iteration
public class ArrayListClass<T> implements Iterable<T> {
    //создание массива-дженерика
    private T[] arrayList;

    //конструктор
    public ArrayListClass(T[] arrayLists) {
        this.arrayList = arrayLists;
    }

    //создания метода get для получения элемента массива
    public T get(int index) {
        return arrayList[index];
    }

    //создание метода set для заполнения массива
    public void set(int index, T value) {
        arrayList[index] = value;
    }

    //класс итератора с переопределенными методами
    class ArrayListClassIterator implements Iterator<T> {
        int counter;

        //проверка следующего элемента
        @Override
        public boolean hasNext() {
            if (counter < ArrayListClass.this.arrayList.length) {
                return true;
            } else return false;
        }

        //выбор следующего элемента
        @Override
        public T next() {
            if (hasNext()) {
                return arrayList[counter++];
            } else throw new NoSuchElementException();
        }
    }

    //собственный итератор, для создания которого и требовался интерфейс Iterable
    @Override
    public Iterator<T> iterator() {
        return new ArrayListClassIterator();
    }
}
