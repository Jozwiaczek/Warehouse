package start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie;

import defaultFrame.DefaultFrame;
import start.Main;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.PomieszczenieWyborPanel;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PomieszczenieWyjmowaniePanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private ArrayList<Przedmiot> listaPrzedmiotow = Main.listaPrzedmiotow;
    private Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;

    private JLabel arrowBack, lbTitle, lbRzecz;
    private JButton btnWyjmijRzecz;
    private JPanel jpPomocnicze;

    public PomieszczenieWyjmowaniePanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Wyjmowanie przedmiotow");
        lbTitle.setBounds(120,50,400,50);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        GridLayout layout = new GridLayout(0,2);

        jpPomocnicze = new JPanel();
        jpPomocnicze.setBackground(Color.WHITE);
        jpPomocnicze.setBounds(100,150,400,400);
        jpPomocnicze.setLayout(layout);

        for(Przedmiot przedmiot : listaPrzedmiotow){
            if(przedmiot.getIdPom()==obecnePom.getIdPom()) {
                lbRzecz = new JLabel(przedmiot.getNazwa());
                btnWyjmijRzecz = new JButton("Wyjmij");
                jpPomocnicze.add(btnWyjmijRzecz);
                jpPomocnicze.add(lbRzecz);
                btnWyjmijRzecz.addActionListener(e->{
                        listaPrzedmiotow.remove(przedmiot);
                        PomieszczenieWyjmowaniePanel jp = new PomieszczenieWyjmowaniePanel();
                        df.setVisible(false);
                        df.dispose();
                        jp.setVisible(true);
                });
            }
        }

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
        add(jpPomocnicze);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
