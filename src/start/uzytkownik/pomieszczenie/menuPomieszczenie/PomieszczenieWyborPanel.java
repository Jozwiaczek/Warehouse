package start.uzytkownik.pomieszczenie.menuPomieszczenie;

import defaultFrame.DefaultFrame;
import start.Main;
import start.uzytkownik.osoba.Osoba;
import start.uzytkownik.osoba.OsobaWyborPanel;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieMenuPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.PomieszczenieZarzadzaniePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PomieszczenieWyborPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private ArrayList<Pomieszczenie> listaPom = Main.listaPom;
    private Osoba obecnaOsoba = OsobaWyborPanel.obecnaOsoba;
    public static Pomieszczenie obecnePom = new Pomieszczenie(true,0);

    private JLabel arrowBack, lbTitle, lbWybierz;
    private JButton btnWybierz;
    private JComboBox<Pomieszczenie> comboPomWybor;

    public PomieszczenieWyborPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Twoje pomieszczenia");
        lbTitle.setBounds(160,50,300,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        lbWybierz = new JLabel("Wybierz swoje pomieszczenie");
        lbWybierz.setBounds(180,160,400,80);
        lbWybierz.setFont(new Font("Lato", Font.PLAIN, 18));

        comboPomWybor = new JComboBox<>();
        for(Pomieszczenie p : listaPom)
            if(p.getIdPrzypisanaOsoba()== obecnaOsoba.getIdOsoba())
                comboPomWybor.addItem(p);
        comboPomWybor.setBounds(200,210,200,80);
        comboPomWybor.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWybierz = new JButton("Wybierz");
        btnWybierz.setBounds(170,350,250,50);
        btnWybierz.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWybierz.addActionListener(e->{

                obecnePom=(Pomieszczenie)comboPomWybor.getSelectedItem();

                PomieszczenieZarzadzaniePanel jp = new PomieszczenieZarzadzaniePanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PomieszczenieMenuPanel jp = new PomieszczenieMenuPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
            }
        });

        df.add(this);
        add(arrowBack);
        add(lbTitle);
        add(lbWybierz);
        add(comboPomWybor);
        add(btnWybierz);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
