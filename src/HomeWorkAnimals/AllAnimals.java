package HomeWorkAnimals;

public class AllAnimals {

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
    class AnimalsAves extends HomeWorkAnimals.Animals {
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
    class AnimalsMammalia extends HomeWorkAnimals.Animals {

        private int viviparousChildren;//количество живорожденных детей
        private int teeth;//количество зубов


        public int getViviparousChildren() { return viviparousChildren; }
        public int getTeeth() {return teeth;}

        public void setViviparousChildren(int viviparousChildren) {
            this.viviparousChildren = viviparousChildren;
        }
        public void setTeeth(int teeth) { this.teeth = teeth; }

        public void feedingMilk (String getNickname){
            System.out.println("Кормление молоком");
        }
        public void averageInfo(String getTitle, int getViviparousChildren, int getTeeth){
            System.out.println("Усредненная информация по виду " + getTitle + ", относящемуся к подтипу млекопитающих:" +
                    " cреднее количество живорожденных детей за жизнь равно " + getViviparousChildren +
                    ", среднее количество зубов равно " +getTeeth + ".");
        }
        protected void quiletLife(){
            System.out.println("Спокойная жизнь");
        }

    }
    class AnimalsPisces extends HomeWorkAnimals.Animals {

        private int fins;//количество плавников
        private int gillSlits;//жаберные щели
        private int immersionDepth;//глубина погружения в метрах

        public int getFins() {return fins; }
        public int getGillSlits() {return gillSlits; }
        public int getImmersionDepth() {return immersionDepth;}

        public void setFins(int fins){this.fins = fins;}
        public void setGillSlits(int gillSlits){this.gillSlits = gillSlits;}
        public void setImmersionDepth(int immersionDepth){this.immersionDepth = immersionDepth;}

        public void swimming (String getNickname){
            System.out.println("Плавание");
        }
        public void averageInfo (String getTitle, int getFins, int getGillSlits, int getImmersionDepth){
            System.out.println("Усредненная информация по виду " + getTitle + ", относящемуся к подтипу рыб: " +
                    "количество плавников равно " + getFins + ", количество жаберных щелей равно " + getGillSlits +
                    ", средняя глубина погружения - " + getImmersionDepth + ".");
        }
        public void becomeACatch(){
            System.out.println("Стать уловом");
        }
    }
    public class AvesCondor extends HomeWorkAnimals.AnimalsAves {
        private int speedSwoop;//скорость пикирования

        public int getSpeedSwoop() {return speedSwoop;}
        public void setSpeedSwoop(int speedSwoop){this.speedSwoop = speedSwoop;}

        public void swoopDown (){
            System.out.println("Пикировать на добычу");
        }
        public void info(String getNickname, int getWingspan, int getBeakLenght, int getTailLength, int getSpeedSwoop){
            System.out.println("Информация по кондору " + getNickname + " и бла бла бла...");
        }
        @Override
        public void nutrition(){
            System.out.println("Press X чтобы поймать мышь");
        }
    }
    public class AvesCrow extends HomeWorkAnimals.AnimalsAves {
        private int amountOfStolen;

        public int getAmountOfStolen(){return amountOfStolen;}
        public void setAmountOfStolen(int amountOfStolen){this.amountOfStolen = amountOfStolen;}

        public void stealShine (){
            System.out.println("Своровать блестяшку");
        }

        public void info(String getNickname, int getAmountOfStolen){
            System.out.println("Информация по вороне " + getNickname + ". Она за свою жизнь своровала...");
        }
        @Override
        public void battle(){
            System.out.println("Дерись не дерись, а блестяшку заберу");
        }
    }
    public class AvesJakoParrot extends HomeWorkAnimals.AnimalsAves {

        private int wordsSpoken;//количество произносимых слов

        public int getWordsSpoken(){return wordsSpoken;}
        public void setWordsSpoken(int wordsSpoken){this.wordsSpoken = wordsSpoken;}

        public void speak () {
            System.out.println("Говорить");
        }

        public void info(String getNickname, int getWordsSpoken){
            System.out.println("Попугай " + getNickname + "произносит " + getWordsSpoken + " слов.");
        }
        @Override
        public void battle(){
            System.out.println("Зачем мне драться, если хозяин кормит?");
        }
    }
    public class MammaliaBlueWhale extends HomeWorkAnimals.AnimalsMammalia {
        private int mostache;//количество усов

        public int getMostache() {return mostache;}
        public void setMostache(int mostache) {this.mostache = mostache;}

        public void fountain(){
            System.out.println("Выпустить фонтан из спины");
        }
        public void collectPlancton(){
            System.out.println("Собирать планктон");
        }
        public void info(String getNickname, int getMostache){
            System.out.println("У кита " + getNickname + " " + getMostache + " усов.");
        }
    }
    public class MammaliaElephants extends HomeWorkAnimals.AnimalsMammalia {
        private int proboscisLength;//длина хобота
        private int tuskLength;//длина бивней

        public int getProboscisLength(){ return proboscisLength;}
        public int getTuskLength() {return tuskLength;}

        public void setProboscisLength(int proboscisLength){this.proboscisLength = proboscisLength;}
        public void setTuskLength(int tuskLength){this.tuskLength = tuskLength;}

        public void useProboscis(){
            System.out.println("Использовать хобот");
        }
        public void info(String getNickname, int proboscisLength, int tuskLength){
            System.out.println("У слона " + getNickname + " длина хобота равна...");
        }
    }
    public class MammaliaHumans extends HomeWorkAnimals.AnimalsMammalia {
        private String name;
        private String sername;
        private int readSpeed;//скорость чтения (количество слов в минуту)
        private int money;//количество денег

        public int getReadSpeed(){return readSpeed;}
        public int getMoney(){return money;}
        public String getName(){return name;}
        public String getSername(){return sername;}

        public void setReadSpeed(int readSpeed){this.readSpeed = readSpeed;}
        public void setMoney(int money) { this.money = money;}
        public void setName(String name) {this.name = name;}
        public void setSername(String sername) {this.sername = sername;}


        public void writingProgram(){
            System.out.println("Написание программы");
        }
        public void carDriving(){
            System.out.println("Вождение автомобиля");
        }

        public void info(String getName, String getSername, int getAge, int getMoney, int getReadSpeed){
            System.out.println("Имя: " + getName + ". Фамилия: " + getSername + ". К " + getAge +
                    " годам у неё (него) скорость чтения равна " + readSpeed + " слов в минуту. На её (его) счету "
                    + getMoney + " евро.");
        }

        @Override
        public void quiletLife(){
            System.out.println("Какая тут спокойная жизнь, если пора на завод?");
        }
    }
    public class PiscesAnglerfish extends HomeWorkAnimals.AnimalsPisces {

        public void shineTourch(String getNickname){
            System.out.println("Светить фонарём для привлечения рыб");
        }

        @Override
        public void becomeACatch(){
            System.out.println("Я сама кого хочешь поймаю");
        }
    }
    public class PiscesPufferFish extends HomeWorkAnimals.AnimalsPisces {

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
    public class PiscesSalpa extends HomeWorkAnimals.AnimalsPisces {
        private String colorOfScales;

        public String getColorOfScales(String getNickname) {return colorOfScales;}
        public void setColorOfScales(String colorOfScales){this.colorOfScales = colorOfScales;}

        public void changeColor(String getNickname, String getColorOfScales){
            System.out.println("Цвет у " + getNickname + " в данный момент - " + getColorOfScales );
        }
        @Override
        public void becomeACatch(){
            System.out.println("Стану невидимой и не поймают");
        }
    }
}