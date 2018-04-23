package start.uzytkownik.pomieszczenie.menuPomieszczenie;

import defaultFrame.DefaultFrame;
import start.uzytkownik.osoba.OsobaMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PomieszczenieMenuPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();

    private JLabel arrowBack, lbTitle;
    private JButton btnZarzadzanie, btnWynajmij;

    public PomieszczenieMenuPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Pomieszczenie");
        lbTitle.setBounds(200,50,200,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        btnZarzadzanie = new JButton("Zarządzanie pomieszczeniami");
        btnZarzadzanie.setBounds(150,200,300,50);
        btnZarzadzanie.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWynajmij = new JButton("Wynajmij nowe pomieszczenie");
        btnWynajmij.setBounds(150,300,300,50);
        btnWynajmij.setFont(new Font("Lato", Font.PLAIN, 18));

        btnZarzadzanie.addActionListener( e ->{
                PomieszczenieWyborPanel jp = new PomieszczenieWyborPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        btnWynajmij.addActionListener(e->{
                PomieszczenieWynajmijPanel jp = new PomieszczenieWynajmijPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

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
        add(btnZarzadzanie);
        add(btnWynajmij);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
