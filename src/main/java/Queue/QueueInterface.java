package Queue;

public interface QueueInterface<T> {
    //положить объект в очередь
    public void push(T t);

    //вытащить объект из очереди
    public T pull();

    //размер очереди
    int size();

    //возврат элементов по индексу (без возможности изменения).
    public T get(int index);

    //прокинуть объект в начало очереди
    public void pushPriority(T t);

    //проверка наполненности очереди
    boolean checkQueue();
}
