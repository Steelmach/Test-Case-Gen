package projectApps;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Tomasz on 23.06.2018.
 */
public class LoginWindow extends JFrame{

    Style style = new Style();
    Location location = new Location();
    CommonElements common = new CommonElements();
    //MainActivity mainActivity = new MainActivity();

    /************Elements*************/
    JLabel labelNameApplication = new JLabel("Test Case Generator");
    JLabel labelNameSubtitle = new JLabel("Logowanie");

    JLabel labelLogin = new JLabel("Login");
    JLabel labelPassword = new JLabel("Hasło");

    JTextField fieldLogin = new JTextField("Login");
    JPasswordField fieldPassword = new JPasswordField("Hasło");

    JButton buttonLogin = new JButton("Zaloguj");
    JButton buttonReset = new JButton("Wyczyść");

    JLabel labelMessageLoginFiled =  new JLabel("");



    Icon iconFlagPoland= new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\PolandFlag.png");
    JButton buttonFlagPoland = new JButton(iconFlagPoland);

    Icon iconFlagEngland= new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\GBFlag.png");
    JButton buttonFlagEngland = new JButton(iconFlagEngland);

    BufferedImage myPicture;
    public LoginWindow() throws FontFormatException, IOException {

        /******************Main settings**********************/
        super("Test Case Generator - Login Wiondow");
        setSize(1280, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\Tomasz\\Desktop\\TestCaseApplication\\src\\main\\resources\\background2.jpg"));
        add(background);
        background.setLayout(new GridBagLayout());


        /*****************Add elements****************/
        background.add(labelNameApplication,location.locationLabelNameApplication);
        background.add(labelNameSubtitle,location.locationLabelNameSubtitle);
        background.add(labelLogin,location.locationLabelLogin);
        background.add(labelPassword,location.locationLabelPassword);
        background.add(fieldLogin,location.locationFieldLogin);
        background.add(fieldPassword,location.locationFieldPassword);
        background.add(buttonLogin,location.locationButtonLogin);
        background.add(buttonReset,location.locationButtonReset);
        background.add(common.appVersion,location.locationAppVersion);
        background.add(common.copyRight, location.locationCopyRight);
        background.add(labelMessageLoginFiled,location.locationLabelMessageLoginFiled);

        background.add(buttonFlagPoland,location.locationImageFlagPoland);
        background.add(buttonFlagEngland,location.locationImageFlagEngland);









        /*******************Style****************/
        labelNameApplication.setFont(style.fontLabelNameApplication);
        labelNameApplication.setForeground(style.colorLabelNameApplication);

        labelNameSubtitle.setFont(style.fontLabelNameSubtitle);
        labelNameSubtitle.setForeground(style.colorLabelNameSubtitl);

        labelLogin.setFont(style.fontLabel);
        labelLogin.setForeground(style.colorLabel);

        labelPassword.setFont(style.fontLabel);
        labelPassword.setForeground(style.colorLabel);

        fieldLogin.setFont(style.fontTextField);
        fieldLogin.setColumns(style.columnSize);

        fieldPassword.setFont(style.fontTextField);
        fieldPassword.setColumns(style.columnSize);


        buttonLogin.setFont(style.fontTextButton);
        buttonLogin.setForeground(style.colorTextButton);
        buttonLogin.setPreferredSize(style.dimensionButton);

        buttonReset.setFont(style.fontTextButton);
        buttonReset.setForeground(style.colorTextButton);
        buttonReset.setPreferredSize(style.dimensionButton);

        common.appVersion.setForeground(style.colorCommonText);
        common.copyRight.setForeground(style.colorCommonText);
        common.appVersion.setFont(style.fontCommonText);
        common.copyRight.setFont(style.fontCommonText);

        labelMessageLoginFiled.setFont(style.fontMessageFiled);
        labelMessageLoginFiled.setForeground(style.colorMessageFiled);

        buttonFlagPoland.setBorder(BorderFactory.createEmptyBorder());
        buttonFlagPoland.setContentAreaFilled(false);

        buttonFlagEngland.setBorder(BorderFactory.createEmptyBorder());
        buttonFlagEngland.setContentAreaFilled(false);

        /********************Logic**************************/

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldLogin.setText("");
                fieldPassword.setText("");
            }
        });

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = fieldLogin.getText();
                String password = fieldPassword.getText();

                if ((login.equals("tester") && password.equals("tester123")) ||
                        login.equals("admin") && password.equals("admin123") ||
                        login.equals("guest") && password.equals("guest123")
                        ) {

                    dispose();
                    try {
                        new MainActivity(login);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (FontFormatException e1) {
                        e1.printStackTrace();
                    }
                }

                else if(login.length()==0 && password.length()==0) {
                    labelMessageLoginFiled.setText("Nie wprowdziłeś Loginu oraz Hasła!");
                    fieldLogin.setBackground(style.colorMessageFiled);
                    fieldPassword.setBackground(style.colorMessageFiled);
                }
                else if(login.length()==0){
                    labelMessageLoginFiled.setText("Pole Login jest puste!");
                    fieldLogin.setBackground(style.colorMessageFiled);
                    fieldPassword.setBackground(style.colorMessageFiled);
                }
                else if(password.length()==0){
                    labelMessageLoginFiled.setText("Pole Hasło jest puste!");
                    fieldLogin.setBackground(style.colorMessageFiled);
                    fieldPassword.setBackground(style.colorMessageFiled);
                }

                    else
                    {
                        labelMessageLoginFiled.setText("Login bądz hasło jest niepoprawne!");
                        fieldLogin.setBackground(style.colorMessageFiled);
                        fieldPassword.setBackground(style.colorMessageFiled);
                    }
                }

        });

            buttonFlagEngland.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonFlagEngland.setBorder(new LineBorder(Color.WHITE, 1));

                    Border emptyBorder = BorderFactory.createEmptyBorder();
                    buttonFlagPoland.setBorder(emptyBorder);

                    labelNameSubtitle.setText("Login");
                    labelLogin.setText("Login");
                    labelPassword.setText("Password");
                    buttonLogin.setText("Log in");
                    buttonReset.setText("Reset");
                }
            });

        buttonFlagPoland.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonFlagPoland.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

                Border emptyBorder = BorderFactory.createEmptyBorder();
                buttonFlagEngland.setBorder(emptyBorder);

                labelNameSubtitle.setText("Logowanie");
                labelLogin.setText("Login");
                labelPassword.setText("Hasło");
                buttonLogin.setText("Zaloguj");
                buttonReset.setText("Wyczyść");

            }
        });

    }



}
