package Core.Window;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TransparentWindow extends JFrame {
    public TransparentWindow(int w,int h) {
        super("Have Fun");
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        setSize(new Dimension(w,h));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        pack();
        setVisible(true);
        Runnable helloRunnable = new Runnable() {
            public void run() {
                repaint();
                revalidate();
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 10, TimeUnit.MILLISECONDS);
    }
}
