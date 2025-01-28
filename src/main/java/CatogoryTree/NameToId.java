package CatogoryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

public class NameToId {

    private static final String API_URL = "https://api.trendyol.com/sapigw/product-categories";

    /**
     * Verilen kategori adının ID'sini Trendyol API'sinden çeker.
     *
     * @param categoryName Kategori adı
     * @return Kategoriye ait ID (bulunamazsa null)
     */
    public Integer getCategoryIdByName(String categoryName) {
        try {
            // Kategori verilerini çek
            JSONArray categories = fetchCategories();
            if (categories == null) {
                System.out.println("Kategoriler alınamadı!");
                return null;
            }

            // Verilen kategori ismini ara
            for (int i = 0; i < categories.length(); i++) {
                JSONObject category = categories.getJSONObject(i);

                // İsim eşleşiyorsa ID'yi döndür
                if (category.getString("name").equalsIgnoreCase(categoryName)) {
                    return category.getInt("id");
                }
            }

            System.out.println("Kategori bulunamadı: " + categoryName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Hata durumunda veya bulunamayan kategori için null döner
    }

    /**
     * Trendyol API'sinden tüm kategori verilerini çeker.
     *
     * @return Kategori verileri (JSONArray), hata durumunda null
     */
    private static JSONArray fetchCategories() {
        try {
            // URL oluştur
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            // Yanıt kodunu kontrol et
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Yanıtı oku
                JSONObject jsonResponse = getJsonObject(connection);
                if (jsonResponse.has("categories")) {
                    return jsonResponse.getJSONArray("categories");
                } else {
                    System.out.println("'categories' anahtarı JSON yanıtında bulunamadı.");
                }
            } else {
                System.out.println("API isteği başarısız oldu. HTTP Yanıt Kodu: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // Hata durumunda null döner
    }

    private static JSONObject getJsonObject(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // JSON formatını kontrol et ve 'categories' dizisini döndür
        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse;
    }
}
