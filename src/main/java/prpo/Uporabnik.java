package prpo;

public class Uporabnik extends Entiteta {
    private String ime;
    private String priimek;
    private String uporabnisko_ime;

    public Uporabnik(String ime, String priimek, String uporabnisko_ime) {
        this.ime = ime;
        this.priimek = priimek;
        this.uporabnisko_ime = uporabnisko_ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek) {
        this.priimek = priimek;
    }

    public String getUporabnisko_ime() {
        return uporabnisko_ime;
    }

    public void setUporabnisko_ime(String uporabnisko_ime) {
        this.uporabnisko_ime = uporabnisko_ime;
    }

    public String toString() {
        return "Uporabnik{" +
                "ime='" + ime + '\'' +
                ", uporabniskoIme='" + uporabnisko_ime + '\'' +
                ", priimek='" + priimek + '\'' +
                '}';
    }
}
