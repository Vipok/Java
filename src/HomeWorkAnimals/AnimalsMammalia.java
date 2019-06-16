package HomeWorkAnimals;

public class AnimalsMammalia extends Animals {

    private String blood;

    protected String getBlood() {
        return blood;
    }
    protected void setBlood(String blood) {
        this.blood = blood;
    }

    protected void feedingMilk (){
        System.out.println("Кормление молоком");
    }
}
