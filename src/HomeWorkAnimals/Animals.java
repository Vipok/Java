package HomeWorkAnimals;

 class Animals {

    private String title;//название вида
    private String nickname;//кличка отдельного животного
    private int age;//возраст в годах
    private double weight;//масса
    private String color;//цвет
    private int maxSpeed;//максимальная скорость передвижения
//геты
    public String getTitle() {
        return title;
    }
     public String getNickname() {return nickname;}
     public int getAge() {
        return age;
    }
     public double getWeight() {
        return weight;
    }
     public String getColor() {return color;}
     public int getMaxSpeed() {return maxSpeed;}
//сеты
    public void setTitle(String title) {
        this.title = title;
    }
     public void setNickname(String nickname){this.nickname = nickname;}
     public void setAge(int age) {
        this.age = age;
    }
     public void setWeight(double weight) { this.weight = weight; }
     public void setColor(String color) {this.color = color;}
     public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}
//методы, присущие животным
    public void breath(){
        System.out.println("Дыхание");
    }
     public void nutrition(){
        System.out.println("Питание");
    }
     public void movement(){
        System.out.println("Передвижение");
    }
     public void sleep(){
        System.out.println("Сон");
    }
     public void battle(){ System.out.println("Драться за выживание"); }

    }

