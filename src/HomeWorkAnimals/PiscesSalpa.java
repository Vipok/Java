package HomeWorkAnimals;

public class PiscesSalpa extends AnimalsPisces {
    protected String colorOfScales;

    protected String getColorOfScales() {return colorOfScales;}
    protected void setColorOfScales(String colorOfScales){this.colorOfScales = colorOfScales;}

    protected void changeColor(){
        System.out.println("Изменить цвет на " + colorOfScales);
    }

}
