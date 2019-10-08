package HomeWorkList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private int index = 0;
    private T[] values;

    ArrayIterator(T[] values) {
        this.values = values;
    }

    //метод итератора для проверки следующего элемента
    @Override
    public boolean hasNext() {
        if (index < values.length) {
            return true;
        } else return false;
    }

    //метод итератора для возврата следующего элемента
    @Override
    public T next() {
        if (hasNext()) {
            return values[index++];
        } else throw new NoSuchElementException();
    }
}
