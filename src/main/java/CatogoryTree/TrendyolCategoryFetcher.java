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
     * Trendyol'dan kategori verilerini �eker ve JSONArray olarak d�ner.
     
     * return JSONArray d�nd�r�len kategori verileri
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

                // Yan?t? JSON nesnesine d�n�?t�r
                JSONObject jsonResponse = new JSONObject(response.toString());

                // T�m kategoriler "categories" anahtar?nda bulundu?u i�in bunu JSONArray olarak d�nd�r�yoruz
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

