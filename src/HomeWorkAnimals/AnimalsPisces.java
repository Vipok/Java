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
    public void averageInfo (String getTitle, int getFins, int getGillSlits, int getImmersionDepth){
        System.out.println("Усредненная информация по виду " + getTitle + ", относящемуся к подтипу рыб: " +
                "количество плавников равно " + getFins + ", количество жаберных щелей равно " + getGillSlits +
                ", средняя глубина погружения - " + getImmersionDepth + ".");
    }
    public void becomeACatch(){
       System.out.println("Стать уловом");
    }
}

