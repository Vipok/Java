package HomeWorkAnimals;

public class MammaliaHumans extends AnimalsMammalia {
    private int readSpeed;//скорость чтения (количество слов в минуту)
    private int money;//количество денег

    protected int getReadSpeed(){return readSpeed;}
    protected int getMoney(){return money;}

    protected void setReadSpeed(int readSpeed){this.readSpeed = readSpeed;}
    protected void setMoney(int money) { this.money = money;}


    protected void writingProgram(){
        System.out.println("Написание программы");
    }
    protected void carDriving(){
        System.out.println("Вождение автомобиля");
    }

}
