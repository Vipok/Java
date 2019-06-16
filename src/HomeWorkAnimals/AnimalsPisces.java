package HomeWorkAnimals;

public class AnimalsPisces extends Animals {

    private int fins;//количество плавников
    private int gillSlits;//жаберные щели
    private int immersionDepth;//глубина погружения

    protected int getFins() {return fins; }
    protected int getGillSlits() {return gillSlits; }
    protected int getImmersionDepth() {return immersionDepth;}

    protected void setFins(int fins){this.fins = fins;}
    protected void setGillSlits(int gillSlits){this.gillSlits = gillSlits;}
    protected void setImmersionDepth(int immersionDepth){this.immersionDepth = immersionDepth;}

    protected void swimming (){
        System.out.println("Плавание");
    }
}
