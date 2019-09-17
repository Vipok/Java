package HomeWorkEnum;

public enum Mounts {
    January("Январь"),
    February("Февраль"),
    March("Март"),
    April("Апрель"),
    May("Май"),
    June("Июнь"),
    Jule("Июль"),
    August("Август"),
    September("Сентябрь"),
    October("Октябрь"),
    November("Ноябрь"),
    December("Декабрь");

    private String mountsRus;
    public String getMountsRus(){return mountsRus;}

    Mounts(String getMountsRus){ this.mountsRus = getMountsRus;
    }
}
