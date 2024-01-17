
package netflix;


public class Netflix {

    public static void main(String[] args) {
         Obsah obsah = new Obsah();

        Cas délka1 = new Cas(1, 30);
        Cas délka2 = new Cas(2, 15);

        VideoPolozka film1 = new VideoPolozka("Forrest Gump", "USA", Druh.FILM, "drama", délka1);
        VideoPolozka film2 = new VideoPolozka("The Shawshank Redemption", "USA", Druh.FILM, "drama", délka2);
        VideoPolozka seriál1 = new VideoPolozka("Stranger Things", "USA", Druh.SERIÁL, "sci-fi", délka1);

        obsah.přidejPoložku(film1);
        obsah.přidejPoložku(film2);
        obsah.přidejPoložku(seriál1);

        System.out.println("Všechny položky:");
        obsah.vypišPoložky();

        System.out.println("\nFilmy:");
        obsah.vypišPoložkyPodleDruhu(Druh.FILM);

        System.out.println("\nDrama filmy:");
        obsah.vypišPoložkyPodleDruhuPlusŽánru(Druh.FILM, "drama");

        System.out.println("\nNejpodobnější položka k " + film1.getNázev() + ":");
        obsah.najdiNejpodobnějšíPoložku(film1);

        System.out.println("\nPrůměrná délka filmů:");
        obsah.spočítejPrůměrnouDélku(Druh.FILM);

        // Uložení do souboru
        obsah.uložDoSouboru("video_položky.txt");
    }
    }
    

