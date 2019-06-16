package HomeWorkAnimals;

public class MammaliaBlueWhale extends AnimalsMammalia {
    private int mostache;//количество усов

    protected int getMostache() {return mostache;}
    protected void setMostache(int mostache) {this.mostache = mostache;}

    protected void fountain(){
        System.out.println("Выпустить фонтан из спины");
    }
    protected void collectPlancton(){
        System.out.println("Собирать планктон");
    }
}
