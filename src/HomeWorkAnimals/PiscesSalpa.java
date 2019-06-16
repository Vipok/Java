package HomeWorkAnimals;

public class PiscesSalpa extends AnimalsPisces {
    protected int colorOfScales;

    protected int getColorOfScales() {return colorOfScales;}
    protected void setColorOfScales(int colorOfScales){this.colorOfScales = colorOfScales;}

    protected void changeColor(){
        System.out.println("Изменить цвет на " + colorOfScales);
    }

}
