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

     static class Builder implements Serializable {
        private Kittens newKittens;

        public Builder() {
            newKittens = new Kittens();
        }

        public Builder nickname(String nickname) {
            newKittens.nickname = nickname;
            return this;
        }

        public Builder age(Integer age) {
            newKittens.age = age;
            return this;
        }

        public Builder growth(Integer growth) {
            newKittens.growth = growth;
            return this;
        }

        public Builder weight(Integer weight) {
            newKittens.weight = weight;
            return this;
        }

        public Builder color(String color) {
            newKittens.color = color;
            return this;
        }

        public Builder sale(Boolean sale) {
            newKittens.sale = sale;
            return this;
        }

        public Kittens build() {
            return newKittens;
        }
    }

    String getNickname() {
        return nickname;
    }

    Integer getAge() {
        return age;
    }

    Integer getGrowth() {
        return growth;
    }

    Integer getWeight() {
        return weight;
    }

    String getColor() {
        return color;
    }

    Boolean getSale() {
        return sale;
    }

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

    public static final long serialVersionUID = 2L;

    @Override
    public String toString() {
        return ". Nickname: " + nickname + "; Age: " + age
                + "; Growth: " + growth + "; Weight: " + weight +
                "; Color: " + color + "; Sale: " + sale;
    }
}