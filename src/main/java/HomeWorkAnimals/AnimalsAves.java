package HomeWorkAnimals;

    abstract class AnimalsAves extends Animals {
    private int wingspan;//размах крыльев
    private int beakLenght;//длина клюва
    private int tailLength;//длина хвоста

//геты
    public int getWingspan() {return wingspan; }
     public int getBeakLenght() {return beakLenght; }
     public int getTailLength() {return tailLength;}

//сеты
    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }
     public void setBeakLenght(int beakLenght) {
        this.beakLenght = beakLenght;
    }
     public void setTailLength(int tailLength) {this.tailLength = tailLength;}

//методы, присущие птицам
    public abstract void flight();//полет
    }

