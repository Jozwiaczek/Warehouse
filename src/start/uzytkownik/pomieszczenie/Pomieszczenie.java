package start.uzytkownik.pomieszczenie;

import myException.TooManyThingsException;

public class Pomieszczenie implements Comparable<Pomieszczenie> {

    private int idPom;
    private boolean statusPomieszczenia;
    public static int lastIdPom;
    private int rozmiar, iloscDni,idPrzypisanaOsoba, miejsceZajete , miejsceWolne;
    private String dataRozpoczeciaNajmu, dataZakonczeniaNajmu;
    private int dlugosc, szerokosc, wysokosc;

    public Pomieszczenie(boolean statusPomieszczenia, int rozmiar){
        this.statusPomieszczenia=statusPomieszczenia;
        lastIdPom++;
        this.idPom=lastIdPom;
        this.idPrzypisanaOsoba=idPrzypisanaOsoba;
        this.rozmiar = rozmiar;
        this.iloscDni=iloscDni;
        this.dataRozpoczeciaNajmu=dataRozpoczeciaNajmu;
        this.dataZakonczeniaNajmu=dataZakonczeniaNajmu;
        this.miejsceZajete=miejsceZajete;
        this.miejsceWolne=rozmiar-miejsceZajete;
    }

    public Pomieszczenie(boolean statusPomieszczenia, int dlugosc, int szerokosc, int wysokosc){
        this.statusPomieszczenia=statusPomieszczenia;
        lastIdPom++;
        this.idPom=lastIdPom;
        this.idPrzypisanaOsoba=idPrzypisanaOsoba;
        this.iloscDni=iloscDni;
        this.dataRozpoczeciaNajmu=dataRozpoczeciaNajmu;
        this.dataZakonczeniaNajmu=dataZakonczeniaNajmu;
        this.miejsceZajete=miejsceZajete;
        this.dlugosc=dlugosc;
        this.szerokosc=szerokosc;
        this.wysokosc=wysokosc;
        this.rozmiar =dlugosc*szerokosc*wysokosc;
        this.miejsceWolne=rozmiar-miejsceZajete;
    }

    public boolean getStatusPomieszczenia() {
        return statusPomieszczenia;
    }

    public void setStatusPomieszczenia(boolean statusPomieszczenia) {
        this.statusPomieszczenia = statusPomieszczenia;
    }

    public int getMiejsceWolne() {
        return rozmiar-miejsceZajete;
    }

    public String getDataZakonczeniaNajmu() {
        return dataZakonczeniaNajmu;
    }

    public void setDataZakonczeniaNajmu(String dataZakonczeniaNajmu) {
        this.dataZakonczeniaNajmu = dataZakonczeniaNajmu;
    }

    public int getMiejsceZajete() {
        return miejsceZajete;
    }

    public void setMiejsceZajete(int miejsceZajete) throws TooManyThingsException {
        if(miejsceZajete>rozmiar)
            throw new TooManyThingsException();
        this.miejsceZajete = miejsceZajete;
    }

    public int getIdPom() {
        return idPom;
    }

    public int getIdPrzypisanaOsoba() {
        return idPrzypisanaOsoba;
    }

    public void setIdPrzypisanaOsoba(int idPrzypisanaOsoba) {
        this.idPrzypisanaOsoba = idPrzypisanaOsoba;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    public int getIloscDni() {
        return iloscDni;
    }

    public void setIloscDni(int iloscDni) {
        this.iloscDni = iloscDni;
    }

    public String getDataRozpoczeciaNajmu() {
        return dataRozpoczeciaNajmu;
    }

    public void setDataRozpoczeciaNajmu(String dataRozpoczeciaNajmu) {
        this.dataRozpoczeciaNajmu = dataRozpoczeciaNajmu;
    }

    @Override
    public String toString() {
        return idPom +"    |    "+rozmiar+"m3";
    }


    @Override
    public int compareTo(Pomieszczenie o) {

        Pomieszczenie porownanieRozmiaru = (Pomieszczenie)o;
        int res = this.rozmiar-porownanieRozmiaru.rozmiar;
        if( res == 0)
            return 0;
        if(this.rozmiar>porownanieRozmiaru.rozmiar)
            return 1;
        else
            return -1;
    }
}
