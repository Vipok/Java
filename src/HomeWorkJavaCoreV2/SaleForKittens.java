package HomeWorkJavaCoreV2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SaleForKittens {

    public SaleForKittens() throws IOException {
    /*логика продажи котенка
    1. Ввести ID котенка.
    2. Подтвердить, что нужно удалить именно этого котенка (вывести строку с параметрами данного котенка). Проверка
    именно по файлу со списком котят на продаже, дабы избежать продажи котят, которые не выставлены.
    3. Выполнить удаление котенка из списка на продажу: записываем в буффер данные while (через if исключаем нужную запись)
    4. Выполнить удаление котенка из списка существующих котят: аналогично шагу 3.
     */

        File file = new File("KittensList.txt");
        File fileCheck = new File("SaleList.txt");
        Scanner scanner = new Scanner(System.in);
        Kittens kittens = new Kittens();
        System.out.println("Введите id котенка, которого нужно продать: ");
        kittens.setId(scanner.nextLong());
        //1 - done
        FileInputStream stream = new FileInputStream(file);
        int length = stream.available();
        byte[] data = new byte[length];
        stream.read(data);
        String text = new String(data);
        ArrayList<String[]> kitten = new ArrayList<>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] params = line.split(", ");
            kitten.add(params);
            System.out.println(Arrays.toString(params));
        }
        for (String[] params : kitten) {
            if (params[0].equals("Id: " + kittens.getId())) {
                String par = Arrays.toString(params);
                System.out.println(Arrays.toString(params));
            }
        }
    }
}
