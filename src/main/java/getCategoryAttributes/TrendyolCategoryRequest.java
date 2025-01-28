package getCategoryAttributes;

import Data.Data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class TrendyolCategoryRequest {
    Data data = new Data();

    private final String API_USERNAME = data.getAPI_USERNAME(); // Trendyol API kullanıcı adınız
    private final String API_PASSWORD = data.getAPI_PASSWORD(); // Trendyol API şifreniz
    private final String ENDPOINT_TEMPLATE = "https://api.trendyol.com/sapigw/product-categories/%s/attributes";

    public void method(String CATEGORY_ID) {
        try {
            // URL oluştur
            String endpoint = String.format(ENDPOINT_TEMPLATE, CATEGORY_ID);
            URL url = new URL(endpoint);

            // Bağlantı aç
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Gerekli başlıklar (headers)
            String auth = API_USERNAME + ":" + API_PASSWORD;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            con.setRequestProperty("Authorization", "Basic " + encodedAuth);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Yanıt kodunu kontrol et
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Yanıtı oku
            BufferedReader in;
            if (responseCode >= 200 && responseCode < 300) { // Başarılı yanıt
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else { // Hata durumu
                in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Yanıtı ekrana yazdır
            System.out.println("Response:");
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}