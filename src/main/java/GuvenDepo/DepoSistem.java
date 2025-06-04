package GuvenDepo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DepoSistem {

    private Map<Integer,Urunler> ürünDeposu = new HashMap<>();
    private Scanner scanner =new Scanner(System.in);
    private int idCounter = 1001;


    public void urunTanimlama() {
        System.out.print("Ürün ismi: ");
        String isim = scanner.nextLine();

        System.out.print("Üretici: ");
        String uretici = scanner.nextLine();

        System.out.print("Birim Cinsi: ");
        String birim = scanner.nextLine();

        Urunler urunler = new Urunler(idCounter, isim, uretici, birim);
        ürünDeposu.put(idCounter, urunler);

        System.out.println("Ürün tanimlamasi yapildi. Ürün ID'si: " + idCounter);
        idCounter++;
    }

    public void tanimlanmisÜrünCikisi () {
        System.out.print("Silmek istediğiniz ürünün ID'si: ");
        int id = scanner.nextInt();

        if (!ürünDeposu.containsKey(id)) {
            System.out.println("Bu ID'ye ait ürün bulunamadı.");
            return;
        }

        ürünDeposu.remove(id);
        System.out.println("Ürün sistemden silindi.");
    }

    public void urunListele() {
        if (ürünDeposu.isEmpty()) {
            System.out.println("Henüz tanımlı ürün yok.");
            return;
        }

        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                "ID", "İsim", "Üretici", "Miktar", "Birim Cinsi", "Raf");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (Urunler yeniÜrün : ürünDeposu.values()) {
            System.out.println(yeniÜrün);
        }
    }

    public void urunGirisi() {
        System.out.print("Ürün ID: ");
        int id = scanner.nextInt();
        if (!ürünDeposu.containsKey(id)) {
            System.out.println("Bu ID'ye ait ürün bulunamadı.");
            return;
        }

        System.out.print("Giriş miktarı: ");
        int miktar = scanner.nextInt();

        //if (miktar <= 0) {
            //System.out.println("Sifir(0)' dan büyük bir miktar girisi yapiniz");
           // return;
       // }

        Urunler urunler = ürünDeposu.get(id);
        urunler.setMiktar(urunler.getMiktar() + miktar);

        System.out.println("Ürün girisi yapildi");
    }

    public void urunuRafaKoy() {
        System.out.print("Ürün ID'si: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (!ürünDeposu.containsKey(id)) {
            System.out.println("Bu ID'ye ait ürün bulunamadı.");
            return;
        }

        System.out.print("Raf adı: ");
        String raf = scanner.nextLine();

        ürünDeposu.get(id).setRaf(raf);
        System.out.println("Ürün rafa yerleştirildi.");
    }

    public void urunCikisi() {

        System.out.print("Ürün ID'si: ");
        int id = scanner.nextInt();
        if (!ürünDeposu.containsKey(id)) {
            System.out.println("Bu ID'ye ait ürün bulunamadı.");
            return;
        }

        System.out.print("Çıkış miktarı: ");
        int miktar = scanner.nextInt();
        Urunler urunler = ürünDeposu.get(id);

      //  if (miktar <= 0) {
          //  System.out.println("Sifir(0)' dan büyük bir miktar girisi yapiniz");
          //  return;
       // }

        if (urunler.getMiktar() < miktar) {
            System.out.println("Yetersiz stok! Mevcut miktar: " + urunler.getMiktar());
            return;
        }

        urunler.setMiktar(urunler.getMiktar() - miktar);
        System.out.println("Ürünün çıkışı yapıldı.");
    }






}
