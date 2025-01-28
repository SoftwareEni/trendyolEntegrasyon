package CatogoryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrendyolCategoryFetcher {

    protected   String API_URL = "https://api.trendyol.com/sapigw/product-categories";

    /**
     * Trendyol'dan kategori verilerini çeker ve JSONArray olarak döner.
     
     * return JSONArray döndürülen kategori verileri
     */
    public  JSONArray fetchAllCategories() {
        try {
            // API URL'sini olu?tur
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Yan?t kodunu kontrol et
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Yan?t? oku
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Yan?t? JSON nesnesine dönü?tür
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Tüm kategoriler "categories" anahtar?nda bulundu?u için bunu JSONArray olarak döndürüyoruz
                if (jsonResponse.has("categories")) {
                    return jsonResponse.getJSONArray("categories");
                } else {
                    System.out.println("Kategori bilgisi bulunamad?.");
                    return null;
                }
            } else {
                System.out.println("API iste?i ba?ar?s?z oldu. HTTP Yan?t Kodu: " + responseCode);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }}

