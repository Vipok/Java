package HomeWorkAnimals;

public class Animals {

    private String title;//название
    private int lifespan;//продолжительнсть жизни
    private double weight;//масса
    private String color;//цвет
    private int speed;//скорость передвижения
//геты
    protected String getTitle() {
        return title;
    }
    protected int getLifespan() {
        return lifespan;
    }
    protected double getWeight() {
        return weight;
    }
    protected String getColor() {return color;}
    protected int getSpeed() {return speed;}
//сеты
    protected void setTitle(String title) {
        this.title = title;
    }
    protected void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
    protected void setWeight(double weight) { this.weight = weight; }
    protected void setColor(String color) {this.color = color;}
    protected void setSpeed(int speed) {this.speed = speed;}
//методы, присущие животным
    protected void breath(){
        System.out.println("Дыхание");
    }
    protected void nutrition(){
        System.out.println("Питание");
    }
    protected void movement(){
        System.out.println("Движение");
    }
    protected void sleep(){
        System.out.println("Сон");
    }
    protected void info(String getTitle, int getLifespan, double getWeight, String getColor, int getSpeed){
        System.out.println("Вид: " + getTitle + ". Продолжительность жизни: "
                + getLifespan + ". Масса в килограммах: " + getWeight + ". Цвет: " + getColor +
                ". Скорость передвижения: " + getSpeed);
    }

}