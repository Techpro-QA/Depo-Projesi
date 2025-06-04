package Depo;

public class Urun {

    private static int counter = 1000; // bunu static yaptim yoksa heryeni urunden sonra counter hep 1000den baslardi. boylece her yeni urun icin id surekli artacak
    private int id;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;

    public Urun(String urunIsmi, String uretici, int miktar, String birim, String raf) {
        this.id = counter++;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = 0;
        this.birim = birim;
        this.raf = raf;
    }


    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
}
