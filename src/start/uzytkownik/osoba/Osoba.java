package start.uzytkownik.osoba;

import myException.NeverRentException;

public class Osoba {

    private String imie, nazwisko, adres, pesel, dataUrodzenia,dataPierwszegoNajmu;
    private int idOsoba;
    public static int lastIdOsoba;

    public Osoba(String imie, String nazwisko, String adres, String pesel, String dataUrodzenia){
        lastIdOsoba++;
        this.idOsoba=lastIdOsoba;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.adres=adres;
        this.pesel=pesel;
        this.dataUrodzenia=dataUrodzenia;
        this.dataPierwszegoNajmu=dataPierwszegoNajmu;
    }

    public int getIdOsoba() {
        return idOsoba;
    }

    public void setIdOsoba(int idOsoba) {
        this.idOsoba = idOsoba;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getDataPierwszegoNajmu() throws NeverRentException {
        if(dataPierwszegoNajmu==null)
            throw new NeverRentException();
        return dataPierwszegoNajmu;
    }

    public void setDataPierwszegoNajmu(String dataPierwszegoNajmu) {
        this.dataPierwszegoNajmu = dataPierwszegoNajmu;
    }
}
