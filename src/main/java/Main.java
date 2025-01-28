import Cargo.getProviders;
import CatogoryTree.NameToId;
import CatogoryTree.TrendyolCategoryFetcher;
import getCategoryAttributes.TrendyolCategoryRequest;
import getSuppliersAddresses.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            //KOD https://developers.trendyol.com/docs/marketplace/nasil-entegrasyon-yaparim DİAGRAMA ORANTILI YAPILMAKTADIR

        /*

        Adres search ederken bu methodu kullanırız
        Örnek servis cevabı için https://developers.trendyol.com/docs/marketplace/urun-entegrasyonu/iade-ve-sevkiyat-adres-bilgileri
        trendyol api deki konumu : https://developers.trendyol.com/docs/marketplace/urun-entegrasyonu/iade-ve-sevkiyat-adres-bilgileri
        Ancak shiping adresi ile return adresi karışacağı için böyle yapmayız

        ENTEGRASYONDA AŞAĞIDAKİ İKİ BİLGİ ÖNEMLİ shipmentAddressId returningAddressId
         */
        method method = new method();
        System.out.println(method.QueryAdres());
        /*
         Ancak aşağıdaki method sayesinde daha sağlıklı görünmesini sağlarız
        */

        TrendyolParser TrendyolParser = new TrendyolParser();

        // 1) Gönderim (Shipment) Adreslerini çeker
        List<Address> shipmentAddresses = TrendyolParser.parseShipmentAddresses();
        System.out.println("=== Gönderim (Shipment) Adresleri ===");
        for (Address addr : shipmentAddresses) {
            System.out.println(addr);
        }

        // 2) İade (Returning) Adreslerini çeker
        List<Address> returningAddresses = TrendyolParser.parseReturningAddresses();
        System.out.println("\n=== İade (Returning) Adresleri ===");
        for (Address addr : returningAddresses) {
            System.out.println(addr);
    }

        /*

        Kargo için geçerli bir api olmadığı için aşağıdaki kodla isimlerini çekebilirsiniz
        Bu kod kargo şirketlerinin ismini çeker
         */
        getProviders getProviders = new getProviders();
        ArrayList<String> NamesCargo = getProviders.getNames();
        System.out.println("=== KARGO ŞİRKETLERİ İSMİ==");
        for(int i = 0 ; i<NamesCargo.size();i++){
            System.out.println(NamesCargo.get(i));
        }
        /*
        Aşağıdaki kod ile isme göre id yi çekmeye yarar
        ENTEGRASYONDA ÖNEMLİ cargoCompanyId"
         */


/*
Bu kod Parent id si olmayanları döndürür
 */

        TrendyolCategoryFetcher TrendyolCategoryFetcher = new TrendyolCategoryFetcher();
        JSONArray categories = TrendyolCategoryFetcher.fetchAllCategories();

        if (categories != null) {
            System.out.println("Tüm Kategoriler:");
            for (int i = 0; i < categories.length(); i++) {
                JSONObject category = categories.getJSONObject(i);
                System.out.println("ID: " + category.getInt("id") +
                        ", Name: " + category.getString("name") +
                        ", Parent ID: " + (category.isNull("parentId") ? "None" : category.getInt("parentId")));
            }
        } else {
            System.out.println("Kategoriler alınamadı.");


            
}
/*
Bu method sayesinde
 */
        NameToId NameToId = new NameToId();
        System.out.println(NameToId.getCategoryIdByName("Otomobil & Motosiklet"));

    }

}