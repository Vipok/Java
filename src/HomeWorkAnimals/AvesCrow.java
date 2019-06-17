package HomeWorkAnimals;

public class AvesCrow extends AnimalsAves {
    private int amountOfStolen;

    public int getAmountOfStolen(){return amountOfStolen;}
    public void setAmountOfStolen(int amountOfStolen){this.amountOfStolen = amountOfStolen;}

    public void stealShine (){
        System.out.println("Своровать блестяшку");
    }

    public void info(String getNickname, int getAmountOfStolen){
        System.out.println("Информация по вороне " + getNickname + ". Она за свою жизнь своровала...");
    }
    @Override
    public void battle(){
        System.out.println("Дерись не дерись, а блестяшку заберу");
    }
}
