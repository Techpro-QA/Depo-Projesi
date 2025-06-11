package DepoProject;

import java.util.*;

public class DepoSistem {

    public static Map<Integer, Urun> urunMap = new HashMap<>();
    public static Scanner scan = new Scanner(System.in);
    static int RAF_KAPASITE = 100 ;
    private static int miktar;
    private static Map<String, Integer> rafDoluluk = new HashMap<>();


    public static void urunTanimlama() {
        System.out.print("Ürün İsmi: ");
        String isim = scan.nextLine();
        System.out.print("Üretici: ");
        String uretici = scan.nextLine();

        // Birim seçeneklerini sunuyoruz
        System.out.println("Birim seçiniz:");
        System.out.println("1 - Çuval-20kg");
        System.out.println("2 - Adet-3kg");

        String birim = "";
        boolean gecerliSecim = false;

        while (!gecerliSecim) {
            System.out.print("Seçiminiz (1-2): ");
            String secim = scan.nextLine();

            switch (secim) {
                case "1":
                    birim = "çuval-20kg";
                    gecerliSecim = true;
                    break;
                case "2":
                    birim = "adet";
                    gecerliSecim = true;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 1 veya 2 giriniz.");
            }
        }

        Urun urun = new Urun(isim, uretici,birim);
        urunMap.put(urun.getId(), urun);
        System.out.println("Ürün tanımlandı. ID: " + urun.getId());

        urunListele();

    }


    public static void urunGirisi() {

        urunListele();

        System.out.print("Ürün ID: ");
        int id = scan.nextInt();
        scan.nextLine();

        try {
            id = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz giriş! Lütfen sayısal bir ID giriniz.");
            return;
        }


        if (!urunMap.containsKey(id)) {
            System.out.println("Bu ID'ye ait ürün bulunamadı.");
            return;
        }
        System.out.print("Giriş miktarı: ");
        int miktar = scan.nextInt();
        scan.nextLine();

        if (miktar <= 0) {
            System.out.println("Sifir(0)' dan büyük bir miktar girisi yapiniz");
            return;
        }
        Urun urun = urunMap.get(id);
        urun.setMiktar(urun.getMiktar());
        System.out.println("Ürün girisi yapildi");

        String raf = urun.getRaf();
        if (!raf.equals("-")) {
            int mevcutDoluluk = rafDoluluk.getOrDefault(raf, 0);
            rafDoluluk.put(raf, mevcutDoluluk + miktar);
        }
        urun.setMiktar(urun.getMiktar() + miktar);

    }


    public static void urunCikisi() {

        urunListele();

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


        String raf = urun.getRaf();
        if (!raf.equals("-")) {
            int mevcutDoluluk = rafDoluluk.getOrDefault(raf, 0);
            rafDoluluk.put(raf, Math.max(0, mevcutDoluluk - miktar));
        }
        urun.setMiktar(urun.getMiktar() - miktar);


    }


    public static void urunuRafaKoy() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== URUN RAFA YERLESTIRME ISLEMI =====");

