package Cargo;
import java.util.ArrayList;

public class getProviders {
    private ArrayList<Integer> ids = new ArrayList<>();
    private ArrayList<String> taxNumbers = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    public getProviders() {
        ids.add(42);
        ids.add(38);
        ids.add(30);
        ids.add(14);
        ids.add(10);
        ids.add(19);
        ids.add(9);
        ids.add(17);
        ids.add(6);
        ids.add(20);
        ids.add(4);
        ids.add(7);

        // Code Listesi
        ArrayList<String> codes = new ArrayList<>();
        codes.add("DHLMP");
        codes.add("SENDEOMP");
        codes.add("BORMP");
        codes.add("CAIMP");
        codes.add("MNGMP");
        codes.add("PTTMP");
        codes.add("SURATMP");
        codes.add("TEXMP");
        codes.add("HOROZMP");
        codes.add("CEVAMP");
        codes.add("YKMP");
        codes.add("ARASMP");

        // Name Listesi

        names.add("DHL Marketplace");
        names.add("Sendeo Marketplace");
        names.add("Borusan Lojistik Marketplace");
        names.add("Cainiao Marketplace");
        names.add("MNG Kargo Marketplace");
        names.add("PTT Kargo Marketplace");
        names.add("Sürat Kargo Marketplace");
        names.add("TrendyoL Express Marketplace");
        names.add("Horoz Kargo Marketplace");
        names.add("CEVA Marketplace");
        names.add("Yurtiçi Kargo Marketplace");
        names.add("Aras Kargo Marketplace");

        // Tax Number Listesi

        taxNumbers.add("951-241-77-13");
        taxNumbers.add("2910804196");
        taxNumbers.add("1800038254");
        taxNumbers.add("0");
        taxNumbers.add("6080712084");
        taxNumbers.add("7320068060");
        taxNumbers.add("7870233582");
        taxNumbers.add("8590921777");
        taxNumbers.add("4630097122");
        taxNumbers.add("8450298557");
        taxNumbers.add("3130557665");
        taxNumbers.add("720039666");

    }

    public ArrayList<String> getNames() {
        return names;
    }

    public String idtoname(int id) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                return names.get(i); // ID'ye karşılık gelen isim döndürülür
            }
        }


        return "err";
    }
    public int nameToId(String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                return ids.get(i); // İsme karşılık gelen ID'yi döndür
            }
        }
        return -1; // Eğer isim bulunamazsa -1 döndür
    }
    public String idToNumber(int id) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                return taxNumbers.get(i); // ID'ye karşılık gelen Tax Number'ı döndür
            }
        }
        return "ID bulunamadı"; // Eğer ID bulunamazsa mesaj döndür
    }


}
