package HomeWorkAnimals;

public class MammaliaElephants extends AnimalsMammalia {
    private int proboscisLength;//длина хобота
    private int tuskLength;//длина бивней

    protected int getProboscisLength(){ return proboscisLength;}
    protected int getTuskLength() {return tuskLength;}

    protected void setProboscisLength(int proboscisLength){this.proboscisLength = proboscisLength;}
    protected void setTuskLength(int tuskLength){this.tuskLength = tuskLength;}

    protected void useProboscis(){
        System.out.println("Использовать хобот");
    }

}
