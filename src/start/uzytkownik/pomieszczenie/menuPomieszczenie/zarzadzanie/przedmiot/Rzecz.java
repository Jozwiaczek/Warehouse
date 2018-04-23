package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot;

public class Rzecz extends Przedmiot{

    public Rzecz(int idPom, String nazwa, int rozmiar) {
        super(idPom,nazwa,rozmiar);
    }

    public Rzecz(int idPom, String nazwa, int dlugosc, int szerokosc, int wysokosc) {
        super(idPom,nazwa,dlugosc,szerokosc,wysokosc);

    }

    @Override
    public String info() {
        return null;
    }
}
