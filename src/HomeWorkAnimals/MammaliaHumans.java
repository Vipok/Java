package HomeWorkAnimals;

public class MammaliaHumans extends AnimalsMammalia {
    private String name;
    private String sername;
    private int readSpeed;//скорость чтения (количество слов в минуту)
    private int money;//количество денег

    protected int getReadSpeed(){return readSpeed;}
    protected int getMoney(){return money;}
    protected String getName(){return name;}
    protected String getSername(){return sername;}

    protected void setReadSpeed(int readSpeed){this.readSpeed = readSpeed;}
    protected void setMoney(int money) { this.money = money;}
    protected void setName(String name) {this.name = name;}
    protected void setSername(String sername) {this.sername = sername;}


    protected void writingProgram(){
        System.out.println("Написание программы");
    }
    protected void carDriving(){
        System.out.println("Вождение автомобиля");
    }

    protected void info(String getName, String getSername, int getMoney, int getReadSpeed){
        System.out.println("Имя: " + getName + ". Фамилия: " + getSername + ". Скорость чтения равна " +
                readSpeed + " слов в минуту. На его счету " + getMoney + " евро.");
    }
}

