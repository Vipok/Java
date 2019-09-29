package List2;

import java.util.Iterator;

public class Stock {
    public static void main(String[] args) {
        //создание пародии на ArrayList
        MyArrayList<Products> myArrayList = new MyArrayList();
        //генерим данные для массива
        Products products1 = new Products("Potato", 23);
        Products products2 = new Products("Hammer", 12);
        Products products3 = new Products("Socket", 233);
        Products products4 = new Products("Cherry", 343);
        //помещаем данные в массив
        myArrayList.add(products1);
        myArrayList.add(products2);
        myArrayList.add(products3);
        myArrayList.add(products4);

        //аналог forEach (выводит 4 элемента)
        Iterator<Products> iterator = myArrayList.iterator();
        try {
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
        //размер массива (4)
        System.out.println("Array size: " + myArrayList.size());
        //удаление элемента
        myArrayList.delete(2);//разобраться с методом delete (он увеличивает массив, а не уменьшает)
        //вернётся последний элемент, вместо предпоследнего
        System.out.println(myArrayList.get(2));
        //размер массива (3)
        System.out.println("Array size: " + myArrayList.size());
        //апдейт элемента
        Products productsUpdate = new Products("Computer", 32);
        myArrayList.update(2, productsUpdate);
        //вернется новый объект
        System.out.println(myArrayList.get(2));
        //размер также равен трём
        System.out.println("Array size: " + myArrayList.size());
    }
}