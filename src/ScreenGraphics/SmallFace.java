package ScreenGraphics;

import Core.Window.ForcedImageWindow;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SmallFace extends ForcedImageWindow {
    boolean white = false;
    public SmallFace() {
        this(0);
    }
    public SmallFace(int delay) {
        super(50, 50);
        setupWithPath("src/resources/images/BlackSmileSmall.png",50,50);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/SmileIconBlack.png");
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
        executor.scheduleAtFixedRate(helloRunnable, 0L, 300, TimeUnit.MILLISECONDS);
    }
}
