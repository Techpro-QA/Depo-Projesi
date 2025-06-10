package DepoProject;

public class Urun {
    private int id;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private String birim;
    private String raf;
    private int minStok;

    public Urun( String urunIsmi, String uretici,  String birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
        this.miktar = 0;  //Adet tanımlanmadıysa varsayılan: 0
        this.raf = "-";   //Raf tanımlanmadıysa varsayılan: "-"
        this.minStok = 3; // varsayılan minimum stok
    }


    public int getId() {
        return id;
    }
    public String getUrunIsmi() {
        return urunIsmi;
    }
    public String getUretici() {
        return uretici;
    }
    public int getMiktar() {
        return miktar;
    }
    public String getBirim() {
        return birim;
    }
    public String getRaf() {
        return raf;
    }
    public int getMinStok() {
        return minStok;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    public void setRaf(String raf) {
        this.raf = raf;
    }
    public void setMinStok(int minStok) {
        this.minStok = minStok;
    }

    @Override
    public String toString() {
        String uyarı = miktar < minStok ? "STOK AZ!" : "";
        return String.format("%-6d %-10s %-12s %-8d %-8s %-8s %-8s",
                id, urunIsmi, uretici, miktar, birim, raf, uyarı);
    }
}