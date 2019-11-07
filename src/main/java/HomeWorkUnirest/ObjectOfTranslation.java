package HomeWorkUnirest;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ObjectOfTranslation implements Serializable {
    private String languageIn;
    private String languageOut;
    private String textIn;
    private String textOut;
}
