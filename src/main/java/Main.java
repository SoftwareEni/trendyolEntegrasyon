import Cargo.getProviders;
import getSuppliersAddresses.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            //KOD https://developers.trendyol.com/docs/marketplace/nasil-entegrasyon-yaparim DİAGRAMA ORANTILI YAPILMAKTADIR

        /*

        Adres search ederken bu methodu kullanırız
        Örnek servis cevabı için https://developers.trendyol.com/docs/marketplace/urun-entegrasyonu/iade-ve-sevkiyat-adres-bilgileri
        trendyol api deki konumu : https://developers.trendyol.com/docs/marketplace/urun-entegrasyonu/iade-ve-sevkiyat-adres-bilgileri
        Ancak shiping adresi ile return adresi karışacağı için böyle yapmayız
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
         */


}}