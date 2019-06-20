package HomeWorkAnimals;

 abstract class AnimalsPisces extends Animals {

    private int fins;//количество плавников
    private int gillSlits;//жаберные щели
    private int immersionDepth;//глубина погружения в метрах

    public int getFins() {return fins; }
    public int getGillSlits() {return gillSlits; }
    public int getImmersionDepth() {return immersionDepth;}

    public void setFins(int fins){this.fins = fins;}
    public void setGillSlits(int gillSlits){this.gillSlits = gillSlits;}
    public void setImmersionDepth(int immersionDepth){this.immersionDepth = immersionDepth;}

    public abstract void swimming();//плавание
}

