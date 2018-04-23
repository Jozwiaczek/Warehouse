package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.wkladanie;

import myException.TooManyThingsException;
import start.Main;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.pojazd.Rower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RowerWkladaniePanel extends JPanel {

    private ArrayList<Przedmiot> listaPrzedmiotow = Main.listaPrzedmiotow;
    private Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;

    private JLabel lbNazwa, lbRozmiar, lbPrzerzutki, lbHamulce, lbCzyAmortyzowany, lbWymiary, lbDl, lbSz, lbWys,lbCzyZlozony;
    private JTextField tfNazwa, tfRozmiar, tfDlugosc, tfSzerokosc, tfWysokosc;
    private JButton btnDodaj;
    private JComboBox<String> comboHamulce, comboAmortyzatory,comboPrzerzutki, comboCzyZlozony;
    private int parseRozmiar, parseDl,parseSz,parseWys;

    public RowerWkladaniePanel(){
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

        lbCzyZlozony = new JLabel("Czy złożony?");
        lbCzyZlozony.setBounds(410,100,100,30);
        lbCzyZlozony.setFont(new Font("Lato", Font.PLAIN, 15));

        comboCzyZlozony = new JComboBox<>();
        comboCzyZlozony.setBounds(510,100,80,30);
        comboCzyZlozony.setFont(new Font("Lato", Font.PLAIN, 15));
        comboCzyZlozony.addItem("Nie");
        comboCzyZlozony.addItem("Tak");

        lbHamulce = new JLabel("Rodzaj hamulców");
        lbHamulce.setBounds(160,100,150,30);
        lbHamulce.setFont(new Font("Lato", Font.PLAIN, 15));

        comboHamulce = new JComboBox<>();
        comboHamulce.setBounds(280,100,120,30);
        comboHamulce.setFont(new Font("Lato", Font.PLAIN, 15));
        comboHamulce.addItem("Tarczowe");
        comboHamulce.addItem("Zaciskowe");

        lbPrzerzutki = new JLabel("Liczba przerzutek");
        lbPrzerzutki.setBounds(160,150,150,30);
        lbPrzerzutki.setFont(new Font("Lato", Font.PLAIN, 15));

        comboPrzerzutki = new JComboBox<>();
        comboPrzerzutki.setBounds(310,150,75,30);
        comboPrzerzutki.setFont(new Font("Lato", Font.PLAIN, 15));
        comboPrzerzutki.addItem("0");
        for(int i = 2; i<21; ++i)
            comboPrzerzutki.addItem(i+"");

        lbCzyAmortyzowany = new JLabel("Liczba amortyzatorów");
        lbCzyAmortyzowany.setBounds(160,200,150,30);
        lbCzyAmortyzowany.setFont(new Font("Lato", Font.PLAIN, 15));

        comboAmortyzatory = new JComboBox<>();
        comboAmortyzatory.setBounds(310,200,100,30);
        comboAmortyzatory.setFont(new Font("Lato", Font.PLAIN, 15));
        comboAmortyzatory.addItem("Brak");
        for(int i = 1; i < 9; ++i)
            comboAmortyzatory.addItem(i+"");

        btnDodaj = new JButton("Dodaj");
        btnDodaj.setBounds(180,280,230,50);
        btnDodaj.setFont(new Font("Lato", Font.PLAIN, 18));

        btnDodaj.addActionListener(e->{
            if(!(tfNazwa.getText().isEmpty() ||tfRozmiar.getText().isEmpty()) || !(tfNazwa.getText().isEmpty() ||tfDlugosc.getText().isEmpty() ||tfSzerokosc.getText().isEmpty() ||tfWysokosc.getText().isEmpty()))  {

                if(tfRozmiar.getText().isEmpty()) {
                    parseDl = Integer.parseInt(tfDlugosc.getText());
                    parseSz = Integer.parseInt(tfSzerokosc.getText());
                    parseWys = Integer.parseInt(tfWysokosc.getText());
                    parseRozmiar = parseDl * parseSz * parseWys;
                }
                else
                    parseRozmiar = Integer.parseInt(tfRozmiar.getText());

                if(comboCzyZlozony.getSelectedIndex()==1){
                    parseRozmiar=parseRozmiar/2;
                }

                try {
                    int liczbaPrzerzutek = Integer.parseInt(comboPrzerzutki.getSelectedItem() + "");
                    int liczbaAmortyzatorow;
                    if (comboAmortyzatory.getSelectedIndex()!=0)
                        liczbaAmortyzatorow = Integer.parseInt(comboAmortyzatory.getSelectedItem()+"");
                    else
                        liczbaAmortyzatorow = 0;

                    String hamulce = comboHamulce.getSelectedItem() + "";

                    //Stworzenie i dodanie obiektu do listy
                    Rower nowyRower = new Rower(
                            obecnePom.getIdPom(),
                            tfNazwa.getText(),
                            liczbaPrzerzutek,
                            liczbaAmortyzatorow,
                            hamulce,
                            parseRozmiar
                    );

                    //Wyzerowanie panelu do wpisywania
                    tfNazwa.setText("");
                    tfRozmiar.setText("");
                    tfDlugosc.setText("");
                    tfSzerokosc.setText("");
                    tfWysokosc.setText("");
                    comboCzyZlozony.setSelectedIndex(0);
                    comboPrzerzutki.setSelectedIndex(0);
                    comboAmortyzatory.setSelectedIndex(0);
                    comboHamulce.setSelectedIndex(0);

                    //Dodanie swojego rozmiaru do rozmiaru pomieszczenia
                    obecnePom.setMiejsceZajete(obecnePom.getMiejsceZajete() + parseRozmiar);
                    listaPrzedmiotow.add(nowyRower);

                    JOptionPane.showMessageDialog(null, "Dodano nowy przedmiot ", "Sukces", JOptionPane.INFORMATION_MESSAGE);

                }catch (TooManyThingsException ex){
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
        add(lbCzyZlozony);
        add(comboCzyZlozony);
        add(lbHamulce);
        add(comboHamulce);
        add(lbPrzerzutki);
        add(comboPrzerzutki);
        add(lbCzyAmortyzowany);
        add(comboAmortyzatory);
        add(btnDodaj);
    }
}
