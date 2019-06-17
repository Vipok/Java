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
}
