package start;

import  defaultFrame.DefaultFrame;
import start.uzytkownik.osoba.Osoba;
import start.uzytkownik.pomieszczenie.Pomieszczenie;
import start.uzytkownik.pomieszczenie.menuPomieszczenie.zarzadzanie.przedmiot.Przedmiot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StanMagazynuPanel extends JPanel {

    private DefaultFrame df = new DefaultFrame();
    private ArrayList<Pomieszczenie> listaPom = Main.listaPom;
    private ArrayList<Osoba> listaOsob = Main.listaOsob;

    private JLabel arrowBack, lbTitle, lbWielkoscMagazynu, lbZajeteMiejsceMagazyn, lbWolneMiejsceMagazyn, lbIloscPom, lbZajeteMiejscePom, lbWolneMiejscePom, lbIloscOsob;
    private JButton btnZapiszStan;
    private int wielkoscMagazynu=0, zajeteMiejsceMagazyn =0, wolneMiejsceMagazyn, zajeteMiejscePom =0, wolneMiejscePom;
    private JProgressBar pbPowierzchniaMagazynu, pbIloscPomieszczen;

    public StanMagazynuPanel(){
        setBackground(Color.WHITE);
        setLayout(null);

        arrowBack = new JLabel();
        arrowBack.setBounds(20,0, 43, 30);
        arrowBack.setIcon(ResizeImage("img/arrowBack.jpg"));

        for(Pomieszczenie p : listaPom){
            wielkoscMagazynu += p.getRozmiar();
            if (p.getIdPrzypisanaOsoba()!=0) {
                zajeteMiejsceMagazyn += p.getRozmiar();
                zajeteMiejscePom++;
            }
        }

        wolneMiejsceMagazyn = wielkoscMagazynu- zajeteMiejsceMagazyn;
        wolneMiejscePom = listaPom.size()- zajeteMiejscePom;

        lbTitle = new JLabel("Aktualny stan magazynu");
        lbTitle.setBounds(140,20,400,80);
        lbTitle.setFont(new Font("Lato", Font.PLAIN, 30));

        lbWielkoscMagazynu = new JLabel("Wielkosc Magazynu:  "+wielkoscMagazynu+"m3");
        lbWielkoscMagazynu.setBounds(200,110,400,50);
        lbWielkoscMagazynu.setFont(new Font("Lato", Font.PLAIN, 17));

        lbZajeteMiejsceMagazyn = new JLabel("Zajęte");
        lbZajeteMiejsceMagazyn.setBounds(180,150,100,50);
        lbZajeteMiejsceMagazyn.setFont(new Font("Lato", Font.PLAIN, 12));

        lbWolneMiejsceMagazyn = new JLabel("Wolne");
        lbWolneMiejsceMagazyn.setBounds(380,150,100,50);
        lbWolneMiejsceMagazyn.setFont(new Font("Lato", Font.PLAIN, 12));

        pbPowierzchniaMagazynu = new JProgressBar(0,wielkoscMagazynu);
        pbPowierzchniaMagazynu.setValue(zajeteMiejsceMagazyn);
        pbPowierzchniaMagazynu.setStringPainted(true);
        pbPowierzchniaMagazynu.setBounds(160,145,300,100);
        pbPowierzchniaMagazynu.setFont(new Font("Lato", Font.PLAIN, 12));

        lbIloscPom = new JLabel("Ilość pomieszczeń:  "+listaOsob.size());
        lbIloscPom.setBounds(230,220,400,50);
        lbIloscPom.setFont(new Font("Lato", Font.PLAIN, 17));

        lbZajeteMiejscePom = new JLabel("Wynajęte");
        lbZajeteMiejscePom.setBounds(180,250,100,50);
        lbZajeteMiejscePom.setFont(new Font("Lato", Font.PLAIN, 12));

        lbWolneMiejscePom = new JLabel("Wolne");
        lbWolneMiejscePom.setBounds(380,250,100,50);
        lbWolneMiejscePom.setFont(new Font("Lato", Font.PLAIN, 12));

        pbIloscPomieszczen = new JProgressBar(0,listaOsob.size());
        pbIloscPomieszczen.setValue(zajeteMiejscePom);
        pbIloscPomieszczen.setStringPainted(true);
        pbIloscPomieszczen.setBounds(160,240,300,100);
        pbIloscPomieszczen.setFont(new Font("Lato", Font.PLAIN, 12));

        lbIloscOsob = new JLabel("Ilość osób:  "+listaPom.size());
        lbIloscOsob.setBounds(260,320,400,50);
        lbIloscOsob.setFont(new Font("Lato", Font.PLAIN, 17));

        btnZapiszStan = new JButton("Zapisz pełny aktualny stan magazynu");
        btnZapiszStan.setBounds(135,420,350,50);
        btnZapiszStan.setFont(new Font("Lato", Font.PLAIN, 18));

        btnZapiszStan.addActionListener( e-> {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy | HH:mm");
                Date data = new Date();
                String dataDzisiejsza = dateFormat.format(data);

                try{
                    FileWriter writer = new FileWriter("stanMagazynu.txt ");

                    writer.write("Stan Magazynu na dzień "+dataDzisiejsza);
                    writer.write(System.getProperty("line.separator"));
                    for(Pomieszczenie pom : listaPom) {
                        ArrayList<Przedmiot> listaPrzedmiotowWPom = Main.getListaPrzedmiotowWPom(pom);
                        writer.write(System.getProperty("line.separator"));
                        writer.write(System.getProperty("line.separator"));
                        writer.write("######");
                        writer.write(System.getProperty("line.separator"));
                        writer.write("Pomieszczenie: " + pom.getIdPom()+" | Rozmiar: "+pom.getRozmiar()+"m3");
                        writer.write(System.getProperty("line.separator"));
                        if(pom.getIdPrzypisanaOsoba()!=0) {
                            for (Osoba osoba : listaOsob)
                                if (pom.getIdPrzypisanaOsoba() == osoba.getIdOsoba()) {
                                    writer.write("Przypisana osoba: " + osoba.getImie() + " " + osoba.getNazwisko());
                                    writer.write(System.getProperty("line.separator"));
                                    if(listaPrzedmiotowWPom.size()!=0){
                                        writer.write("Przedmioty w pomieszczeniu: ");
                                        writer.write(System.getProperty("line.separator"));
                                        for(Przedmiot przedmiot : listaPrzedmiotowWPom) {
                                                writer.write(przedmiot.getNazwa()+" "+przedmiot.getRozmiar()+"m3");
                                                writer.write(System.getProperty("line.separator"));
                                        }
                                    }
                                    else {
                                        writer.write("Brak przedmiotów w pomieszczeniu");
                                        writer.write(System.getProperty("line.separator"));
                                    }
                                }
                        }
                        else {
                            writer.write("Pomieszczenie nie jest wynajmowane");
                            writer.write(System.getProperty("line.separator"));
                        }

                    }

                    writer.close();

                    JOptionPane.showMessageDialog(null,"Zapisano aktualny stan magazynu","Sukces",JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e2){
                    JOptionPane.showMessageDialog(null,"Błąd zapisu","Błąd",JOptionPane.ERROR_MESSAGE);
                }
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
        add(lbWielkoscMagazynu);
        add(lbZajeteMiejsceMagazyn);
        add(lbWolneMiejsceMagazyn);
        add(pbPowierzchniaMagazynu);
        add(lbIloscPom);
        add(lbZajeteMiejscePom);
        add(lbWolneMiejscePom);
        add(pbIloscPomieszczen);
        add(lbIloscOsob);
        add(btnZapiszStan);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(arrowBack.getWidth(), arrowBack.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
