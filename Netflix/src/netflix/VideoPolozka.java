
package netflix;

public class VideoPolozka {
 private String název;
    private String zeměPůvodu;
    private Druh druh;
    private String žánr;
    private Cas délka;

    public VideoPolozka(String název, String zeměPůvodu, Druh druh, String žánr, Cas délka) {
        this.název = název;
        this.zeměPůvodu = zeměPůvodu;
        this.druh = druh;
        this.žánr = žánr;
        this.délka = délka;
    }

    public String getNázev() {
        return název;
    }

    public String getZeměPůvodu() {
        return zeměPůvodu;
    }

    public Druh getDruh() {
        return druh;
    }

    public String getŽánr() {
        return žánr;
    }

    public Cas getDélka() {
        return délka;
    }
    
@Override
  public String toString() {
    return název + ";" + zeměPůvodu + ";" + druh + ";" + žánr + ";" + délka.toString();
}

    public int podobnostS(VideoPolozka druháPoložka) {
        int skóre = 0;

        if (druh == druháPoložka.getDruh()) {
            skóre += 100;
        }

        if (žánr.equals(druháPoložka.getŽánr())) {
            skóre += 100;
        }

        if (zeměPůvodu.equals(druháPoložka.getZeměPůvodu())) {
            skóre += 100;
        }

        if (Math.abs(délka.převeďNaMinuty() - druháPoložka.getDélka().převeďNaMinuty()) <= 20) {
            skóre += 100;
        }

        return skóre;
    }
}
   

