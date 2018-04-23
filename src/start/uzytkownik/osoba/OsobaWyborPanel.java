package start.uzytkownik.osoba;

import defaultFrame.DefaultFrame;
import start.Main;
import start.StartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OsobaWyborPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private ArrayList<Osoba> listaOsob = Main.listaOsob;
    public static Osoba obecnaOsoba = new Osoba(null,null,null,null,null);

    private JLabel arrowBack, lbTitle;
    private JButton btnChoose;
    private JComboBox<String> comboOsobaWybor;

    public OsobaWyborPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Wybór osoby");
        lbTitle.setBounds(215,50,400,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        comboOsobaWybor = new JComboBox<>();
        for(Osoba osoba : listaOsob){
            comboOsobaWybor.addItem(osoba.getImie()+" "+osoba.getNazwisko());
        }

        comboOsobaWybor.setBounds(210,150,200,150);
        comboOsobaWybor.setFont(new Font("Lato", Font.PLAIN, 20));

        btnChoose = new JButton("Wybierz");
        btnChoose.setBounds(180,330,250,50);
        btnChoose.setFont(new Font("Lato", Font.PLAIN, 18));

        btnChoose.addActionListener( e-> {
                obecnaOsoba = listaOsob.get(comboOsobaWybor.getSelectedIndex());

                OsobaMenuPanel osobaMenuPanel = new OsobaMenuPanel();
                df.setVisible(false);
                df.dispose();
                osobaMenuPanel.setVisible(true);
        });

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                StartPanel startPanel = new StartPanel();
                df.setVisible(false);
                df.dispose();
                startPanel.setVisible(true);
            }
        });

        df.add(this);
        add(arrowBack);
        add(lbTitle);
        add(comboOsobaWybor);
        add(btnChoose);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
