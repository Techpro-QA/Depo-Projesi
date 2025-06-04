package GuvenDepo;

import java.util.Scanner;

public class DepoApp {
    public static void main(String[] args) {

        DepoSistem depoSistem = new DepoSistem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("GÜVEN DEPO\nAnonim Sirketi\nSirkeci / Istanbul\nwww.guvendepo.com\nIrtibat tel: 0212 255 555 55");

        int select;

        do {

            System.out.println("*-*-*-*-* GÜVEN DEPO YÖNETİM PANElI *-*-*-*-*");
            System.out.println("1- Ürün Tanımlamasi Yap");
            System.out.println("2- Ürünleri Listele");
            System.out.println("3- Ürün Girişi");
            System.out.println("4- Ürünü Rafa Koy");
            System.out.println("5- Ürün Çıkart");
            System.out.println("6- Tanimlanmis Ürün Çıkart");
            System.out.println("0- Çıkış");
            System.out.println( "Seçiminiz: \n");
            select = scanner.nextInt();
            scanner.nextLine();

            switch (select) {
                case 1:
                    depoSistem.urunTanimlama();
                    break;
                case 2:
                    depoSistem.urunListele();
                    break;
                case 3:
                    depoSistem.urunGirisi();
                    break;
                case 4:
                    depoSistem.urunuRafaKoy();
                    break;
                case 5:
                    depoSistem.urunCikisi();
                    break;
                case 6:
                    depoSistem.tanimlanmisÜrünCikisi();
                    break;
                case 0:
                    System.out.println("Çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
                    break;
            }

        } while (select != 0);
    }




}
