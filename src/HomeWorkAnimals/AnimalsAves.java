package HomeWorkAnimals;

public class AnimalsAves extends Animals {
    private int wingspan;//размах крыльев
    private int beakLenght;//длина клюва
    private int tailLength;//длина хвоста

//геты
    protected int getWingspan() {return wingspan; }
    protected int getBeakLenght() {return beakLenght; }
    protected int getTailLength() {return tailLength;}
//сеты
    protected void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }
    protected void setBeakLenght(int beakLenght) {
        this.beakLenght = beakLenght;
    }
    protected void setTailLength(int tailLength) {this.tailLength = tailLength;}
//методы, присущие птицам
    protected void flight(){ System.out.println("Полёт"); }
    protected void info(String getTitle, int getWingspan ,int getBeakLenght, int getTailLength){
        System.out.println("Вид птицы: " + getTitle() + ". Размах крыла: " + getWingspan + ". Длина клюва: " + getBeakLenght +
                ". Длина хвоста: " + getTailLength);
    }
}