        try {
            // 1. Kullanıcıdan ürün ID'si alınır

            urunListele();

            System.out.print("Rafa koymak istediginiz urunun ID'sini girin: ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            // 2. ID kontrolü yapılır
            if (!urunMap.containsKey(id)) {
                System.out.println("HATA: Bu ID'ye ait herhangi bir urun bulunamadi.");
                return;
            }

            Urun urun = urunMap.get(id);
            String eskiRaf = urun.getRaf();

            // 3. Ürün bilgisi gösterilir
            System.out.println("Secilen Urun -> " + urun.getUrunIsmi() +
                    " | Mevcut Raf: " + (eskiRaf.equals("-") ? "Henüz yerleştirilmemiş" : eskiRaf));

            String raf = "";
            boolean gecerliSecim = false;

            System.out.println("Ürünü koymak istediğiniz rafı seçiniz:");
            System.out.println("1 - raf1");
            System.out.println("2 - raf2");
            System.out.println("3 - raf3");
            System.out.println("4 - raf4");
            System.out.println("5 - raf5");
            System.out.println("6 - raf6");

            while (!gecerliSecim) {
                System.out.print("Seçiminiz (1-6): ");
                String secim = scanner.nextLine().trim();

                switch (secim) {
                    case "1":
                        raf = "raf1";
                        gecerliSecim = true;
                        break;
                    case "2":
                        raf = "raf2";
                        gecerliSecim = true;
                        break;
                    case "3":
                        raf = "raf3";
                        gecerliSecim = true;
                        break;
                    case "4":
                        raf = "raf4";
                        gecerliSecim = true;
                        break;
                    case "5":
                        raf = "raf5";
                        gecerliSecim = true;
                        break;
                    case "6":
                        raf = "raf6";
                        gecerliSecim = true;
                        break;
                    default:
                        System.out.println("Geçersiz seçim. Lütfen 1 ile 6 arasında bir değer girin.");
                }
            }

            int mevcutDoluluk = rafDoluluk.getOrDefault(raf, 0);
            int urunMiktari = urun.getMiktar();

            System.out.println("Raf: " + raf);
            System.out.println("Mevcut doluluk: " + mevcutDoluluk);
            System.out.println("Ürün miktarı: " + urunMiktari);
            System.out.println("Toplam: " + (mevcutDoluluk + urunMiktari));
            System.out.println("Kapasite: " + RAF_KAPASITE);

            if (urunMiktari > RAF_KAPASITE) {
                System.out.println("HATA: Ürün miktarı (" + urunMiktari + ") raf kapasitesini (" + RAF_KAPASITE + ") aşıyor!");
                return;
            }
            if (mevcutDoluluk + urunMiktari > RAF_KAPASITE) {
                System.out.println("HATA: " + raf + " rafinda yeterli alan yok!");
                System.out.println("Mevcut doluluk: " + mevcutDoluluk + " birim");
                System.out.println("Eklenmek istenen: " + urunMiktari + " birim");
                System.out.println("Raf kapasitesi: " + RAF_KAPASITE + " birim");
                System.out.println("Kalan kapasite: " + (RAF_KAPASITE - mevcutDoluluk) + " birim");
                return;
            }

            if (!eskiRaf.equals("-")) {
                int eskiDoluluk = rafDoluluk.getOrDefault(eskiRaf, 0);
                rafDoluluk.put(eskiRaf, Math.max(0, eskiDoluluk - urunMiktari));
            }

            rafDoluluk.put(raf, mevcutDoluluk + urunMiktari);
            urun.setRaf(raf);
            System.out.println("raf doluluk en son " + rafDoluluk.get(raf));

            System.out.println("ISLEM BASARILI: " + urun.getUrunIsmi().toUpperCase() +
                    " isimli urun " + raf.toUpperCase() + " rafina yerlestirildi.");

        } catch (NumberFormatException e) {
            System.out.println("HATA: Lutfen sadece sayisal bir ID giriniz.");
        } catch (Exception e) {
            System.out.println("Beklenmeyen bir hata olustu: " + e.getMessage());
        }
    }



    public static void urunListele() {

        //urun listesi bos kontrol
        if (urunMap.isEmpty()) {
            System.out.println("Listelenecek ürün yok.");
            return;
        }

        //hizalama ve okunabilirlik (genislik kismi duzenlenebilir ??renklendirme ve dikey cizgiler eklenebilir??)
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-8s %-12s %-15s %-10s %-10s %-10s %-8s\n",
                "ID", "Isim", "Uretici", "Miktar", "Birim", "Raf", "Uyarı");
        System.out.println("-----------------------------------------------------------------------------");

        for (Urun urun : urunMap.values()) {

            System.out.println(urun);

        }

    }

    public static void stokSeviyesiAyarla() {

        urunListele();

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