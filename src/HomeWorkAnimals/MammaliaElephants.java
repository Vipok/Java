package HomeWorkAnimals;

public class MammaliaElephants extends AnimalsMammalia {
    private int proboscisLength;//длина хобота
    private int tuskLength;//длина бивней

    public int getProboscisLength(){ return proboscisLength;}
    public int getTuskLength() {return tuskLength;}

    public void setProboscisLength(int proboscisLength){this.proboscisLength = proboscisLength;}
    public void setTuskLength(int tuskLength){this.tuskLength = tuskLength;}

    public void useProboscis(){
        System.out.println("Использовать хобот");
    }
    public void info(String getNickname, int proboscisLength, int tuskLength){
        System.out.println("У слона " + getNickname + " длина хобота равна...");
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
