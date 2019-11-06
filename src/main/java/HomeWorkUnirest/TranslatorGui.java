package HomeWorkUnirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;


import java.util.Scanner;

public class TranslatorGui  {
    private final static String apiKey = "trnsl.1.1.20191105T200007Z.10a1d177e08b34b3"
            + ".015cecad7762c7db8b3a4d406d5573442cc67c6b";
    private final static String url = "https://translate.yandex.net/api/v1.5/tr.json/translate";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(text);
        final HttpResponse<JsonNode> response = Unirest.get(url).queryString("text", text)
                .queryString("key", apiKey).queryString("lang", "ru-en")
                .asJson();

        System.out.println(response.getBody().getObject().getJSONArray("text").get(0));
    }
}
