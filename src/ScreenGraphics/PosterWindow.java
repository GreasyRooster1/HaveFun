package ScreenGraphics;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Core.Utils.Sound.setOutputVolume;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class PosterWindow extends JFrame {
    JLabel image=new JLabel();
    boolean white = true;
    float xvel=0;
    float yvel=0;
    public PosterWindow(){
        super("You are an idiot!");
        float dir = new Random().nextFloat(6.28f);
        xvel = (float) (cos(dir)*15);
        yvel = (float) (sin(dir)*15);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setImage("src/resources/images/PosterWhite.png");

        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(white) {
                    setImage("src/resources/images/PosterWhite.png");
                }else {
                    setImage("src/resources/images/PosterBlack.png");
                }
                white =!white;
                setOutputVolume(1f);
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0L, 300, TimeUnit.MILLISECONDS);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Runnable movement = new Runnable() {
            public void run() {
                Point p = getLocation();
                if(p.x+xvel>dim.width-700||p.x+xvel<0){
                    xvel*=-1;
                }
                if(p.y+yvel>dim.height-500||p.y+yvel<0){
                    yvel*=-1;
                }
                setLocation((int) (p.getX()+xvel), (int) (p.getY()+yvel));
            }
        };
        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
        executor1.scheduleAtFixedRate(movement, 0L, 16, TimeUnit.MILLISECONDS);
        setVisible(true);
    }

    public void setImage(String filePath) {
        remove(image);
        String fullPath = new File(filePath).getAbsolutePath();
        Image initialImage = new ImageIcon(fullPath).getImage();
        Image img = initialImage.getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        setSize(new Dimension(700, 500));
        image=new JLabel(new ImageIcon(img));
        add(image);
        repaint();
        revalidate();
    }
}
