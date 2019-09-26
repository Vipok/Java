package List;

import java.util.Iterator;

class Stock {
    private final static int maxStockVolume = 10;
    private static Products[] goods = new Products[maxStockVolume];

    //главный метод
    public static void main(String[] args) {
        //добавление каких-то товаров
        Products products1 = new Products("Potato", 23);
        addGoodsToStock(products1);
        Products products2 = new Products("Hammer", 12);
        addGoodsToStock(products2);
        Products products3 = new Products("Socket", 233);
        addGoodsToStock(products3);
        Products products4 = new Products("Cherry", 343);
        addGoodsToStock(products4);
        //создаем собственное подобие на ArrayList
        ArrayListClass<Products> stock = new ArrayListClass(goods);
        //создаем собственный итератор
        Iterator<Products> iterator = stock.iterator();
        //пример работы метода set собственного массива
        stock.set(4, new Products("Banana", 1));
        //пример работы get собственного массива
        System.out.println(stock.get(2) + " - example");
        //пародия на foreach
        try {
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        } catch (NullPointerException ex) {
            ex.getMessage();
        }
    }

    //метод добавления товара в массив goods
    private static void addGoodsToStock(Products products) {
        for (int i = 0; i < goods.length; i++) {
            if (goods[i] == null) {
                goods[i] = products;
                i = goods.length;
            }
        }
    }
}