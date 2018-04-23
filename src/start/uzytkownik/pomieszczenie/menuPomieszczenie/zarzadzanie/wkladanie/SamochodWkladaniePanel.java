package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.wkladanie;

import myException.TooManyThingsException;
import start.Main;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd.Pojazd;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd.Samochod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SamochodWkladaniePanel extends JPanel {

    private ArrayList<Przedmiot> listaPrzedmiotow = Main.listaPrzedmiotow;
    private Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;

    private JLabel lbNazwa, lbRozmiar, lbPojemnoscSilnika, lbRodzajNapedu, lbWymiary, lbDl, lbSz, lbWys;
    private JTextField tfNazwa, tfRozmiar, tfPojemnoscSilnika, tfDlugosc, tfSzerokosc, tfWysokosc;
    private JButton btnDodaj;
    private JComboBox<String> comboRodzajNapedu;
    private int parseRozmiar, parseDl,parseSz,parseWys;

    public SamochodWkladaniePanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        lbNazwa = new JLabel("Nazwa");
        lbNazwa.setBounds(160,0,100,30);
        lbNazwa.setFont(new Font("Lato", Font.PLAIN, 15));

        tfNazwa = new JTextField();
        tfNazwa.setBounds(230,0,150,30);
        tfNazwa.setFont(new Font("Lato", Font.PLAIN, 15));

        lbRozmiar = new JLabel("Rozmiar");
        lbRozmiar.setBounds(30,50,100,30);
        lbRozmiar.setFont(new Font("Lato", Font.PLAIN, 15));

        tfRozmiar = new JTextField();
        tfRozmiar.setBounds(100,50,50,30);
        tfRozmiar.setFont(new Font("Lato", Font.PLAIN, 15));

        lbWymiary = new JLabel("LUB     Wymiary");
        lbWymiary.setBounds(180,50,120,30);
        lbWymiary.setFont(new Font("Lato", Font.PLAIN, 15));

        lbDl = new JLabel("dl.➡");
        lbDl.setBounds(300,50,40,30);
        lbDl.setFont(new Font("Lato", Font.PLAIN, 15));

        tfDlugosc = new JTextField();
        tfDlugosc.setBounds(330,50,50,30);
        tfDlugosc.setFont(new Font("Lato", Font.PLAIN, 15));

        lbSz = new JLabel("sz.↔");
        lbSz.setBounds(390,50,40,30);
        lbSz.setFont(new Font("Lato", Font.PLAIN, 15));

        tfSzerokosc = new JTextField();
        tfSzerokosc.setBounds(430,50,50,30);
        tfSzerokosc.setFont(new Font("Lato", Font.PLAIN, 15));

        lbWys = new JLabel("wys.↕");
        lbWys.setBounds(490,50,50,30);
        lbWys.setFont(new Font("Lato", Font.PLAIN, 15));

        tfWysokosc = new JTextField();
        tfWysokosc.setBounds(530,50,50,30);
        tfWysokosc.setFont(new Font("Lato", Font.PLAIN, 15));

        lbPojemnoscSilnika = new JLabel("Pojemność silnika");
        lbPojemnoscSilnika.setBounds(160,100,150,30);
        lbPojemnoscSilnika.setFont(new Font("Lato", Font.PLAIN, 15));

        tfPojemnoscSilnika = new JTextField();
        tfPojemnoscSilnika.setBounds(290,100,90,30);
        tfPojemnoscSilnika.setFont(new Font("Lato", Font.PLAIN, 15));

        lbRodzajNapedu = new JLabel("Rodzaj Napędu");
        lbRodzajNapedu.setBounds(160,150,100,30);
        lbRodzajNapedu.setFont(new Font("Lato", Font.PLAIN, 15));

        comboRodzajNapedu = new JComboBox<>();
        comboRodzajNapedu.setBounds(270,150,115,30);
        comboRodzajNapedu.setFont(new Font("Lato", Font.PLAIN, 15));

        comboRodzajNapedu.addItem("Benzyna");
        comboRodzajNapedu.addItem("Diesel");
        comboRodzajNapedu.addItem("Gaz");
        comboRodzajNapedu.addItem("Hybryda");


        btnDodaj = new JButton("Dodaj");
        btnDodaj.setBounds(180,280,230,50);
        btnDodaj.setFont(new Font("Lato", Font.PLAIN, 18));

        btnDodaj.addActionListener(e->{
                if(!(tfNazwa.getText().isEmpty()||tfRozmiar.getText().isEmpty()||tfPojemnoscSilnika.getText().isEmpty())||
                        !(tfNazwa.getText().isEmpty() ||tfDlugosc.getText().isEmpty() ||tfSzerokosc.getText().isEmpty()||tfWysokosc.getText().isEmpty() ||tfPojemnoscSilnika.getText().isEmpty())
                ) {
                    if(tfRozmiar.getText().isEmpty()){
                        parseDl = Integer.parseInt(tfDlugosc.getText());
                        parseSz = Integer.parseInt(tfSzerokosc.getText());
                        parseWys = Integer.parseInt(tfWysokosc.getText());
                        parseRozmiar=parseDl*parseSz*parseWys;
                    }
                    else
                        parseRozmiar = Integer.parseInt(tfRozmiar.getText());

                    try {
                        double parsePojemnoscSilnika = Double.parseDouble(tfPojemnoscSilnika.getText());
                        String rodzajNapedu = comboRodzajNapedu.getSelectedItem() + "";

                        //Stworzenie i dodanie obiektu do listy
                        Samochod nowySamochod = new Samochod(obecnePom.getIdPom(), tfNazwa.getText(), parsePojemnoscSilnika, rodzajNapedu, parseRozmiar);


                        //Wyzerowanie panelu do wpisywania
                        tfNazwa.setText("");
                        tfRozmiar.setText("");
                        tfPojemnoscSilnika.setText("");
                        tfDlugosc.setText("");
                        tfSzerokosc.setText("");
                        tfWysokosc.setText("");

                        //Dodanie swojego rozmiaru do rozmiaru pomieszczenia
                        obecnePom.setMiejsceZajete(obecnePom.getMiejsceZajete() + parseRozmiar);
                        listaPrzedmiotow.add(nowySamochod);
                        JOptionPane.showMessageDialog(null, "Dodano nowy przedmiot ", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    } catch (TooManyThingsException e2) {
                        System.err.println("Wkładanie rzeczy | Brak miejsca w pomieszczeniu na wkładany przedmiot");
                        JOptionPane.showMessageDialog(null, "Brakuje miejsca w pomiszczeniu | Dostępne miejsce: " + (obecnePom.getRozmiar() - obecnePom.getMiejsceZajete()), "Brak miejsca", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null,"Uzpełnij wszystkie pola by dodać przedmiot","Błąd",JOptionPane.ERROR_MESSAGE);
        });

        add(lbNazwa);
        add(tfNazwa);
        add(lbRozmiar);
        add(tfRozmiar);
        add(lbWymiary);
        add(lbDl);
        add(tfDlugosc);
        add(lbSz);
        add(tfSzerokosc);
        add(lbWys);
        add(tfWysokosc);
        add(lbPojemnoscSilnika);
        add(tfPojemnoscSilnika);
        add(lbRodzajNapedu);
        add(comboRodzajNapedu);
        add(btnDodaj);
    }
}
