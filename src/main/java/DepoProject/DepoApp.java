package DepoProject;

import static DepoProject.DepoSistem.*;

public class DepoApp {

    public static void main(String[] args) {
        boolean devam = true;

        while (devam) {
            System.out.println("\n***** DEPO YÖNETİM SİSTEMİ *****");
            System.out.println("1- Ürün Tanımla");
            System.out.println("2- Ürün Girişi");
            System.out.println("3- Ürün Çıkışı");
            System.out.println("4- Ürünü Rafa Koy");
            System.out.println("5- Ürünleri Listele");
            System.out.println("6- Minimum Stok Seviyesi Ayarla");
            System.out.println("0- Çıkış");
            System.out.print("Seçiminiz: ");

            int secim;
            try {
                secim = Integer.parseInt(scan.nextLine()); //int dışında deger girilirse
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş! Lütfen sayı girin.");
                continue;
            }

            switch (secim) {
                case 1 -> urunTanimla();
                case 2 -> urunGirisi();
                case 3 -> urunCikisi();
                case 4 -> urunuRafaKoy();
                case 5 -> urunListele();
                case 6 -> stokSeviyesiAyarla();
                case 0 -> {
                    System.out.println("Çıkış yapılıyor...");
                    devam = false;
                }
                default -> System.out.println("Geçersiz seçim!");
            }
        }

    }

}
