package HomeWorkList;

import java.util.Iterator;

public class MyArrayList<T> implements ArrayListMethods<T> {

    //массив, состваляющий основу ArrayList'а
    private T[] values;

    public MyArrayList() {
        values = (T[]) new Object[0];
    }

    @Override
    public boolean add(T t) {
        //из-за даункаста оборачиваем в try-catch
        try {
            //создание временного массива
            T[] tempArray = values;
            //новый массив, размер которого увеличили на единицу
            values = (T[]) new Object[tempArray.length + 1];
            //копирование из временного массива в основной
            System.arraycopy(tempArray, 0, values, 0, tempArray.length);
            //присваиваем последнему элементу нужное значение
            values[values.length - 1] = t;
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        //из-за даункаста оборачиваем в try-catch
        try {
            T[] tempArray = values;
            values = (T[]) new Object[tempArray.length - 1];
            //копируем часть временного массива до индекса (не включительно)
            System.arraycopy(tempArray, 0, values, 0, index);
            //вычисляем остаток, сколько элементов осталось скопировать
            int residue = tempArray.length - (index + 1);
            //копируруем остаток массива после индекса (не включительно)
            System.arraycopy(tempArray, index + 1, values, index, residue);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T t) {
        //обновляет значение на новое по индексу
        values[index] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }
}
