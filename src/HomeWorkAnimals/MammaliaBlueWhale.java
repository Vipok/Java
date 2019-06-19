package HomeWorkAnimals;

public class MammaliaBlueWhale extends AnimalsMammalia {
    private int mostache;//количество усов

    public int getMostache() {return mostache;}
    public void setMostache(int mostache) {this.mostache = mostache;}

    public void fountain(){
        System.out.println("Выпустить фонтан из спины");
    }
    public void collectPlancton(){
        System.out.println("Собирать планктон");
    }
    public void info(String getNickname, int getMostache){
        System.out.println("У кита " + getNickname + " " + getMostache + " усов.");

    }
    @Override
    public void feedingMilk(){
        System.out.println("какой-то пример");
    }
    @Override
    public void breath(){
        System.out.println("какой-то пример");
    }
    @Override
    public void nutrition(){
        System.out.println("какой-то пример");
    }
    @Override
    public void movement(){
        System.out.println("какой-то пример");
    }@Override
    public void sleep(){
        System.out.println("какой-то пример");
    }
    @Override
    public void battle(){
    System.out.println("какой-то пример");
}
}
