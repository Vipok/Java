package HomeWorkJavaCoreV2;

import java.io.Serializable;

public class Kittens implements Serializable {
    private Long id;//id котёнка
    private String nickname;//кличка
    private Integer age;//возраст в днях
    private Integer growth;//рост в сантиметрах
    private Integer weight;//вес в граммах
    private String color;//цвет
    //сеттеры
    public Long getId(){return id;}
    public String getNickname(){return nickname;}
    public Integer getAge() {return age;}
    public Integer getGrowth(){return growth;}
    public Integer getWeight(){return weight;}
    public String getColor(){return color;}
    //геттеры
    public void setId(Long id){this.id = id;}
    public void setNickname(String nickname){this.nickname = nickname;}
    public void setAge(Integer age){this.age = age;}
    public void setGrowth(Integer growth){this.growth = growth;}
    public void setWeight(Integer weight){this.weight = weight;}
    public void setColor(String color){this.color = color;}

}
