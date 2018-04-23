package start.uzytkownik.osoba;

import defaultFrame.DefaultFrame;
import myException.NeverRentException;
import start.Main;
import start.uzytkownik.pomieszczenie.Pomieszczenie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OsobaInfoPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private Osoba obecnaOsoba = OsobaWyborPanel.obecnaOsoba;
    private ArrayList<Pomieszczenie> listaPom = Main.listaPom;

    private JLabel arrowBack, lbTitle, lbImie, lbNazwisko, lbPesel, lbAdres, lbDataUrodzenia, lbDataNajmu, lbWynajetePom, lbPom;
    private String dataPierwszegoNajmu="Brak";
    private ArrayList<String> lbListaPom;

    public OsobaInfoPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Twoje dane");
        lbTitle.setBounds(230,10,400,50);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        lbImie = new JLabel("Imię: "+ obecnaOsoba.getImie());
        lbImie.setBounds(100,100,150,50);
        lbImie.setFont(new Font("Lato", Font.PLAIN, 18));

        lbNazwisko = new JLabel("Nazwisko: "+ obecnaOsoba.getNazwisko());
        lbNazwisko.setBounds(320,100,200,50);
        lbNazwisko.setFont(new Font("Lato", Font.PLAIN, 18));

        lbPesel = new JLabel("Pesel: "+ obecnaOsoba.getPesel());
        lbPesel.setBounds(100,150,300,50);
        lbPesel.setFont(new Font("Lato", Font.PLAIN, 18));

        lbDataUrodzenia = new JLabel("Data urodzenia: "+ obecnaOsoba.getDataUrodzenia());
        lbDataUrodzenia.setBounds(320,150,400,50);
        lbDataUrodzenia.setFont(new Font("Lato", Font.PLAIN, 18));

        lbAdres = new JLabel("Adres: "+ obecnaOsoba.getAdres());
        lbAdres.setBounds(100,200,400,50);
        lbAdres.setFont(new Font("Lato", Font.PLAIN, 18));

        try {
            dataPierwszegoNajmu=obecnaOsoba.getDataPierwszegoNajmu();
        }catch (NeverRentException e){
            System.err.println("Info osoby | Osoba nie wynajmowała jeszcze żadnego pomieszczenia");
        }

        lbDataNajmu = new JLabel("Data pierwszego najmu: " +dataPierwszegoNajmu);
        lbDataNajmu.setBounds(100,250,400,50);
        lbDataNajmu.setFont(new Font("Lato", Font.PLAIN, 18));

        lbWynajetePom = new JLabel("Wynajęte pomieszczenia: ");
        lbWynajetePom.setBounds(100,350,400,50);
        lbWynajetePom.setFont(new Font("Lato", Font.PLAIN, 18));

        lbPom = new JLabel("");
        lbPom.setBounds(100,400,400,50);
        lbPom.setFont(new Font("Lato", Font.PLAIN, 18));

        lbListaPom = new ArrayList<>();

        for(Pomieszczenie i : listaPom)
            if(i.getIdPrzypisanaOsoba()== obecnaOsoba.getIdOsoba())
                lbListaPom.add(i.getIdPom()+"  "+i.getRozmiar()+"m3");

        for (int i = 0; i < lbListaPom.size(); ++i)
            lbPom.setText(lbPom.getText() +"  "+lbListaPom.get(i)+"   | ");


        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                OsobaMenuPanel jp = new OsobaMenuPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
            }
        });

        df.add(this);
        add(arrowBack);
        add(lbTitle);
        add(lbImie);
        add(lbNazwisko);
        add(lbPesel);
        add(lbAdres);
        add(lbDataUrodzenia);
        add(lbDataNajmu);
        add(lbWynajetePom);
        add(lbPom);
    }

    private ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
