package start;

import myException.TooManyThingsException;
import start.uzytkownik.osoba.Osoba;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.wkladanie.PomieszczenieWkladaniePanel;

import java.awt.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Main {

    public static ArrayList<Pomieszczenie> listaPom = new ArrayList<>();
    public static ArrayList<Osoba> listaOsob = new ArrayList<>();
    public static ArrayList<Przedmiot> listaPrzedmiotow= new ArrayList<>();

    public static void main(String[] args) {

        Pomieszczenie pom1 = new Pomieszczenie(true,110);
        Pomieszczenie pom2 = new Pomieszczenie(true,220);
        Pomieszczenie pom3 = new Pomieszczenie(true,8,6,2);
        Pomieszczenie pom4 = new Pomieszczenie(true,10,10,2);
        Pomieszczenie pom5 = new Pomieszczenie(true,5,15,2);
        Pomieszczenie pom6 = new Pomieszczenie(false,400);
        Pomieszczenie pom7 = new Pomieszczenie(true,150);
        Pomieszczenie pom8 = new Pomieszczenie(true,300);
        Pomieszczenie pom9 = new Pomieszczenie(true,50);
        Pomieszczenie pom10 = new Pomieszczenie(true,80);


        listaPom.add(pom1);
        listaPom.add(pom2);
        listaPom.add(pom3);
        listaPom.add(pom4);
        listaPom.add(pom5);
        listaPom.add(pom6);
        listaPom.add(pom7);
        listaPom.add(pom8);
        listaPom.add(pom9);
        listaPom.add(pom10);

        Collections.sort(listaPom);

        Osoba osoba1 = new Osoba("Jakub","Jóźwiak","Warszawa","98042112179","21.04.1998");
        Osoba osoba2 = new Osoba("Kasia","Kowalska","Poznań","95102314069","23.10.1995");
        Osoba osoba3 = new Osoba("Karol","Świder","Piaseczno","96061414069","14.06.1996");
        Osoba osoba4 = new Osoba("Ola","Kwiszcz","Magdalenka","97010614069","06.01.1997");
        Osoba osoba5 = new Osoba("Marek","Dadar","Pruszków","92122814069","28.12.1992");

        listaOsob.add(osoba1);
        listaOsob.add(osoba2);
        listaOsob.add(osoba3);
        listaOsob.add(osoba4);
        listaOsob.add(osoba5);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartPanel();
            }
        });
    }

    public static void proceduraDatyZakonczenieNajmu(){
        Date dataDzisiejsza = new Date();
        ArrayList<Przedmiot> przedmiotyWPom;

        for(Pomieszczenie pom : listaPom)  //foreach po wszystkich pomieszczeniach
            if(pom.getDataZakonczeniaNajmu()!=null) //Sprawdzenie czy jest data zakończenia najmu
                if (dataDzisiejsza.after(getDataZakonczeniaNajmu(pom))) { //Wyłapanie pomieszczenia które ma przedawnioną datę
                    przedmiotyWPom = getListaPrzedmiotowWPom(pom);  //przypisanie listy
                    for (Pomieszczenie wolnePom : getListaAktywnychPom(pom)) //foreach po aktywnych pomieszczeniach osoby
                        for (Przedmiot przedmiot : przedmiotyWPom) { //foreach po przedmiotach w tym pomieszczeniu
                            try {
                                wolnePom.setMiejsceZajete(przedmiot.getRozmiar()); //dodanie rozmiaru przedmiotu do nowego pom
                                przedmiot.setIdPom(wolnePom.getIdPom()); //Przeniesienie przedmiotu do wolnego pomieszczenia
                            } catch (TooManyThingsException e){
                                System.err.println("Procedura zakończenia najmu | Przedmiot nie zmieścił się w innych pomieszczeniach");
                            }
                        }

                    for (Przedmiot p: przedmiotyWPom)
                        if(p.getIdPom() == pom.getIdPom())
                            listaPrzedmiotow.remove(p); //usunięcie z listy przedmiotów w starym pom

                    pom.setIdPrzypisanaOsoba(0); //Zwolnienie pomieszczenie do ponownego wynajęcia
                }
    }

    public static Date getDataZakonczeniaNajmu(Pomieszczenie pom){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date blad = new Date();
        try {
            Date dataZakonczeniaNajmu = dateFormat.parse(pom.getDataZakonczeniaNajmu());
            return dataZakonczeniaNajmu;
        } catch (ParseException e) {
            System.err.println("ProceduraDatyZakonczeniaNajmu | Błąd odczytywania daty zakończenia najmu");
        }
        return blad;
    }

    public static ArrayList<Przedmiot> getListaPrzedmiotowWPom (Pomieszczenie pom){
        ArrayList<Przedmiot> listaRzeczyWPom = new ArrayList<>();
        for(Przedmiot przedmiot: listaPrzedmiotow)
            if (pom.getIdPom()==przedmiot.getIdPom())
                listaRzeczyWPom.add(przedmiot);

        Collections.sort(listaRzeczyWPom);

        return listaRzeczyWPom;
    }

    public static ArrayList<Pomieszczenie> getListaAktywnychPom (Pomieszczenie pom){
        ArrayList<Pomieszczenie> listaPomAktywnychOsoby = new ArrayList<>();
        Date dataDzisiejsza = new Date();
            for(Pomieszczenie i : listaPom) {
                if(pom.getIdPrzypisanaOsoba() == i.getIdPrzypisanaOsoba()) {
                    if ((dataDzisiejsza.getTime() <= getDataZakonczeniaNajmu(i).getTime())) {

                        listaPomAktywnychOsoby.add(i); //Dodanie pomieszczenia do listy aktywnych pomieszceń

                    }
                }
            }
        for (Pomieszczenie p:
             listaPomAktywnychOsoby) {
            System.out.println("lista id pom: "+p.getIdPom());
        }
        System.out.println("Wielkość listy"+listaPomAktywnychOsoby.size());
        return listaPomAktywnychOsoby;
    }
}