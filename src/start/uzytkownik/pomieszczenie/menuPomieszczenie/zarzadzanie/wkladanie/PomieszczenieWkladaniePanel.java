package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.wkladanie;

import defaultFrame.DefaultFrame;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.PomieszczenieZarzadzaniePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PomieszczenieWkladaniePanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private RzeczWkladaniePanel jpRzecz;
    private SamochodWkladaniePanel jpSamochod;
    private MotorWkladaniePanel jpMotor;
    private RowerWkladaniePanel jpRower;

    private JLabel arrowBack, lbTitle, lbCoWlozyc;
    private JComboBox<String> comboWyborPrzedmiot;

    public PomieszczenieWkladaniePanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Wkładanie przedmiotów");
        lbTitle.setBounds(140,30,400,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        lbCoWlozyc = new JLabel("Co chcesz włożyć?");
        lbCoWlozyc.setBounds(205,100,400,80);
        lbCoWlozyc.setFont(new Font("Lato", Font.PLAIN, 18));

        comboWyborPrzedmiot = new JComboBox<>();
        comboWyborPrzedmiot.addItem("Rzecz");
        comboWyborPrzedmiot.addItem("Samochod");
        comboWyborPrzedmiot.addItem("Motor");
        comboWyborPrzedmiot.addItem("Rower");
        comboWyborPrzedmiot.setBounds(180,140,200,80);
        comboWyborPrzedmiot.setFont(new Font("Lato", Font.PLAIN, 18));

        jpRzecz = new RzeczWkladaniePanel();
        jpRzecz.setBounds(0,210,600,600);

        jpSamochod = new SamochodWkladaniePanel();
        jpSamochod.setBounds(0,210,600,600);

        jpMotor = new MotorWkladaniePanel();
        jpMotor.setBounds(0,210,600,600);

        jpRower = new RowerWkladaniePanel();
        jpRower.setBounds(0,210,600,600);

        jpSamochod.setVisible(false);
        jpMotor.setVisible(false);
        jpRower.setVisible(false);

        comboWyborPrzedmiot.addActionListener(a-> {
                jpRzecz.setVisible(false);
                jpSamochod.setVisible(false);
                jpMotor.setVisible(false);
                jpRower.setVisible(false);
                switch(comboWyborPrzedmiot.getSelectedIndex()){
                    case 0:{
                        jpRzecz.setVisible(true);
                        break;
                    }
                    case 1:{
                        jpSamochod.setVisible(true);
                        break;
                    }
                    case 2:{
                        jpMotor.setVisible(true);
                        break;
                    }
                    case 3:{
                        jpRower.setVisible(true);
                        break;
                    }
                }
        });

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
        add(lbCoWlozyc);
        add(comboWyborPrzedmiot);
        add(jpRzecz);
        add(jpSamochod);
        add(jpMotor);
        add(jpRower);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
