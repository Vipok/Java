package HomeWorkAnimals;

public class PiscesSalpa extends AnimalsPisces {
    private String colorOfScales;

    protected String getColorOfScales() {return colorOfScales;}
    protected void setColorOfScales(String colorOfScales){this.colorOfScales = colorOfScales;}

    protected void changeColor(String getColorOfScales){
        System.out.println("Цвет Салпы сейчас: " + getColorOfScales );
    }

}
