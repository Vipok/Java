package HomeWorkAnimals;

public class AnimalsArthropod extends Animals {
    private int articulateLimps;//количество членистых конечностей

    protected int getArticulateLimps() {
        return articulateLimps;
    }
    protected void setArticulateLimps(int articulateLimps) {
        this.articulateLimps = articulateLimps;
    }
    protected void scare(){
        System.out.println("Напугать человека");
    }
    protected void info(String title ,int getArticulateLimps){
        System.out.println("Вид: " + title + ". Количество членистых конечностей: " + getArticulateLimps);
    }
}
