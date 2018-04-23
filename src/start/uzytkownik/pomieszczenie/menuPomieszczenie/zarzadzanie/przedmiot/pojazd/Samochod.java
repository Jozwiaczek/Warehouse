package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd;

public class Samochod extends Pojazd {

    private double pojemnoscSilnika;
    private String rodzajNapedu;
    private int rozmiar, dlugosc, szerokosc, wysokosc;

    public Samochod(int idPom, String nazwa, double pojemnoscSilnika, String rodzajNapedu, int rozmiar) {
        super(idPom, nazwa, rozmiar);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajNapedu = rodzajNapedu;
    }

    public Samochod(int idPom, String nazwa, double pojemnoscSilnika, String rodzajNapedu, int dlugosc, int szerokosc, int wysokosc) {
        super(idPom, nazwa,dlugosc,szerokosc,wysokosc);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajNapedu = rodzajNapedu;
    }

    public double getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public void setPojemnoscSilnika(int pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String getRodzajNapedu() {
        return rodzajNapedu;
    }

    public void setRodzajNapedu(String rodzajNapedu) {
        this.rodzajNapedu = rodzajNapedu;
    }

    @Override
    public String info() {
        return getNazwa();
    }
}
