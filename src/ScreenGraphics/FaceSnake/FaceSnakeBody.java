package ScreenGraphics.FaceSnake;

import Core.Window.ForcedImageWindow;

import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FaceSnakeBody extends ForcedImageWindow {
    boolean white = false;
    public FaceSnakeBody() {
        this(0);
    }
    public FaceSnakeBody(int delay) {
        super(50, 50);
        setupWithPath("src/resources/images/BlackSmileSmall.png",75,75);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/SmileIconBlack.png");
        setIconImage(icon);
        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(white) {
                    setImage("src/resources/images/BlackSmileSmall.png", 75, 75);
                }else {
                    setImage("src/resources/images/WhiteSmileSmall.png", 75, 75);
                }
                white =!white;
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0L, 300, TimeUnit.MILLISECONDS);

        Runnable dieRunnable = new Runnable() {
            public void run() {
                dispose();
            }
        };
        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
        executor1.schedule(dieRunnable, 1, TimeUnit.SECONDS);
    }
}
