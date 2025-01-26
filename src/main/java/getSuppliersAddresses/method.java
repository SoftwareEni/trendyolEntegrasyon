package getSuppliersAddresses;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import Data.Data;

public class method {

    Data Data = new Data();
    private  final String API_USERNAME = Data.getAPI_USERNAME(); // API Kullanıcı Adı
    private  final String API_PASSWORD = Data.getAPI_PASSWORD(); // API Şifre
    private  final String SUPPLIER_ID = Data.getSUPPLIER_ID();               // Satıcı ID

    public Object QueryAdres() {
        try {
            // İstek URL'si
            String url = "https://api.trendyol.com/sapigw/suppliers/" + SUPPLIER_ID + "/addresses";
            System.out.println("Request URL: " + url);

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // GET isteği
            con.setRequestMethod("GET");

            // Yetkilendirme başlığı
            String auth = API_USERNAME + ":" + API_PASSWORD;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            con.setRequestProperty("Authorization", "Basic " + encodedAuth);

            // Ek header'lar
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Yanıt kodu
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Yanıtı oku
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // StringBuilder -> String
                return response;
            } else {
                // Başarısız durum kodu
                System.out.println("GET request failed. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }

        // Eğer hata veya farklı response kodu varsa boş döndürür
        return null;
    }
}
