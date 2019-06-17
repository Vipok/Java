package HomeWorkAnimals;

public class MammaliaHumans extends AnimalsMammalia {
    private String name;
    private String sername;
    private int readSpeed;//скорость чтения (количество слов в минуту)
    private int money;//количество денег

    public int getReadSpeed(){return readSpeed;}
    public int getMoney(){return money;}
    public String getName(){return name;}
    public String getSername(){return sername;}

    public void setReadSpeed(int readSpeed){this.readSpeed = readSpeed;}
    public void setMoney(int money) { this.money = money;}
    public void setName(String name) {this.name = name;}
    public void setSername(String sername) {this.sername = sername;}


    public void writingProgram(){
        System.out.println("Написание программы");
    }
    public void carDriving(){
        System.out.println("Вождение автомобиля");
    }

    public void info(String getName, String getSername, int getAge, int getMoney, int getReadSpeed){
        System.out.println("Имя: " + getName + ". Фамилия: " + getSername + ". К " + getAge +
                " годам у неё (него) скорость чтения равна " + readSpeed + " слов в минуту. На её (его) счету "
                + getMoney + " евро.");
    }

    @Override
    public void quiletLife(){
        System.out.println("Какая тут спокойная жизнь, если пора на завод?");
    }

    public static void main(String[] args) {
        AnimalsMammalia s = new AnimalsMammalia();
        AnimalsMammalia s1 = new MammaliaHumans();
        s.quiletLife();
        s1.quiletLife();
    }
}

