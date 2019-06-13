package HomeWorkAnimals;

public class Animals {

    private String title;//название
    private int lifespan;//продолжительнсть жизни
    private double weight;//масса
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
//сеты
    protected void setTitle(String title) {
        this.title = title;
    }
    protected void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
    protected void setWeight(double weight) {
        this.weight = weight;
    }
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
    protected void info(String title, int lifespan, double weight){
        System.out.println("Вид: " + title + ". Продолжительность жизни: "
                + lifespan + ". Масса в килограммах: " + weight);
    }

}