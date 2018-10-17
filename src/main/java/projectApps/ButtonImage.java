package projectApps;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;



public class ButtonImage  extends JFrame {
    JButton bGenerate;
    JButton bTabeleEksportoweStruktury;
    JButton bTabeleImportoweStruktury;
    JButton bTabeleImportoweReguly;
    JButton bPlikiOrin;
    JButton bRFSFieldToField;
    JButton bRFSSumyKontrolne;
    JButton bRFSWalidacjaBez;
    JButton bRFSWalidacjaZ;

    BufferedImage imgQuestionMark;


    ButtonImage() throws IOException {
        ImageIcon imgTickOK = new ImageIcon(getClass().getResource("/if_tick_16_22643.png"));

        bGenerate = new JButton("GENERUJ",imgTickOK);
        setVisible(false);
        setDefaultCloseOperation((EXIT_ON_CLOSE));
        dispose();





        ImageIcon imgTabeleImportoweReguly = new ImageIcon(getClass().getResource("/questionMark.png"));
        bTabeleEksportoweStruktury = new JButton("Tabele Eksportowe - STRUKTURY");



        ImageIcon imgTabeleImportoweStruktury = new ImageIcon(getClass().getResource("/questionMark.png"));
        bTabeleImportoweStruktury = new JButton("Tabele Importowe - STRUKTURY" );



        imgTabeleImportoweReguly = new ImageIcon(getClass().getResource("/questionMark.png"));
        bTabeleImportoweReguly = new JButton("Tabele Importowe - REGUŁY" );



        ImageIcon imgPlikiOrin = new ImageIcon(getClass().getResource("/questionMark.png"));
        bPlikiOrin = new JButton("Pliki ORIN - REGUŁY" );



        ImageIcon imgRFSFieldToField = new ImageIcon(getClass().getResource("/questionMark.png"));
        bRFSFieldToField = new JButton("RFS -Field To Field" );



        ImageIcon imgRFSSumyKontrolne = new ImageIcon(getClass().getResource("/questionMark.png"));
        bRFSSumyKontrolne = new JButton("RFS - Sumy kontrolne");



        ImageIcon imgRFSWalidacjaBez =new ImageIcon(getClass().getResource("/questionMark.png"));
        bRFSWalidacjaBez = new JButton("RFS - Sumy kont. bez odrz." );



        ImageIcon imgRFSWalidacjaZ = new ImageIcon(getClass().getResource("/questionMark.png"));
        bRFSWalidacjaZ = new JButton("RFS - Sumy kont. z odrz." );

    }




    {
        try {
            imgQuestionMark = ImageIO.read(getClass().getResource("/questionMark.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    JLabel lQuestionMarkBatchFile = new JLabel(new ImageIcon(imgQuestionMark));
    JLabel lQuestionMarkNameDoc = new JLabel(new ImageIcon(imgQuestionMark));
    JLabel lQuestionMarkNumberTestCase = new JLabel(new ImageIcon(imgQuestionMark));
    JLabel lQuestionMarkEndDateTest = new JLabel(new ImageIcon(imgQuestionMark));
    JLabel lQuestionMarkShortName = new JLabel(new ImageIcon(imgQuestionMark));
    JLabel lQuestionMarkEndFile = new JLabel(new ImageIcon(imgQuestionMark));

}
