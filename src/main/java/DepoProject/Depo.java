package DepoProject;

import java.util.HashMap;
import java.util.Map;

public class Depo {

    private static Map<Integer,Urun> urunler = new HashMap<>();// integer id olacak , urun de urunumuz yani nesne

    public static void menu(){

        //çiğdem , lütfiye
    }
    public static void urunTanimlama(String urunIsmi,String uretici, String birim){
        //bos veri kontrolu
        if (urunIsmi == null || urunIsmi.trim().isEmpty() ||
                uretici == null || uretici.trim().isEmpty() ||
                birim == null || birim.trim().isEmpty()) {
            System.out.println("Hata! Urun bilgileri bos veya eksik olamaz");
            return;
        }

        // 3. Ürün oluşturuluyor
       Urun yeniUrun = new Urun(urunIsmi, uretici, birim );

        // 4. Map'e ekleniyor
        urunler.put(yeniUrun.getId(), yeniUrun);
        System.out.println("Ürün başarıyla tanımlandı: " + yeniUrun.getId());




    }

    public static void urunListele() { //umut , Muhammed ,

        //urun listesi bos kontrol
        if (urunler.isEmpty()) {
            System.out.println("Listelenecek ürün yok.");
            return;
        }

        //hizalama ve okunabilirlik (genislik kismi duzenlenebilir ??renklendirme ve dikey cizgiler eklenebilir??)
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-8s %-12s %-15s %-10s %-10s %-10s\n",
                "ID", "Isim", "Uretici", "Miktar", "Birim", "Raf");
        System.out.println("---------------------------------------------------------------");

        //urun yazdirma (rafa koyma islemi tanimlama fonksiyonunda kontrol ediliyorsa son satir duzenlenecek)
        for (Urun urun : urunler.values()) {
            System.out.printf("%-8d %-12s %-15s %-10d %-10s %-10s\n",
                    urun.getId(),
                    urun.getUrunIsmi(),
                    urun.getUretici(),
                    urun.getMiktar(),
                    urun.getBirim(),
                    (urun.getRaf() == null || urun.getRaf().isBlank() ? "-" : urun.getRaf()));
        }
    }

    public static void urunGirisi(int id, int miktar) {

        // urun id si kontrol
        if (!urunler.containsKey(id)){
            System.out.println("Hata : Bu ID ye sahip bir urun bulunamadi ");
            return;
        }
        //negatif miktar kontrolu
        if (miktar<=0){
            System.out.println("Hata ! Girilen miktar sifir veya negatif olamaz");
            return;
        }

        //urun alinir ve miktar arttirilir
        Urun urun = urunler.get(id);
        urun.setMiktar(urun.getMiktar() + miktar);

        //bilgilendirme
        System.out.println("Urun girisi yapildi : " + miktar + " " + urun.getBirim() +
                " eklendi -> Urun :  " + urun.getUrunIsmi() +
                " | Yeni miktar: " + urun.getMiktar() + " " + urun.getBirim());
    }

    public static void urunuRafaKoy() {

        //Nazlı şeyda mıstıq

    }


    public static void urunCikisi() {


   }


    public Map<Integer, Urun> getUrunler() {
        return urunler;
    }

}
