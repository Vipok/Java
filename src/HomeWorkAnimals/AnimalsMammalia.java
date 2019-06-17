package HomeWorkAnimals;

 class AnimalsMammalia extends Animals {

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
