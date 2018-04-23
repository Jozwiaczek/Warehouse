package start.uzytkownik.pomieszczenie.menuPomieszczenie;

import defaultFrame.DefaultFrame;
import myException.NeverRentException;
import start.Main;
import start.uzytkownik.osoba.Osoba;
import start.uzytkownik.osoba.OsobaWyborPanel;
import start.uzytkownik.pomieszczenie.Pomieszczenie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PomieszczenieWynajmijPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private Osoba obecnaOsoba = OsobaWyborPanel.obecnaOsoba;
    private Pomieszczenie obecnePom = PomieszczenieWyborPanel.obecnePom;
    private ArrayList<Pomieszczenie> listaPom = Main.listaPom;

    private JLabel arrowBack, lbTitle, lbWybierzWolne, lbIloscDni;
    private JButton btnWynajmij;
    private JTextField tfIloscDni;
    private JComboBox<Pomieszczenie> comboPomZajete;

    public PomieszczenieWynajmijPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        lbTitle = new JLabel("Wynajem");
        lbTitle.setBounds(240,50,200,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        lbWybierzWolne = new JLabel("Wybierz wolne pomieszczenie");
        lbWybierzWolne.setBounds(180,120,400,80);
        lbWybierzWolne.setFont(new Font("Lato", Font.PLAIN, 18));

        comboPomZajete = new JComboBox<>();
        for(Pomieszczenie p : listaPom)
            if(p.getIdPrzypisanaOsoba()==0 && p.getStatusPomieszczenia()==true)
                comboPomZajete.addItem(p);
        comboPomZajete.setBounds(200,170,200,80);
        comboPomZajete.setFont(new Font("Lato", Font.PLAIN, 18));


        lbIloscDni = new JLabel("Wpisz ilość dni najmu");
        lbIloscDni.setBounds(210,250,300,80);
        lbIloscDni.setFont(new Font("Lato", Font.PLAIN, 18));

        tfIloscDni = new JTextField();
        tfIloscDni.setBounds(220,320,150,30);
        tfIloscDni.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWynajmij = new JButton("Wynajmij");
        btnWynajmij.setBounds(180,450,250,50);
        btnWynajmij.setFont(new Font("Lato", Font.PLAIN, 18));

        btnWynajmij.addActionListener(e->{
                if(!(tfIloscDni.getText().isEmpty())) {

                    //Przypisanie wyboru do obencego pomieszczenia
                    obecnePom =(Pomieszczenie)comboPomZajete.getSelectedItem();

                    //Wstawienie w comboboxie - w miejsce wynajętego pomieszczenia

                    //Przypisanie Osoby
                    obecnePom.setIdPrzypisanaOsoba(obecnaOsoba.getIdOsoba());

                    //Data rozpoczęcia najmu
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
                    Date dataDzisiejsza = new Date();
                    String dataRozpoczeciaNajmu = dateFormat.format(dataDzisiejsza);
                    obecnePom.setDataRozpoczeciaNajmu(dataRozpoczeciaNajmu);

                    //Ilość Dni
                    int iloscDni = Integer.parseInt(tfIloscDni.getText());
                    obecnePom.setIloscDni(iloscDni);

                    //Data zakończenia najmu
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dataDzisiejsza);
                    calendar.add(Calendar.DATE, iloscDni);
                    dataDzisiejsza = calendar.getTime();
                    String dataZakonczeniaNajmu = dateFormat.format(dataDzisiejsza);
                    obecnePom.setDataZakonczeniaNajmu(dataZakonczeniaNajmu);

                    //Sprawdzenie i ustawienie daty pierwszego najmu
                    boolean czyJestDataPierwszegoNajmu=false;
                    try {
                        if (obecnaOsoba.getDataPierwszegoNajmu() == null)
                            czyJestDataPierwszegoNajmu=false;
                    }catch (NeverRentException e1){
                        System.err.println("Wynajmowanie pomieszczenia | Osoba nie wynajmowała jeszcze żadnego pomieszczenia");
                    }
                    if (czyJestDataPierwszegoNajmu==false)
                        obecnaOsoba.setDataPierwszegoNajmu(dataRozpoczeciaNajmu);

                    JOptionPane.showMessageDialog(null,"Wynajęto pomieszczenie","Sukces",JOptionPane.INFORMATION_MESSAGE);

                    //Powrót do menu pomieszczeń
                    PomieszczenieMenuPanel jp = new PomieszczenieMenuPanel();
                    df.setVisible(false);
                    df.dispose();
                    jp.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(null,"Uzpełnij ilość dni najmu","Błąd",JOptionPane.ERROR_MESSAGE);
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
        add(lbWybierzWolne);
        add(comboPomZajete);
        add(lbIloscDni);
        add(tfIloscDni);
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
