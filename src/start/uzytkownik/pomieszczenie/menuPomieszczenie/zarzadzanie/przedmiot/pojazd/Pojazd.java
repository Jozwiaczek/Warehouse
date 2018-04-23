package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd;

import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;

public abstract class Pojazd  extends Przedmiot {


    public Pojazd(int idPom, String nazwa, int rozmiar){
        super(idPom, nazwa, rozmiar);
    }

    public Pojazd(int idPom, String nazwa, int dlugosc, int szerokosc, int wysokosc){
        super(idPom,nazwa,dlugosc,szerokosc,wysokosc);
    }



    public abstract String info();
}
