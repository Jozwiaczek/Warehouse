package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie;

import defaultFrame.DefaultFrame;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.info.PomieszczenieInfoPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.wkladanie.PomieszczenieWkladaniePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PomieszczenieZarzadzaniePanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();

    private JLabel arrowBack, lbTitle;
    private JButton btnInfo, btnWyjmowanie, btnWkladanie;

    public PomieszczenieZarzadzaniePanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Zarządzanie pomieszczeniem");
        lbTitle.setBounds(110,50,400,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        btnInfo = new JButton("Info");
        btnInfo.setBounds(150,200,300,50);
        btnInfo.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWkladanie = new JButton("Wkładanie");
        btnWkladanie.setBounds(150,300,300,50);
        btnWkladanie.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWyjmowanie = new JButton("Wyjmowanie");
        btnWyjmowanie.setBounds(150,400,300,50);
        btnWyjmowanie.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWkladanie.addActionListener(e->{
                PomieszczenieWkladaniePanel jp = new PomieszczenieWkladaniePanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        btnInfo.addActionListener(e->{
                PomieszczenieInfoPanel jp = new PomieszczenieInfoPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        btnWyjmowanie.addActionListener(e->{
                PomieszczenieWyjmowaniePanel jp = new PomieszczenieWyjmowaniePanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
        });

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                PomieszczenieWyborPanel jp = new PomieszczenieWyborPanel();
                df.setVisible(false);
                df.dispose();
                jp.setVisible(true);
            }
        });

        df.add(this);
        add(arrowBack);
        add(lbTitle);
        add(btnWkladanie);
        add(btnInfo);
        add(btnWyjmowanie);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
