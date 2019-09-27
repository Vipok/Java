package List2;

//интерфейс с методами для ArrayList'a
public interface ArrayListMethods<T> extends Iterable<T> {
    boolean add(T t);

    void delete(int index);

    T get(int index);

    int size();

    void update(int index, T t);
}
