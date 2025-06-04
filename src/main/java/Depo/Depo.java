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

    public static void urunListele() {

        //umut , Muhammed ,
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
