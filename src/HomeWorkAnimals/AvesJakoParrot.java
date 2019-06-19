package HomeWorkAnimals;

public class AvesJakoParrot extends AnimalsAves {

    private int wordsSpoken;//количество произносимых слов

    public int getWordsSpoken(){return wordsSpoken;}
    public void setWordsSpoken(int wordsSpoken){this.wordsSpoken = wordsSpoken;}

    public void speak () {
    System.out.println("Говорить");
}

    public void info(String getNickname, int getWordsSpoken){
    System.out.println("Попугай " + getNickname + "произносит " + getWordsSpoken + " слов.");
}
@Override
    public void battle(){
    System.out.println("Зачем мне драться, если хозяин кормит?");
}
    @Override
    public void nutrition(){
        System.out.println("Скушать зерно");
    }
    @Override
    public void flight(){
        System.out.println("Кружить по клетке");
    }
    @Override
    public void breath(){
        System.out.println("Дышать часто");
    }
    @Override
    public void movement(){
        System.out.println("Не придумал");
    }
    @Override
    public void sleep(){
        System.out.println("Поспать днём");
    }
}
