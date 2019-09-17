package HomeWorkAnimals;

 abstract class AnimalsMammalia extends Animals {

    private int viviparousChildren;//количество живорожденных детей
    private int teeth;//количество зубов


     public int getViviparousChildren() { return viviparousChildren; }
     public int getTeeth() {return teeth;}

     public void setViviparousChildren(int viviparousChildren) {
        this.viviparousChildren = viviparousChildren;
    }
     public void setTeeth(int teeth) { this.teeth = teeth; }

     public abstract void feedingMilk ();

}
