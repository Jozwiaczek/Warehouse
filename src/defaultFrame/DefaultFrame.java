package defaultFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DefaultFrame extends JFrame{

    private JLabel close;

    public DefaultFrame(){
        setUndecorated(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.setBackground(Color.WHITE);

        close = new JLabel();
        close.setBounds(560, 15, 25, 20);
        close.setIcon(ResizeImage("img/closeX.jpg"));
        close.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                closeWarning();
            }

        });

        add(jp,BorderLayout.NORTH);
        jp.add(close,BorderLayout.EAST);

        setVisible(true);
    }

    private ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(close.getWidth(), close.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void closeWarning(){
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

        if(dialogClose == JOptionPane.YES_OPTION)
            System.exit(0);
    }

}

