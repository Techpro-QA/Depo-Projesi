package DepoProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepoSistem {

    public static Map<Integer, Urun> urunMap = new HashMap<>();
    static int idCounter = 1000;
    public static Scanner scan = new Scanner(System.in);
    private static int miktar;


    public static void urunTanimla() {
        System.out.print("Ürün İsmi: ");
        String isim = scan.nextLine();
        System.out.print("Üretici: ");
        String uretici = scan.nextLine();
        System.out.print("Birim (kg, çuval, adet...): ");
        String birim = scan.nextLine();

        int miktar = 0;//varsayilan miktar
        String raf = "-";

        Urun urun = new Urun( isim, uretici,birim);
        urunMap.put(idCounter, urun);
        System.out.println("Ürün tanımlandı. ID: " + idCounter);
        idCounter++;
    }

    public static void urunGirisi() {
        System.out.print("Ürün ID: ");
        int id = Integer.parseInt(scan.nextLine());
        Urun urun = urunMap.get(id);
        if (urun != null) {
            System.out.print("Giriş miktarı: ");
            int miktar = Integer.parseInt(scan.nextLine());
            urun.setMiktar(urun.getMiktar() + miktar);
            System.out.println("Giriş başarılı.");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }

    public static void urunCikisi() {
        System.out.print("Ürün ID: ");
        int id;

        try {
            id = Integer.parseInt(scan.nextLine()); //int dışında deger girilirse
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz ID! Lütfen sayı giriniz.");
            return;
        }

        Urun urun = urunMap.get(id);
        if (urun != null) {
            System.out.println("Seçilen Ürün: " + urun.getUrunIsmi() + " | Mevcut: " + urun.getMiktar() + " " + urun.getBirim());
            System.out.print("Çıkış miktarı: ");

            int miktar;
            try {
                miktar = Integer.parseInt(scan.nextLine()); //int dışında deger girilirse
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz miktar! Lütfen sayı giriniz.");
                return;
            }

            if (miktar <= 0) {
                System.out.println("Geçersiz miktar. Pozitif bir değer giriniz.");
                return;
            }

            if (urun.getMiktar() >= miktar) {
                urun.setMiktar(urun.getMiktar() - miktar);
                System.out.println(miktar + " birim ürün çıkışı yapıldı.");

                if (urun.getMiktar() == 0) {  //Ürün çıkışı yapıldı ama ürün silinmeyecek, uyarı verdik
                    System.out.println("Uyarı: Bu ürünün stoğu sıfırlandı.");
                }

            } else {
                System.out.println("HATA: Yeterli stok yok. Mevcut miktar: " + urun.getMiktar());
                // mevcut stoktan daha fazla miktarda çıkış yapmaya çalışılırsa
            }

            // Her durumda güncel ürün listesi gösterilsin
            urunListele();

        } else {
            System.out.println("Ürün bulunamadı. Lütfen geçerli bir ID giriniz.");
        }
    }


    public static void urunuRafaKoy() {
        System.out.print("Ürün ID: ");
        int id = Integer.parseInt(scan.nextLine());
        Urun urun = urunMap.get(id);
        if (urun != null) {
            System.out.print("Raf adı: ");
            String raf = scan.nextLine();
            urun.setRaf(raf);
            System.out.println("Rafa yerleştirildi.");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }

    public static void urunListele() {
        if (urunMap.isEmpty()) {
            System.out.println("Henüz tanımlı ürün yok.");
            return;
        }
        System.out.println("\nID     İsmi       Üretici     Miktar   Birim    Raf      Uyarı");
        System.out.println("----------------------------------------------------------------");

        for (Urun urun : urunMap.values()) { //Her Urun objesini sırayla alır.toString()le çağırdık
            System.out.println(urun);
        }
    }

    public static void stokSeviyesiAyarla() {
        System.out.print("Ürün ID: ");
        int id = Integer.parseInt(scan.nextLine());
        Urun urun = urunMap.get(id);
        if (urun != null) {
            System.out.print("Yeni minimum stok: ");
            int min = Integer.parseInt(scan.nextLine());
            urun.setMinStok(min);
            System.out.println("Minimum stok ayarlandı.");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }



}