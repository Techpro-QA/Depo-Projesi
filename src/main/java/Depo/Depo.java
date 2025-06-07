package Depo;

import java.util.HashMap;
import java.util.Map;

public class Depo {

    private static Map<Integer,Urun> urunler = new HashMap<>();// integer id olacak , urun de urunumuz yani nesne

    public static void menu(){

        //çiğdem , lütfiye
    }
    public static void urunTanimlama(String urunIsmi, String uretici,int miktar,String birim,String raf){
        //bos veri kontrolu
        if (urunIsmi==null || uretici==null || birim==null || raf == null){
            System.out.println("Hata! Urun bilgileri bos olamaz");
            return;
        }
        // negatif miktar kontrolu
        if (miktar<0){
            System.out.println("Hata urun miktari negatif olamaz");
        }

        //yeni urunu olusturuyoruz
        Urun yeniUrun = new Urun(urunIsmi,uretici,miktar,birim,raf);
        urunler.put(yeniUrun.getId(),yeniUrun);//static olan hashmap icine ekledik
        System.out.println("Urun basariyla tanimlandi " + yeniUrun);



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

    public static void urunGirisi() {

        //emre
    }

    public static void urunuRafaKoy() {

        //Nazlı şeyda mıstıq

    }


    public static void urunCikisi() {

        //Botan

    }


    public Map<Integer, Urun> getUrunler() {
        return urunler;
    }

}
