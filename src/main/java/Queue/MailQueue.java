package Queue;

import lombok.Getter;
import lombok.Setter;

public class MailQueue<T> implements QueueInterface<T> {
    //указатель на первый элемент
    private GenericMethods head = null;
    //указатель на последний элемент
    private GenericMethods tail = null;
    //размер очереди
    private int size = 0;

    @Override
    public void push(T t) {
        //создаем вспомогательный объект, который мы сразу помещаем в него.
        GenericMethods abstractObject = new GenericMethods();
        abstractObject.setT(t);
        //если очередь пустая - в ней нет еще элементов.
        if (head == null) {
            head = abstractObject;
            //теперь head указывает на первый элемент
        } else {
            tail.setNext(abstractObject);
            //в любом случае tail указываем на новый элемент, даже если он первый.
        }
        tail = abstractObject;
        //увеличиваем размер очереди.
        size++;
    }

    @Override
    public T pull() {
        //если очередь еще пустая, то возвращаем null
        if (head == null) {
            return null;
        }
        //получаем наш объект из вспомогательного класса
        T t = head.getT();
        //перемещаем head на следующий элемент
        head = head.getNext();
        //если это был единственный элемент, то head станет равен null
        //и тогда tail тоже должен указать на null
        if (head == null) {
            tail = null;
        }
        //уменьшаем размер очереди
        size--;
        //возвращаем значение
        return t;
    }

    @Override
    public T get(int index) {
        //если нет элементов, индекс больше размера или меньше нуля, то возвращаем null
        if (size == 0 || index >= size || index < 0) {
            return null;
        }
        //устанавливаем указатель, который будем перемещать на head
        GenericMethods current = head;
        //в этом случае позиция равна нулю
        int pos = 0;
        //пока позиция не достигла нужного индекса
        while (pos <= index) {
            //перемещаемся на следующий элемент
            current = current.getNext();
            pos++;
        }
        //найден нужный элемент, возвращаем его.
        T t = current.getT();
        return t;
    }

    @Override
    public int size() {
        return size;
    }

    //вспомогательный класс, изолированный от остальных классов с помощью private
    @Getter
    @Setter
    private class GenericMethods {
        //поле для хранения объекта
        private T t;
        //поле для указания на следующий элемент в очереди
        //если оно равно null, то это последний элемент
        private GenericMethods next;
    }
}
