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
    @Override
    public void nutrition(){
        System.out.println("Скушать пакет");
    }
    @Override
    public void flight(){
        System.out.println("Парить над мусоркой");
    }
    @Override
    public void breath(){
        System.out.println("Дышать и кричать");
    }
    @Override
    public void movement(){
        System.out.println("Переминаться с лапы на лапу");
    }
    @Override
    public void sleep(){
        System.out.println("Поспать днём");
    }
}
