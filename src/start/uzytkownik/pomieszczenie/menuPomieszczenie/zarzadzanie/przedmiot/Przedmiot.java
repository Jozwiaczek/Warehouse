package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot;

import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;

public abstract class Przedmiot implements Comparable<Przedmiot>{
    Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;

    private int idPom;
    private String nazwa;
    private int rozmiar;
    private int dlugosc, szerokosc, wysokosc;

    public Przedmiot(int idPom, String nazwa, int rozmiar) {
        this.idPom = idPom;
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
    }

    public Przedmiot(int idPom, String nazwa, int dlugosc, int szerokosc, int wysokosc) {
        this.idPom = idPom;
        this.nazwa = nazwa;
        this.rozmiar=dlugosc*szerokosc*wysokosc;
    }

    public int getIdPom() {
        return idPom;
    }

    public void setIdPom(int idPom) {
        this.idPom = idPom;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar){
            this.rozmiar = rozmiar;
    }

    public abstract String info();

    @Override
    public int compareTo(Przedmiot o) {
        Przedmiot porownanieRozmiaru = (Przedmiot)o;

        if(this.rozmiar == porownanieRozmiaru.rozmiar)
            return nazwa.compareTo(porownanieRozmiaru.nazwa);
        else
            if (this.rozmiar < porownanieRozmiaru.rozmiar)
                return 1;
            else
                return -1;

    }
}
