package HomeWorkAnimals;

public class PiscesPufferFish extends AnimalsPisces {

    private int spikes;

    protected int getSpikes(){return spikes;}
    protected void setSpikes(int spikes){this.spikes = spikes;}

    protected void bloatBalloon (){
        System.out.println("Раздуться в шар");
    }

}
