package HomeWorkJavaCore;

public class Kittens {
    private String nickname;//кличка
    private int age;//возраст в днях
    private int growth;//рост в сантиметрах
    private int weight;//вес в граммах
    private String color;//цвет
    //сеттеры
    public String getNickname(){return nickname;}
    public int getAge() {return age;}
    public int getGrowth(){return growth;}
    public int getWeight(){return weight;}
    public String getColor(){return color;}
    //геттеры
    public void setNickname(String nickname){this.nickname = nickname;}
    public void setAge(int age){this.age = age;}
    public void setGrowth(int growth){this.growth = growth;}
    public void setWeight(int weight){this.weight = weight;}
    public void setColor(String color){this.color = color;}

    public void addKittens(String getNickname, int getAge, int getGrowth, int getWeight, String getColor){
        System.out.println("Вы успешно добавили котёнка: \nКличка: " + getNickname() +
                "\nВозраст (в днях): " + getAge() + "\nРост (в сантиметрах): " + getGrowth() +
                "\nВес (в граммах): " + getWeight() + "\nЦвет: " + getColor());
    }

    public static void main(String[] args) {
        Kittens barsic = new Kittens();
        barsic.setNickname("Barsic");
        barsic.setAge(29);
        barsic.setGrowth(21);
        barsic.setWeight(300);
        barsic.setColor("Gray");
        barsic.addKittens(barsic.getNickname(),barsic.getAge(), barsic.getGrowth(), barsic.getWeight(),
                barsic.getColor());
    }
}

