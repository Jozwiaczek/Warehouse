package start.uzytkownik.osoba;

import defaultFrame.DefaultFrame;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OsobaMenuPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private Osoba obecnaOsoba = OsobaWyborPanel.obecnaOsoba;

    private JLabel arrowBack, lbTitle;
    private JButton btnDane, btnPomieszczenia;

    public OsobaMenuPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Menu "+ obecnaOsoba.getImie() +" "+ obecnaOsoba.getNazwisko());
        lbTitle.setBounds(165,50,400,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        btnDane = new JButton("Twoje dane");
        btnDane.setBounds(130,250,150,50);
        btnDane.setFont(new Font("Lato", Font.PLAIN, 18));

        btnPomieszczenia = new JButton("Pomieszczenia");
        btnPomieszczenia.setBounds(320,250,150,50);
        btnPomieszczenia.setFont(new Font("Lato", Font.PLAIN, 18));


        btnDane.addActionListener( e-> {
                OsobaInfoPanel jp = new OsobaInfoPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        btnPomieszczenia.addActionListener( e-> {
                PomieszczenieMenuPanel jp = new PomieszczenieMenuPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                OsobaWyborPanel jp = new OsobaWyborPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
            }
        });

        df.add(this);
        add(arrowBack);
        add(lbTitle);
        add(btnDane);
        add(btnPomieszczenia);
    }
    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
