package HomeWorkSort;

public class ShellSort {
    public static void main(String[] args) {
        //заполняем массив числами
        int[] a = {5, 6, 4, 8, 1, 9, 3, 2};
        /*
        b равняется половине массива. Это будет расстояние между сравниваемыми числами.
        Пример: массив из 8 чисел. b = 4 (половина).
        Значит сравнение будет в таком виде (номера элементов, начиная с 0):
        0-4, 1-5, 2-6, 3-7
        Если левое число больше правого, то они меняются местами, если меньше, то перебор идет дальше
         */
        int b = a.length / 2;
        //цикл работает только до тех пор, пока b не станет равна 0.
        while (b > 0) {
                /*
                цикл перебора значений и их сравнения (описание выше на примере).
                 */
            for (int i = 0; i < a.length - b; i++) {
                //в скобках список условий работы цикла. Срабатывает только тогда, когда левый элемент больше правого
                for (int j = i; j >= 0 && (a[j] > a[j + b]); j--) {
                    //три строки - реализация перестановки элементов
                    int c = a[j];
                    a[j] = a[j + b];
                    a[j + b] = c;
                }
            }
                /*
                деление b на 2 сделано для того, чтобы теперь снизить область сравнения. Ранее рассматриваемый пример:
                теперь b равно не 4, а 2-м.
                Сравнение: 0-2, 1-3, 2-4, 3-5, 4-6, 5-7
                после этого произойдет еще деление на 2 (так как продолжает свою работу цикл while).
                сравниваться будут элементы 0-1, 1-2...6-7
                после следующего деления b станет равным 0, так как 1/2 = 0.5 (int вмещает в себя только целую часть,
                а значит он будет равен 0). В результате цикл закончит свою работу.
                 */
            b = b / 2;
        }
        //простой вывод отсортированных элементов в консоль. Такой цикл называется for-each
        for (int n : a
        ) {
            System.out.print(n + " ");
        }
    }
}