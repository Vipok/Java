package HomeWorkJavaCoreMain;

import java.io.Serializable;

public class Kittens implements Serializable {
    //класс параметров котят
    private String nickname;//кличка
    private Integer age;//возраст в днях
    private Integer growth;//рост в сантиметрах
    private Integer weight;//вес в граммах
    private String color;//цвет
    private Boolean sale;//true - на продаже, false - не на продаже

    //сеттеры
    public String getNickname() {
        return nickname;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGrowth() {
        return growth;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Boolean getSale() {
        return sale;
    }

    //геттеры
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Kittens(String nickname, Integer age, Integer growth, Integer weight, String color, Boolean sale) {
        super();
        setNickname(nickname);
        setAge(age);
        setGrowth(growth);
        setWeight(weight);
        setColor(color);
        setSale(sale);
    }


    public static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ". Nickname: " + getNickname() + "; Age: " + getAge()
                + "; Growth: " + getGrowth() + "; Weight: " + getWeight() +
                "; Color: " + getColor() + "; Sale: " + getSale();
    }
}


