import getSuppliersAddresses.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        /*
        Adres search ederken bu methodu kullanırız
        Örnek servis cevabı {"supplierAddresses":[{"id":7399524,"addressType":"Returning","country":"T�RK�YE","city":"Ankara","cityCode":6,"district":"�ankaya","districtId":5,"postCode":"06000","address":"Mahalle/Semt:YUKARIBAH�EL�EVLER MAH. Cadde/Sokak:KAZAK�STAN CAD 137 �� Kap� No:B ALLEBEN KURUYEM��","isDefault":true,"fullAddress":"Mahalle/Semt:YUKARIBAH�EL�EVLER MAH. Cadde/Sokak:KAZAK�STAN CAD 137 �� Kap� No:B ALLEBEN KURUYEM�� �ankaya 06000 Ankara T�RK�YE","isShipmentAddress":false,"isReturningAddress":true,"isInvoiceAddress":false},{"id":7399525,"addressType":"Shipment","country":"T�RK�YE","city":"Ankara","cityCode":6,"district":"�ankaya","districtId":5,"postCode":"06000","address":"Mahalle/Semt:YUKARIBAH�EL�EVLER MAH. Cadde/Sokak:KAZAK�STAN CAD 137 �� Kap� No:B ALLEBEN KURUYEM��","isDefault":true,"fullAddress":"Mahalle/Semt:YUKARIBAH�EL�EVLER MAH. Cadde/Sokak:KAZAK�STAN CAD 137 �� Kap� No:B ALLEBEN KURUYEM�� �ankaya 06000 Ankara T�RK�YE","isShipmentAddress":true,"isReturningAddress":false,"isInvoiceAddress":false},{"id":7399503,"addressType":"Invoice","country":"T�rkiye","city":"Ankara","cityCode":6,"district":"�ankaya","districtId":5,"postCode":"06000","address":"Mahalle/Semt:EMEK MAH. Cadde/Sokak:BOSNA HERSEK CAD. SAKARYA APT. No:4 �� Kap� No:10","isDefault":true,"fullAddress":"Mahalle/Semt:EMEK MAH. Cadde/Sokak:BOSNA HERSEK CAD. SAKARYA APT. No:4 �� Kap� No:10 �ankaya 06000 Ankara T�rkiye","isShipmentAddress":false,"isReturningAddress":false,"isInvoiceAddress":true}],"defaultShipmentAddress":{"id":7399525,"addressType":"Shipment","country":"T�RK�YE","city":"Ankara","cityCode":6,"district":"�ankaya","districtId":5,"postCode":"06000","address":"Mahalle/Semt:YUKARIBAH�EL�EVLER MAH. Cadde/Sokak:KAZAK�STAN CAD 137 �� Kap� No:B ALLEBEN KURUYEM��","isDefault":true,"fullAddress":"Mahalle/Semt:YUKARIBAH�EL�EVLER MAH. Cadde/Sokak:KAZAK�STAN CAD 137 �� Kap� No:B ALLEBEN KURUYEM�� �ankaya 06000 Ankara T�RK�YE","isShipmentAddress":true,"isReturningAddress":false,"isInvoiceAddress":false},"defaultInvoiceAddress":{"id":7399503,"addressType":"Invoice","country":"T�rkiye","city":"Ankara","cityCode":6,"district":"�ankaya","districtId":5,"postCode":"06000","address":"Mahalle/Semt:EMEK MAH. Cadde/Sokak:BOSNA HERSEK CAD. SAKARYA APT. No:4 �� Kap� No:10","isDefault":true,"fullAddress":"Mahalle/Semt:EMEK MAH. Cadde/Sokak:BOSNA HERSEK CAD. SAKARYA APT. No:4 �� Kap� No:10 �ankaya 06000 Ankara T�rkiye","isShipmentAddress":false,"isReturningAddress":false,"isInvoiceAddress":true},"defaultReturningAddress":{"present":true}}
        trendyol api deki konumu : https://developers.trendyol.com/docs/marketplace/urun-entegrasyonu/iade-ve-sevkiyat-adres-bilgileri
        Ancak shiping adresi ile return adresi karışacağı için böyle yapmayız
         */
        method method = new method();
        System.out.println(method.QueryAdres());
        /*
         Ancak aşağıdaki method sayesinde daha sağlıklı görünmesini sağlarız
        */

        TrendyolParser TrendyolParser = new TrendyolParser();

        // 1) Gönderim (Shipment) Adresleri
        List<Address> shipmentAddresses = TrendyolParser.parseShipmentAddresses();
        System.out.println("=== Gönderim (Shipment) Adresleri ===");
        for (Address addr : shipmentAddresses) {
            System.out.println(addr);
        }

        // 2) İade (Returning) Adresleri
        List<Address> returningAddresses = TrendyolParser.parseReturningAddresses();
        System.out.println("\n=== İade (Returning) Adresleri ===");
        for (Address addr : returningAddresses) {
            System.out.println(addr);
    }
}}