package HomeWorkAnimals;

public class PiscesPufferFish extends AnimalsPisces {

    private int spikes;

    public int getSpikes(){return spikes;}
    public void setSpikes(int spikes){this.spikes = spikes;}

    public void bloatBalloon (String getNickname){
        System.out.println("Раздуться в шар");
    }
    public void info(String getNickname, int getSpikes){
        System.out.println("Количество шипов у " + getNickname + " равно " + spikes);
    }
    @Override
    public void becomeACatch(){
        System.out.println("Раздуться до размеров вселенной!!!");
    }
}
