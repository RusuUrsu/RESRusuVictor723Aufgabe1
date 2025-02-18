public class Eveniment {
    int id;
    String held;
    String antagonist;
    String konfrontationsTyp;
    String ort;
    String datum;
    double golbalerEingluss;

    public Eveniment(int id, String held, String antagonist, String konfrontationsTyp, String ort, String datum, double golbalerEingluss) {
        this.id = id;
        this.held = held;
        this.antagonist = antagonist;
        this.konfrontationsTyp = konfrontationsTyp;
        this.ort = ort;
        this.datum = datum;
        this.golbalerEingluss = golbalerEingluss;
    }

    public Eveniment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeld() {
        return held;
    }

    public void setHeld(String held) {
        this.held = held;
    }

    public String getAntagonist() {
        return antagonist;
    }

    public void setAntagonist(String antagonist) {
        this.antagonist = antagonist;
    }

    public String getKonfrontationsTyp() {
        return konfrontationsTyp;
    }

    public void setKonfrontationsTyp(String konfrontationsTyp) {
        this.konfrontationsTyp = konfrontationsTyp;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getGolbalerEingluss() {
        return golbalerEingluss;
    }

    public void setGolbalerEingluss(double golbalerEingluss) {
        this.golbalerEingluss = golbalerEingluss;
    }
}