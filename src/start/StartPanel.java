package start;

import start.uzytkownik.osoba.OsobaWyborPanel;
import defaultFrame.DefaultFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();

    private JButton btnOsoba, btnPom, btnClose;
    private JLabel title;

    public StartPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        Main.proceduraDatyZakonczenieNajmu();

        title = new JLabel("Magazyn");
        title.setBounds(160,10,300,200);
        title.setFont(new Font("Lato", Font.PLAIN, 70));

        btnOsoba = new JButton("Wybór osoby");
        btnOsoba.setBounds(130,250,150,50);
        btnOsoba.setFont(new Font("Lato", Font.PLAIN, 18));

        btnPom = new JButton("Stan magazynu");
        btnPom.setBounds(320,250,150,50);
        btnPom.setFont(new Font("Lato", Font.PLAIN, 18));

        btnClose = new JButton("Zamknij aplikacje");
        btnClose.setBounds(190,420,240,50);
        btnClose.setFont(new Font("Lato", Font.PLAIN, 18));

        btnClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                Object[] options = {"Tak", "Nie"};
                String komunikat = "Czy na pewno chcesz zamknąć aplikacje?";
                int dialogClose = JOptionPane.showOptionDialog(null,
                        komunikat,
                        null,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,//Napisy w przyciaskach
                        options[0]);//Domyślnie zaznaczony button

                if (dialogClose == JOptionPane.YES_OPTION)
                    System.exit(0);
            }

        });

        btnOsoba.addActionListener(e->{
                OsobaWyborPanel osobaWyborPanel = new OsobaWyborPanel();
                df.setVisible(false);
                df.dispose();
                osobaWyborPanel.setVisible(true);
            });

        btnPom.addActionListener(e->{
                StanMagazynuPanel stanMagazynuPanel = new StanMagazynuPanel();
                df.setVisible(false);
                df.dispose();
                stanMagazynuPanel.setVisible(true);
            });

        df.add(this);
        add(title);
        add(btnOsoba);
        add(btnPom);
        add(btnClose);
    }
}