package getSuppliersAddresses;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TrendyolParser {
    method IsletmeSorgu = new method();
    /**
     * Sadece Gönderim (Shipment) adreslerini döndürür.
     * (isShipmentAddress == true)
     */
    public List<Address> parseShipmentAddresses() {
        String jsonString = IsletmeSorgu.QueryAdres().toString();
        List<Address> shipmentList = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonString);
            if (root.has("supplierAddresses")) {
                JSONArray arr = root.getJSONArray("supplierAddresses");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Address address = parseSingleAddress(obj);

                    // Gönderim (Shipment) olanları ekle
                    if (address.isShipmentAddress()) {
                        shipmentList.add(address);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shipmentList;
    }

    /**
     * Sadece İade (Returning) adreslerini döndürür.
     * (isReturningAddress == true)
     */
    public List<Address> parseReturningAddresses() {
        method IsletmeSorgu = new method();
        String jsonString = IsletmeSorgu.QueryAdres().toString();
        List<Address> returningList = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonString);
            if (root.has("supplierAddresses")) {
                JSONArray arr = root.getJSONArray("supplierAddresses");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Address address = parseSingleAddress(obj);

                    // İade (Returning) olanları ekle
                    if (address.isReturningAddress()) {
                        returningList.add(address);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returningList;
    }

    /**
     * Tek bir adres objesini (JSON) Address POJO'suna dönüştürür.
     */
    private static Address parseSingleAddress(JSONObject obj) {
        Address a = new Address();
        a.setId(obj.optInt("id", 0));
        a.setAddressType(obj.optString("addressType", ""));
        a.setCountry(obj.optString("country", ""));
        a.setCity(obj.optString("city", ""));
        a.setCityCode(obj.optInt("cityCode", 0));
        a.setDistrict(obj.optString("district", ""));
        a.setDistrictId(obj.optInt("districtId", 0));
        a.setPostCode(obj.optString("postCode", ""));
        a.setAddress(obj.optString("address", ""));
        a.setReturningAddress(obj.optBoolean("isReturningAddress", false));
        a.setFullAddress(obj.optString("fullAddress", ""));
        a.setShipmentAddress(obj.optBoolean("isShipmentAddress", false));
        a.setInvoiceAddress(obj.optBoolean("isInvoiceAddress", false));
        a.setDefault(obj.optBoolean("isDefault", false));
        return a;
    }
}
