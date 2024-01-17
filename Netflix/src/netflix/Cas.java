
package netflix;

enum Druh {
    FILM,
    SERIÁL
}


public class Cas {
    
 private int hodiny;
    private int minuty;

    public Cas(int hodiny, int minuty) {
        this.hodiny = hodiny;
        this.minuty = minuty;
    }

    public int getHodiny() {
        return hodiny;
    }

    public int getMinuty() {
        return minuty;
    }

  public String toString() {
    return hodiny + ":" + (minuty < 10 ? "0" : "") + minuty;
}
  
  //Этот код создает строку в формате "часы:минуты", где для минут добавляется ведущий ноль в случае, если минуты меньше 10.

    public int převeďNaMinuty() {
        return hodiny * 60 + minuty;
    }
}
