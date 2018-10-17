package projectApps;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image extends JPanel {

        private BufferedImage image;

        public Image(ImageIcon imageIcon) {
            try {
                image = ImageIO.read(getClass().getResource("/TabeleImportowe - geneor3.png"));
            } catch (IOException ex) {
                // handle exception...
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            //g.drawImage(image, -200, -300, this); // see javadoc for more info on the parameters
            setSize(550,400);

            setVisible(true);


        }

    }


