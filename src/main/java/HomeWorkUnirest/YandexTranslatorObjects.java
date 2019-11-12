package HomeWorkUnirest;

import lombok.Data;

@Data
public class YandexTranslatorObjects {
    private int code;
    private String lang;
    private  String [] text;
}
