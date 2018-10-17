
package projectApps;

import sun.applet.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends JFrame{





    //Instancje klas w pakiecie projectApps
    ButtonImage bI = new ButtonImage();

    CommonElements common = new CommonElements();

    Location location = new Location();

    Style style = new Style();

    ProgressBar progressBar = new ProgressBar();


    BufferedImage myPicture;
    TabeleEksportoweStrukturyLinked tabEks = new TabeleEksportoweStrukturyLinked();
    TabeleImportoweStrukturyLinked tabImp = new TabeleImportoweStrukturyLinked();
    TabeleImportoweRegulyLinked tabImpReg = new TabeleImportoweRegulyLinked();
    PlikiOrinRegulyLinked plikiOrinReg = new PlikiOrinRegulyLinked();
    RfsFieldToField rfsFieldToField = new RfsFieldToField();
    RfsSumyKontrolne rfsSumyKontrolne = new RfsSumyKontrolne();
    RfsSumyKontBez rfsSumyKontBez = new RfsSumyKontBez();
    RfsSumyKontZ rfsSumyKontZ = new RfsSumyKontZ();

    AboutProgram aboutProgram = new AboutProgram();


    //Elementy graficzne w głównym oknie
    //Field 1 - label
    JLabel labelTemplate = new JLabel("Szablon przypadków testowych");
    //Field 1 - field
    String testCaseTemplate[]={
            //  "Wybierz...",
            "Tabele Eksportowe - STRUKTURY",
            "Tabele Importowe - STRUKTURY",
            "Tabele Importowe - REGUŁY",
            "Pliki ORIN - REGUŁY",
            "RFS - Field To Field",
            "RFS - Sumy kontrolne",
            "RFS - Walidacja sum kontrolnych bez rek. odrzuconych",
            "RFS - Walidacja sum kontrolnych z rek. odrzuconymi"
    };


    JComboBox templateList = new JComboBox(testCaseTemplate);


    //Field 2 - label
    JLabel labelBatchFile =  new JLabel("Plik wsadowy");
    //Field 2 - field
    JTextField fieldBatchFile = new HintTextField("");

    //Field 3 - label
    JLabel labelDocName = new JLabel("Nazwa dokumentu bazowego");
    //Field 3 - field
    JTextField fieldDocName = new HintTextField("");

    //Field 5 - label
    JLabel labelFinishDate = new JLabel("Data zakończenia testów");
    //Field 5 - field
    JTextField fieldFinishDate = new HintTextField("");

    //Field 6 - label
    JLabel labelShortNameTeam = new JLabel("Skrót wertykala");
    //Field 6 - field
    JTextField fieldShortNameTeam = new HintTextField("");

    //Field 7 - label
    JLabel labelFileEndPath = new JLabel("Katalog zapisu pliku");
    //Field 7 - field
    JTextField fieldFileEndPath = new HintTextField("");

    //Do szablonów - panel boczny
    //Field 8 - label
    JLabel labelTemplateDescription = new JLabel("OPIS SZABLONÓW");



    JButton buttonWybierzPlikWsadowy = new JButton("Wybierz plik");
    JButton buttonWybierzKatalogDocelowy = new JButton("Wybierz plik");

    JButton buttonReset= new JButton("Wyczyść wszystkie pola");

    JButton butonLogout = new JButton("Powrot");


    JMenuBar menuBar  = new JMenuBar();

    public static  void main (String[] args) throws IOException, FontFormatException {

       new LoginWindow();
       //new MainActivity();
        //new TabeleEksportoweStrukturyLinked();


    }


    public MainActivity(String login) throws IOException, FontFormatException {


        //Main settings
        super("Test Case Generator");
        setSize(1280,720);
        setResizable(true);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setLayout(new FlowLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\background2.jpg"));
        add(background);
        background.setLayout(new GridBagLayout());



        //Font, color settings
        templateList.setFont(style.fontMainActivityLabelListaField);
        labelBatchFile.setFont(style.fontMainActivityLabel);
        labelDocName.setFont(style.fontMainActivityLabel);
        labelFileEndPath.setFont(style.fontMainActivityLabel);
        labelFinishDate.setFont(style.fontMainActivityLabel);
        labelTemplate.setFont(style.fontMainActivityLabel);
        labelShortNameTeam.setFont(style.fontMainActivityLabel);
        labelTemplateDescription.setFont(style.fontMainActivityLabel);

        fieldBatchFile.setFont(style.fontMainActivityLabelListaField);
        fieldDocName.setFont(style.fontMainActivityLabelListaField);
        fieldFileEndPath.setFont(style.fontMainActivityLabelListaField);
        fieldFinishDate.setFont(style.fontMainActivityLabelListaField);
        fieldShortNameTeam.setFont(style.fontMainActivityLabelListaField);


        labelBatchFile.setForeground(style.colorLabel);
        labelDocName.setForeground(style.colorLabel);
        labelFileEndPath.setForeground(style.colorLabel);
        labelFinishDate.setForeground(style.colorLabel);
        labelTemplate.setForeground(style.colorLabel);
        labelShortNameTeam.setForeground(style.colorLabel);
        labelTemplateDescription.setForeground(style.colorLabel);

        common.appVersion.setFont(style.fontCommonText);
        common.copyRight.setFont(style.fontCommonText);
        common.appVersion.setForeground(style.colorCommonText);
        common.copyRight.setForeground(style.colorCommonText);












        // butt.setColumns(10);
        fieldDocName.setColumns(20);
        // fieldTcNumber.setColumns(20);
        fieldFinishDate.setColumns(20);
        fieldShortNameTeam.setColumns(20);
        fieldFileEndPath.setColumns(20);
        fieldBatchFile.setColumns(20);


        bI.bTabeleEksportoweStruktury.setPreferredSize(new Dimension(250,40));
        bI.bTabeleImportoweStruktury.setPreferredSize(new Dimension(250,40));
        bI.bTabeleImportoweReguly.setPreferredSize(new Dimension(250,40));
        bI.bPlikiOrin.setPreferredSize(new Dimension(250,40));
        bI.bRFSFieldToField.setPreferredSize(new Dimension(250,40));
        bI.bRFSSumyKontrolne.setPreferredSize(new Dimension(250,40));
        bI.bRFSWalidacjaBez.setPreferredSize(new Dimension(250,40));
        bI.bRFSWalidacjaZ.setPreferredSize(new Dimension(250,40));

        bI.bGenerate.setPreferredSize(new Dimension(220,60));


        buttonWybierzPlikWsadowy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                File f = fileChooser.getSelectedFile();
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String fileNameBatch = f.getAbsolutePath();
                    fieldBatchFile.setText(fileNameBatch);
                }
            }
        });


        buttonWybierzKatalogDocelowy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                File f = fileChooser.getSelectedFile();
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    String fileEndPatch = f.getAbsolutePath();
                    fieldFileEndPath.setText(fileEndPatch);
                }
            }
        });



        background.add(buttonWybierzPlikWsadowy);
        background.add(buttonWybierzKatalogDocelowy);

        //background.add(buttonWyczysc,gbcButtonWyczysc);




        // background.add(labelApplicationName,location.locationLabelNameApplication);


        bI.lQuestionMarkBatchFile.setToolTipText("Przy użyciu przycisku 'Wybierz plik' należy wskazać ścieżkę do pliku wsadowego");
        bI.lQuestionMarkNameDoc.setToolTipText("Wprowadź nazwę dokumentu głownego" +
                " np. Portland - DMT003 ACC DEF3000 do ICBS_v2.07 ");
        bI.lQuestionMarkNumberTestCase.setToolTipText("Podaj liczbę przypadków testowych do wygenerowania (ilość pól we wsadzie = liczba przypadków testowych)");
        bI.lQuestionMarkEndDateTest.setToolTipText("Wprowadź datę w formacie DD.MM.RRRR , np 30.06.2018");
        bI.lQuestionMarkShortName.setToolTipText("Wprowadź trzyliterowy skrót zespołu, np. ACC");
        bI.lQuestionMarkEndFile.setToolTipText("Podaj katalog w którym chcesz zapisac plik wynikowu, (nazwa pliku zostanie odpowiednio automatycznie nadana przez aplikację)");






        //Field 1 - labele and field
        background.add(labelTemplate, location.gbcLabelTemplate);
        background.add(templateList, location.gbcTemplateList);



        {
            try {
                myPicture = ImageIO.read(getClass().getResource("/separator8.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        JLabel picLabelSeparatorFirst = new JLabel(new ImageIcon(myPicture));
        JLabel picLabelSeparatorTwice = new JLabel(new ImageIcon(myPicture));

        background.add(picLabelSeparatorFirst,location.gbcSeparatorFirst);

        background.add(picLabelSeparatorTwice,location.gbcSeparatorTwice);

        //Field 2 - label and fieldbackground.add(labelBatchFile, gbcLabelBatchFile);
        background.add(buttonWybierzPlikWsadowy, location.gbcButtondBatchFile);
        background.add(bI.lQuestionMarkBatchFile,location.gbcLabelQuestionMarkBatchFile);

        background.add(labelBatchFile,location.gbcLabelBatchFile);

       background.add(fieldFileEndPath,location.gbcFieldEndFile);

        //Field 3 - label and field
        background.add(labelDocName, location.gbcLabelDocName );
        background.add(fieldDocName, location.gbcFieldDocName);
        background.add(bI.lQuestionMarkNameDoc, location.gbcLabelQuestionMarkNameDoc);



        //Field 4 - label and field
        // panel2.add(labelTcNumber, gbcLabelTcNumber);
        // panel2.add(fieldTcNumber, gbcFieldTcNumber);

        //panel2.add(bI.lQuestionMarkNumberTestCase,gbcLabelMarkNumberTestCase);



        //Field 5 - label and field
        background.add(labelFinishDate, location.gbcLabelFinishDate);
        background.add(fieldFinishDate, location.gbcFieldFinishDate);

        JLabel labelLogin = new JLabel("");
        labelLogin.setText(login);
        //background.add(labelLogin)

        background.add(bI.lQuestionMarkEndDateTest,location.gbcLabelMarkEndDateTest);


        //Field 6 - label and field
        background.add(labelShortNameTeam, location.gbcLabelShortNameTeam);
        background.add(fieldShortNameTeam, location.gbcFieldShortNameTeam);

        background.add(bI.lQuestionMarkShortName,location.gbcLabelMarkShortName);

        background.add(fieldBatchFile,location.gbcFieldBatchFile);
        //Field 7 - label and field
        background.add(labelFileEndPath, location.gbcLabelFileEndPath);
        background.add(bI.lQuestionMarkEndFile,location.gbcLabelMarkEndFile);
        background.add(buttonWybierzKatalogDocelowy, location.gbcButtonFileEndPath);

        //background.add(common.appVersion, location.locationAppVersionMain);
        background.add(common.copyRight, location.locationCopyRightMain);


        //Field 8 - label and field
      //  background.add(labelTemplateDescription, location.gbcLabelTemplateDescription);

        //Field 9 - field
      //  background.add(bI.bTabeleEksportoweStruktury, location.gbcTabeleEksportoweStruktury);
        //Field 10 - field
      //  background.add(bI.bTabeleImportoweStruktury, location.gbcTabeleImportoweStruktury);
        //Field 11 - field
       // background.add(bI.bTabeleImportoweReguly, location.gbcTabeleImportoweReguly);
        //Field 12 - field
       // background.add(bI.bPlikiOrin, location.gbcPlikiOrin);
        //Field 13 - field
      //  background.add(bI.bRFSFieldToField, location.gbcRFSFieldToField);
        //Field 14 - field
       // background.add(bI.bRFSSumyKontrolne, location.gbcRFSSumyKontrolne);
        //Field 15 - field
       // background.add(bI.bRFSWalidacjaBez, location.gbcRFSWalidacjaBez);
        //Field 16 - field
        //background.add(bI.bRFSWalidacjaZ, location.gbcRFSWalidacjaZ);

        //Field 17 - Generate button
        background.add(bI.bGenerate, location.gbcGenerate);







/*
        buttonWyczysc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fieldBatchFile.setText("");
                fieldDocName.setText("");
                fieldFinishDate.setText("");
                fieldShortNameTeam.setText("");
                fieldFileEndPath.setText("");


            }

        });
*/








        bI.bGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int  intIndexTempalte = templateList.getSelectedIndex();
                String sBatchFile = fieldBatchFile.getText();
                String sNameDoc = fieldDocName.getText();


                String sEndDate = fieldFinishDate.getText();
                String sShortName = fieldShortNameTeam.getText();
                String sEndFile = fieldFileEndPath.getText();


                switch (intIndexTempalte) {
                    case 0:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");
                        }
                        else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleEsksportoweAutomat tabeleEsksportoweAutomat = new TabeleEsksportoweAutomat(sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();

                        }

                        break;
                    case 1:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");
                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleImportoweStrukturyAutomat TabeleImportoweStrukturyAutomat = new TabeleImportoweStrukturyAutomat (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();
                        }
                        break;
                    case 2:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");

                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleImportoweRegulyAutomat tabeleImportoweRegulyAutomat = new TabeleImportoweRegulyAutomat (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();
                        }
                        break;
                    case 3:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");

                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleOrinRegulyAutomat tabeleOrinRegulyAutomat = new TabeleOrinRegulyAutomat (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();
                        }
                        break;
                    case 4:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");

                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleRFSFieldToFieldAutomat tabeleRFSFieldToFieldAutomat = new TabeleRFSFieldToFieldAutomat (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();
                        }
                        break;
                    case 5:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");

                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleRFSSumyKontrolneAutomat tabeleRFSSumyKontrolneAutomat = new TabeleRFSSumyKontrolneAutomat (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();
                        }
                        break;
                    case 6:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");

                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {
                            TabeleRFSWalidacjaBezRekOdrz tabeleRFSWalidacjaBezRekOdrz = new TabeleRFSWalidacjaBezRekOdrz (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();
                        }
                        break;
                    case 7:
                        if (sBatchFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Załącz poprawnie plik wsadowy!");
                        } else if (sNameDoc.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wpisz poprawnie nazwę dokumentu bazowego!");

                        } else if (sEndDate.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawną datę zakończenia testów!");
                        } else if (sShortName.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Podaj poprawny trzyliterowy skrót wertykala!");
                        } else if (sEndFile.length() == 0) {
                            JOptionPane.showMessageDialog(background, "Wskaż poprawny katalog zapisu pliku wynikowego!");
                        } else {

                            TabeleRFSWalidacjaZRekOdrz tabeleRFSWalidacjaZRekOdrz = new TabeleRFSWalidacjaZRekOdrz (sBatchFile, sShortName, sNameDoc, sEndDate, sEndFile);
                            JOptionPane.showMessageDialog(background, "SUCCESS - Generowanie pliku zakończone!");
                            repaint();

                        }
                }

            }

        });

        /**********************Menu******************/



        menuBar.setOpaque(true);
        setJMenuBar(menuBar);


        menuBar.setFont(style.fontMessageFiled);

        JMenu loginName = new JMenu("Zalogowany: " + login);
        JMenu fileMenu = new JMenu("Zarządzaj    ");
        JMenu menuBasic = new JMenu("Szablony podstawowe     ");
        JMenu menuAdvanced = new JMenu("Szablony rozszerzone    ");

        //fileMenu.setMenuLocation(100,50);

        menuBar.add(loginName);
        menuBar.add(fileMenu);
        menuBar.add(menuBasic);
        menuBar.add(menuAdvanced);

        JMenuItem aboutApplicationAction = new JMenuItem("O programie");
        JMenuItem logoutAction = new JMenuItem("Wyloguj");
        JMenuItem exitAction = new JMenuItem("Zakmnij");

        JMenuItem tabeleImportoweStrukturyAction = new JMenuItem("Tabele Importowe - Struktury");
        JMenuItem tabeleEksportoweStrukturyAction = new JMenuItem("Tabele Eksportowe - Struktury");
        JMenuItem plikiOrinRegulyAction = new JMenuItem("Pliki ORIN - Reguły");
        JMenuItem plkiRFSFieldToFieldAction = new JMenuItem("Pliki RFS - Field to Field");
        JMenuItem plkiRFSSumyKontBezAction = new JMenuItem("Pliki RFS - Sumy Kontrolne bez rek. odrz.");
        JMenuItem plkiRFSSumyKontrolneAction = new JMenuItem("Pliki RFS - Sumy Kontrolne");
        JMenuItem plkiRFSSumyKontZAction = new JMenuItem("Pliki RFS - Sumy Kontrolne z rek. odrz.");
        JMenuItem tabeleImportoweRegulyAction = new JMenuItem("Tabele Importowe - Reguły");

        fileMenu.add(aboutApplicationAction);
        fileMenu.add(logoutAction);
        fileMenu.add(exitAction);

        menuBasic.add(tabeleImportoweStrukturyAction);
        menuBasic.add(tabeleEksportoweStrukturyAction);
        menuBasic.add(plikiOrinRegulyAction);
        menuBasic.add(plkiRFSFieldToFieldAction);
        menuBasic.add(plkiRFSSumyKontBezAction);
        menuBasic.add(plkiRFSSumyKontrolneAction);
        menuBasic.add(plkiRFSSumyKontZAction);
        menuBasic.add(tabeleImportoweRegulyAction);


        //menuAdvanced.add(tabeleImportoweStrukturyAction);
        //menuAdvanced.add(plikiOrinRegulyAction);
        //menuAdvanced.add(pasteAction);




        fileMenu.setFont(style.fontMenuText);
        menuBasic.setFont(style.fontMenuText);
        menuAdvanced.setFont(style.fontMenuText);

        loginName.setFont(new Font ("Serif", Font.BOLD,16));

        loginName.setForeground(new Color(255, 39, 42));



        fileMenu.setForeground(style.colorMenuText);
        menuBasic.setForeground(style.colorMenuText);
        menuAdvanced.setForeground(style.colorMenuText);

        //fileMenu.setBorder(BorderFactory.createLineBorder(Color.black,1 ));
       // menuBasic.setBorder(BorderFactory.createLineBorder(Color.black,1 ));
        //menuAdvanced.setBorder(BorderFactory.createLineBorder(Color.black,1 ));

        Icon iconFlagPoland= new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\PolandFlag.png");
        JButton buttonFlagPoland = new JButton(iconFlagPoland);

        Icon iconFlagEngland= new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\GBFlag.png");
        JButton buttonFlagEngland = new JButton(iconFlagEngland);
        buttonFlagPoland.setBorder(BorderFactory.createEmptyBorder());
        buttonFlagPoland.setContentAreaFilled(false);

        buttonFlagEngland.setBorder(BorderFactory.createEmptyBorder());
        buttonFlagEngland.setContentAreaFilled(false);

        background.add(buttonFlagPoland,location.locationImageFlagPolandMainActivity);
        background.add(buttonFlagEngland,location.locationImageFlagEnglandMainActivity);


        /*****************MENU*********/



        logoutAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if (JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz sie wylogować?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                    try {
                        new LoginWindow();
                    } catch (FontFormatException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {

                }
            }
        });


        exitAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zamknąć aplikację?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                } else {

                }

            }
        });

        aboutApplicationAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                aboutProgram.setVisible(true);
            }
        });


        tabeleImportoweStrukturyAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tabImp.setVisible(true);
            }
        });

        tabeleEksportoweStrukturyAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tabEks.setVisible(true);
            }
        });

        plikiOrinRegulyAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plikiOrinReg.setVisible(true);
            }
        });


        plkiRFSFieldToFieldAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rfsFieldToField.setVisible(true);
            }
        });

        plkiRFSSumyKontBezAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rfsSumyKontBez.setVisible(true);
            }
        });

        plkiRFSSumyKontrolneAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rfsSumyKontrolne.setVisible(true);
            }
        });

        plkiRFSSumyKontZAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rfsSumyKontZ.setVisible(true);
            }
        });

        tabeleImportoweRegulyAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabImpReg.setVisible(true);
            }
        });
    }


}
