package HomeWorkAnimals;

public class ArthropodsSpiders extends AnimalsArthropod{
    public static void main(String[] args) {
        ArthropodsSpiders spider = new ArthropodsSpiders();
        spider.setTitle("Паук");
        spider.setLifespan(2);
        spider.setWeight(0.1);
        spider.setLifespan(8);
        spider.info(spider.getTitle(),spider.getLifespan(),spider.getWeight());
        spider.info(spider.getTitle(),spider.getArticulateLimps());
    }


    private void jumpOnMan(){
        System.out.println("Прыгнуть на человека");
    }
    private void spiderWeb(){
        System.out.println("Выпустить паутину");
    }
    private void catchingFlies(){
        System.out.println("Поймать муху");
    }
}
