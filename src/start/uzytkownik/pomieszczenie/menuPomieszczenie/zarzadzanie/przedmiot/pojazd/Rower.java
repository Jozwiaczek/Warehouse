package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd;

public class Rower extends Pojazd {

    private int liczbaPrzerzutek, iloscAmortyzatorow;
    private String rodzajHamulcow;
    private int rozmiar, dlugosc, szerokosc, wysokosc;

    public Rower(int idPom, String nazwa, int liczbaPrzerzutek, int iloscAmortyzatorow, String rodzajHamulcow, int rozmiar) {
        super(idPom, nazwa,rozmiar);
        this.liczbaPrzerzutek = liczbaPrzerzutek;
        this.iloscAmortyzatorow = iloscAmortyzatorow;
        this.rodzajHamulcow = rodzajHamulcow;
    }

    public Rower(int idPom, String nazwa, int liczbaPrzerzutek, int iloscAmortyzatorow, String rodzajHamulcow, int dlugosc, int szerokosc, int wysokosc) {
        super(idPom, nazwa, dlugosc, szerokosc, wysokosc);
        this.liczbaPrzerzutek = liczbaPrzerzutek;
        this.iloscAmortyzatorow = iloscAmortyzatorow;
        this.rodzajHamulcow = rodzajHamulcow;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(int szerokosc) {
        this.szerokosc = szerokosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int wysokosc) {
        this.wysokosc = wysokosc;
    }

    public int getLiczbaPrzerzutek() {
        return liczbaPrzerzutek;
    }

    public void setLiczbaPrzerzutek(int liczbaPrzerzutek) {
        this.liczbaPrzerzutek = liczbaPrzerzutek;
    }

    public int getIloscAmortyzatorow() {
        return iloscAmortyzatorow;
    }

    public void setIloscAmortyzatorow(int iloscAmortyzatorow) {
        this.iloscAmortyzatorow = iloscAmortyzatorow;
    }

    public String getRodzajHamulcow() {
        return rodzajHamulcow;
    }

    public void setRodzajHamulcow(String rodzajHamulcow) {
        this.rodzajHamulcow = rodzajHamulcow;
    }


    @Override
    public String info() {
        return getNazwa();    }
}
