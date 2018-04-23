package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.info;

import start.Main;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Rzecz;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd.Pojazd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PomieszczenieZawartoscPanel extends JPanel {

    private Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;
    private ArrayList<Przedmiot> listaPrzedmiotow = Main.listaPrzedmiotow;

    private JLabel lbPrzedmiot,lbBrak;
    private JPanel jpPomocnicze;

    public PomieszczenieZawartoscPanel(){
        setBackground(Color.WHITE);

        GridLayout layout = new GridLayout(0,1);

        jpPomocnicze = new JPanel();
        jpPomocnicze.setBackground(Color.WHITE);
        jpPomocnicze.setLayout(layout);

        if (listaPrzedmiotow.size()==0){
            lbBrak = new JLabel("Brak przedmitów");
            jpPomocnicze.add(lbBrak);
        }

        for(Przedmiot przedmiot : listaPrzedmiotow){
                if (przedmiot.getIdPom() == obecnePom.getIdPom()) {
                    lbPrzedmiot = new JLabel(przedmiot.getNazwa());
                    jpPomocnicze.add(lbPrzedmiot);
                }
        }
        add(jpPomocnicze);
    }
}
