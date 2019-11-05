package HomeWorkUnirest;

import lombok.Data;

import java.io.Serializable;

@Data
public class ObjectOfTranslation implements Serializable {
    private String languageIn;
    private String languageOut;
    private String textIn;
    private String textOut;
}
