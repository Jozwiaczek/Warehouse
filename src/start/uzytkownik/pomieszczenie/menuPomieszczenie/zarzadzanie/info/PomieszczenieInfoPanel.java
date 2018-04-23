package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.info;

import defaultFrame.DefaultFrame;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.PomieszczenieZarzadzaniePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PomieszczenieInfoPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;

    private JLabel arrowBack, lbTitle, lbNumerPom, lbRozmiar, lbDataRozpoczecia, lbDataZakonczenia, lbIloscDni,lbZawartoscPom;

    public PomieszczenieInfoPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Pomieszczenie info");
        lbTitle.setBounds(160,50,400,50);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        lbNumerPom = new JLabel("Id: "+ obecnePom.getIdPom());
        lbNumerPom.setBounds(100,150,150,50);
        lbNumerPom.setFont(new Font("Lato", Font.PLAIN, 18));

        lbRozmiar = new JLabel("Rozmiar: "+ obecnePom.getRozmiar()+"m3");
        lbRozmiar.setBounds(320,150,200,50);
        lbRozmiar.setFont(new Font("Lato", Font.PLAIN, 18));

        lbDataRozpoczecia = new JLabel("Data rozpoczęcia najmu: "+ obecnePom.getDataRozpoczeciaNajmu());
        lbDataRozpoczecia.setBounds(100,200,300,50);
        lbDataRozpoczecia.setFont(new Font("Lato", Font.PLAIN, 18));

        lbDataZakonczenia = new JLabel("Data zakończenia najmu: "+ obecnePom.getDataZakonczeniaNajmu());
        lbDataZakonczenia.setBounds(100,250,400,50);
        lbDataZakonczenia.setFont(new Font("Lato", Font.PLAIN, 18));

        lbIloscDni = new JLabel("Ilość dni najmu: "+ obecnePom.getIloscDni());
        lbIloscDni.setBounds(100,300,400,50);
        lbIloscDni.setFont(new Font("Lato", Font.PLAIN, 18));

        lbZawartoscPom = new JLabel("Zawartość pomieszczenia:");
        lbZawartoscPom.setBounds(100,350,400,50);
        lbZawartoscPom.setFont(new Font("Lato", Font.PLAIN, 18));


        PomieszczenieZawartoscPanel pomieszczenieZawartoscPanel = new PomieszczenieZawartoscPanel();
        pomieszczenieZawartoscPanel.setBounds(100,400,200,150);
        pomieszczenieZawartoscPanel.setFont(new Font("Lato", Font.PLAIN, 15));

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PomieszczenieZarzadzaniePanel jp = new PomieszczenieZarzadzaniePanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
            }
        });

        df.add(this);
        add(arrowBack);
        add(lbTitle);
        add(lbNumerPom);
        add(lbRozmiar);
        add(lbIloscDni);
        add(lbDataRozpoczecia);
        add(lbDataZakonczenia);
        add(lbZawartoscPom);
        add(pomieszczenieZawartoscPanel);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
