package projectApps;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class AboutProgram extends JFrame {

    JPanel panel2 = new JPanel(new GridBagLayout());
    JLabel lTytul = new JLabel("O programie");

    JButton bBack = new JButton("Powrót");

    public AboutProgram() {


        //Main settings
        super("Test Case Generator - Tabele Eksportowe STRUKTURY- opis szablonu");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        setLayout(new FlowLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\background2.jpg"));
        add(background);
        background.setLayout(new GridBagLayout());


        GridBagConstraints gbcbBack= new GridBagConstraints();

        GridBagConstraints gbcbLabelka= new GridBagConstraints();

        GridBagConstraints gbcbPicLabel= new GridBagConstraints();


        /**************************************************************************/


        //Field 1 - label and field
        gbcbBack.insets = new Insets(-640,-1400,2,0);
        gbcbLabelka.insets = new Insets(-580,350,2,0);
        gbcbPicLabel.insets = new Insets(0,-750,2,0);

        background.add(lTytul,gbcbLabelka);
        background.add(bBack,gbcbBack);






        lTytul.setFont(new Font("Serif",Font.BOLD,20));

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dispose();


            }
        });

    }
}