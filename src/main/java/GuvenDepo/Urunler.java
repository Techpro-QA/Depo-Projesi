package GuvenDepo;

public class Urunler {

    private int ID;
    private String ürünIsmi;
    private String üretici;
    private int miktar;
    private String birimCinsi;
    private String raf;





    public Urunler(int ID, String ürünIsmi, String üretici, String birimCinsi) {
        this.ID = ID;
        this.ürünIsmi = ürünIsmi;
        this.üretici = üretici;
        this.birimCinsi = birimCinsi;
        this.miktar= 0;
        this.raf=null;

    }





    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public int getID() {
        return ID;
    }

    public String getÜrünIsmi() {
        return ürünIsmi;
    }

    public String getÜretici() {
        return üretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public String getBirimCinsi() {
        return birimCinsi;
    }

    public String getRaf() {
        return raf;
    }


    @Override
    public String toString() {
        return String.format("%-15d %-15s %-15s %-15d %-15s %-15s",
                ID, ürünIsmi, üretici, miktar, birimCinsi, raf);
    }

    }


