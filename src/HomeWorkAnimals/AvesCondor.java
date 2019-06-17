package HomeWorkAnimals;

public class AvesCondor extends AnimalsAves {
    private int speedSwoop;//скорость пикирования

    public int getSpeedSwoop() {return speedSwoop;}
    public void setSpeedSwoop(int speedSwoop){this.speedSwoop = speedSwoop;}

    public void swoopDown (){
    System.out.println("Пикировать на добычу");
}
    public void info(String getNickname, int getWingspan, int getBeakLenght, int getTailLength, int getSpeedSwoop){
        System.out.println("Информация по кондору " + getNickname + " и бла бла бла...");
}
    @Override
    public void nutrition(){
        System.out.println("Press X чтобы поймать мышь");
    }
}
