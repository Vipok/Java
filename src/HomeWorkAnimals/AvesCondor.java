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
    @Override
    public void flight(){
        System.out.println("Лететь быстро и высоко");
    }
    @Override
    public void breath(){
        System.out.println("Дышать лёгкими");
    }
    @Override
    public void movement(){
        System.out.println("Не придумал");
    }
    @Override
    public void sleep(){
        System.out.println("Крепкий сон - залог продуктивной ловли мышей");
    }
    @Override
    public void battle(){
        System.out.println("Бороться за место под солнцем");
    }
}
