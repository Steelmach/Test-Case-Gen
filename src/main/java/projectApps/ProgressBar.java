package projectApps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar extends JFrame {

    JProgressBar progressBar;

    final static int interval= 1000;
    int i;
    Timer t;


    public  ProgressBar() {


        progressBar =  new JProgressBar(0,20);
        this.setSize(450,450);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setVisible(true);


        t = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (i == 20) {
                    t.stop();
                    progressBar.setEnabled(true);
                } else
                {
                    i++;
                    progressBar.setValue(1);
                }
            }

    });
        progressBar =  new JProgressBar(0,20);
        this.setSize(450,450);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setVisible(true);

    }


}







