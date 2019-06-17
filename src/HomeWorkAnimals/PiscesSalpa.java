package HomeWorkAnimals;

public class PiscesSalpa extends AnimalsPisces {
    private String colorOfScales;

    public String getColorOfScales(String getNickname) {return colorOfScales;}
    public void setColorOfScales(String colorOfScales){this.colorOfScales = colorOfScales;}

    public void changeColor(String getNickname, String getColorOfScales){
        System.out.println("Цвет у " + getNickname + " в данный момент - " + getColorOfScales );
    }
    @Override
    public void becomeACatch(){
        System.out.println("Стану невидимой и не поймают");
    }

}
