package HomeWorkAnimals;

 class AnimalsAves extends Animals {
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
    public void flight(String getNickname){ System.out.println("Полёт"); }

     public void averageInfo(String getTitle, int getWingspan ,int getBeakLenght, int getTailLength){
        System.out.println("Усредненная информация по виду  " + getTitle() + ", который относится к подтипу птиц: " +
                "cредний размах крыла равен: " + getWingspan + ", cредняя длина клюва равна: "
                + getBeakLenght + ", cредняя длина хвоста равна: " + getTailLength);
    }
    }
