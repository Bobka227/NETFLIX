
package netflix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Obsah {
     private List<VideoPolozka> videopoložky;

    public Obsah() {
        this.videopoložky = new ArrayList<>();
    }

    public void přidejPoložku(VideoPolozka položka) {
        videopoložky.add(položka);
    }

    public void vypišPoložky() {
        for (VideoPolozka položka : videopoložky) {
            System.out.println(položka);
        }
    }

    public void vypišPoložkyPodleDruhu(Druh vybranýDruh) {
        for (VideoPolozka položka : videopoložky) {
            if (položka.getDruh() == vybranýDruh) {
                System.out.println(položka);
            }
        }
    }

    public void vypišPoložkyPodleDruhuPlusŽánru(Druh vybranýDruh, String žánr) {
        for (VideoPolozka položka : videopoložky) {
            if (položka.getDruh() == vybranýDruh && položka.getŽánr().equals(žánr)) {
                System.out.println(položka);
            }
        }
    }

    public void najdiNejpodobnějšíPoložku(VideoPolozka položka) {
        int maxSkóre = 0;
        VideoPolozka nejpodobnějšíPoložka = null;

        for (VideoPolozka dalšíPoložka : videopoložky) {
            if (!dalšíPoložka.equals(položka)) {
                int skóre = položka.podobnostS(dalšíPoložka);
                if (skóre > maxSkóre) {
                    maxSkóre = skóre;
                    nejpodobnějšíPoložka = dalšíPoložka;
                }
            }
        }

        if (nejpodobnějšíPoložka != null) {
            System.out.println("Nejpodobnější položka: " + nejpodobnějšíPoložka);
        } else {
            System.out.println("Žádná podobná položka nenalezena.");
        }
    }

    public void spočítejPrůměrnouDélku(Druh vybranýDruh) {
        int celkováDélka = 0;
        int počet = 0;

        for (VideoPolozka položka : videopoložky) {
            if (položka.getDruh() == vybranýDruh) {
                celkováDélka += položka.getDélka().převeďNaMinuty();
                počet++;
            }
        }

        if (počet > 0) {
            int průměrnáDélka = celkováDélka / počet;
            Cas průměrnýČas = new Cas(průměrnáDélka / 60, průměrnáDélka % 60);
            System.out.println("Průměrná délka " + vybranýDruh + "ů: " + průměrnýČas);
        } else {
            System.out.println("Žádné " + vybranýDruh + "y nejsou v seznamu.");
        }
    }

    public void uložDoSouboru(String soubor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(soubor))) {
            for (VideoPolozka položka : videopoložky) {
                writer.write(položka.toString());
                writer.newLine();
            }
            System.out.println("Seznam byl úspěšně uložen do souboru: " + soubor);
        } catch (IOException e) {
            System.err.println("Chyba při ukládání do souboru: " + e.getMessage());
        }
    }
}
