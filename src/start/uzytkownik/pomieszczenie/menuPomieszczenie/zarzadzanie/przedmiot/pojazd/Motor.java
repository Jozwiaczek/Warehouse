package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd;

public class Motor extends Pojazd {

    private String rodzaj;
    private String czyHomologacja;
    private int rozmiar, dlugosc, szerokosc, wysokosc;

    public Motor(int idPom, String nazwa, String rodzaj, String czyHomologacja, int rozmiar){
        super(idPom,nazwa,rozmiar);
        this.rodzaj=rodzaj;
        this.czyHomologacja=czyHomologacja;
    }

    public Motor(int idPom, String nazwa, String rodzaj, String czyHomologacja, int dlugosc, int szerokosc, int wysokosc){
        super(idPom,nazwa,dlugosc,szerokosc,wysokosc);
        this.rodzaj=rodzaj;
        this.czyHomologacja=czyHomologacja;
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

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getCzyHomologacja() {
        return czyHomologacja;
    }

    public void setCzyHomologacja(String czyHomologacja) {
        this.czyHomologacja = czyHomologacja;
    }

    @Override
    public String info() {
        return getNazwa();
    }
}
