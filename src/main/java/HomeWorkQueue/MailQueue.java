package HomeWorkQueue;

import lombok.Getter;
import lombok.Setter;

public class MailQueue<T> implements QueueInterface<T> {
    //указатель на первый элемент
    private ObjectBox head = null;
    //указатель на последний элемент
    private ObjectBox tail = null;
    //размер очереди
    private int size = 0;

    @Override
    public void push(T t) {
        //создаем вспомогательный объект, в который сразу помещаем новый элемент t
        ObjectBox objectBox = new ObjectBox();
        objectBox.setT(t);
        //если очередь пустая - в ней нет еще элементов.
        if (checkQueue()) {
            head = objectBox;
            //теперь head указывает на первый элемент
        } else {
            //если это не первый элемент, то последний элемент в очереди будет указывать на новый элемент
            tail.setNext(objectBox);
        }
        //в любом случае tail указываем на новый элемент, даже если он первый.
        tail = objectBox;
        //увеличиваем размер очереди.
        size++;
    }

    @Override
    public void pushPriority(T t) {
        //создаем вспомогательный объект, который мы сразу помещаем в него.
        ObjectBox objectBox = new ObjectBox();
        objectBox.setT(t);
        //если очередь пустая - в ней нет еще элементов.
        if (checkQueue()) {
            tail = objectBox;
            //теперь head указывает на первый элемент
        } else {
            //если head !=0, то вспомогательный объект будет указывать на бывшый первый объект
            objectBox.setNext(head);
        }
        head = objectBox;
        //увеличиваем размер очереди.
        size++;
    }

    @Override
    public T pull() {
        //если очередь еще пустая, то возвращаем null
        if (checkQueue()) {
            return null;
        }
        //получаем наш объект из вспомогательного класса
        T t = head.getT();
        //перемещаем head на следующий элемент
        head = head.getNext();
        //если это был единственный элемент, то head станет равен null
        //и тогда tail тоже должен указать на null
        if (checkQueue()) {
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
        ObjectBox current = head;
        //в этом случае позиция равна нулю
        int pos = 0;
        //пока позиция не достигла нужного индекса
        while (pos < index) {
            //перемещаемся на следующий элемент
            current = current.getNext();
            pos++;
        }
        //найден нужный элемент, возвращаем его.
        return current.getT();
    }

    //проверка наполненности очереди
    @Override
    public boolean checkQueue() {
        if (size == 0 || head == null || tail == null) {
            return true;
        } else return false;
    }

    @Override
    public int size() {
        return size;
    }

    //вспомогательный класс, изолированный от остальных классов с помощью private
    @Getter
    @Setter
    private class ObjectBox {
        //поле для хранения объекта
        private T t;
        //поле для указания на следующий элемент в очереди
        //если оно равно null, то это последний элемент
        private ObjectBox next;
    }
}
