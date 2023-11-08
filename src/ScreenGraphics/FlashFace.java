package ScreenGraphics;

import Core.Window.ForcedImageWindow;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FlashFace extends ForcedImageWindow {
    boolean white = false;
    public FlashFace() {
        super(50, 50);
        Random random = new Random();
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/SmileIconBlack.png");
        if(random.nextInt(2)==1){
            white = true;
            icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/SmileIconWhite.png");
        }
        setupWithPath("src/resources/images/BlackSmileSmall.png",50,50);
        setIconImage(icon);
        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(white) {
                    setImage("src/resources/images/BlackSmileSmall.png", 50, 50);
                }else {
                    setImage("src/resources/images/WhiteSmileSmall.png", 50, 50);
                }
                white =!white;
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0L, 150, TimeUnit.MILLISECONDS);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(random.nextInt(dim.width), random.nextInt(dim.width));
    }
}
