package ScreenGraphics.LargeFaces;

import Core.Window.ForcedImageWindow;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LargeWhiteFace extends ForcedImageWindow {
    boolean white = true;
    public LargeWhiteFace() {
        super(500, 500);
        setupWithPath("src/resources/images/WhiteSmileLarge.png",500,500);
        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(white) {
                    setImage("src/resources/images/BlackSmileLarge.png", 500, 500);
                }else {
                    setImage("src/resources/images/WhiteSmileLarge.png", 500, 500);
                }
                white =!white;
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0L, 1500, TimeUnit.MILLISECONDS);
    }
}
