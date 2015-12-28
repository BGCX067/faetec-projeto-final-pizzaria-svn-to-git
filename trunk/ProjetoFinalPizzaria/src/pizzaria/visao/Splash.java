package pizzaria.visao;

import java.awt.Dimension;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Splash extends JWindow {

    AbsoluteLayout absoluto;
    AbsoluteConstraints absimagem, absbarra;
    ImageIcon imagem;
    JLabel label;
    JProgressBar barra;
    private int duration;

    public Splash(int d) {

        duration = d;
    }

    public void showSplash() {

        absoluto = new AbsoluteLayout();
        absimagem = new AbsoluteConstraints(0, 0);
        absbarra = new AbsoluteConstraints(0, 342);
        label = new JLabel();
        barra = new JProgressBar();
        barra.setPreferredSize(new Dimension(800, 15));
        this.getContentPane().setLayout(absoluto);

        final String logo = System.getProperty("user.dir");
        imagem = new ImageIcon(logo + "/src/pizzaria/icons/splash.png");
        label.setIcon(imagem);
        this.getContentPane().add(label, absimagem);
        this.getContentPane().add(barra, absbarra);
        new Thread() {

            public void run() {
               // startBanco();
                int i = 0;
                while (i < 101) {
                    barra.setValue(i);
                    i++;
                    try {
                        sleep(30);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        try {
            TimeUnit.SECONDS.sleep(3);
            dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 /*   public void startBanco() {
        final String dir = System.getProperty("user.dir");
        try {
            Runtime.getRuntime().exec("cmd /c start \"\" " + dir + "\\wampmanager");
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
