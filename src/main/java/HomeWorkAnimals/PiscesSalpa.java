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
    @Override
    public void swimming(){
        System.out.println("Какое-то необычное действие");
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
    }
    @Override
    public void sleep(){
        System.out.println("какой-то пример");
    }
    @Override
    public void battle(){
        System.out.println("какой-то пример");
    }

}
