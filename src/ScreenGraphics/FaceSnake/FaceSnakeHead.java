package ScreenGraphics.FaceSnake;

import Core.Window.ForcedImageWindow;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Core.Utils.ArrayUtils.append;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class FaceSnakeHead extends ForcedImageWindow {
    float xvel=0;
    float yvel=0;
    FaceSnakeBody[] body={};
    boolean alive = true;
    public FaceSnakeHead() {
        super(60, 60);
        float dir = new Random().nextFloat(6.28f);
        xvel = (float) (cos(dir)*10);
        yvel = (float) (sin(dir)*10);
        setupWithPath("src/resources/images/BlackSmileSmall.png",100,100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        Runnable movement = new Runnable() {
            public void run() {
                Point p = getLocation();
                if(!alive){return;}
                if(p.x+xvel>dim.width-60||p.x+xvel<0){
                    xvel*=-1;
                }
                if(p.y+yvel>dim.height-60||p.y+yvel<0){
                    yvel*=-1;
                }
                setLocation((int) (p.getX()+xvel), (int) (p.getY()+yvel));
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(movement, 0L, 16, TimeUnit.MILLISECONDS);
        Runnable bodyRun = new Runnable() {
            public void run() {
                if(!alive){return;}
                FaceSnakeBody b = new FaceSnakeBody();
                b.setLocation(getLocation());
                body = append(body,b);
            }
        };
        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(1);
        executor1.scheduleAtFixedRate(bodyRun, 0L, 200, TimeUnit.MILLISECONDS);
    }

    @Override
    public void dispose() {
        super.dispose();
        for(FaceSnakeBody b:body){
            b.dispose();
        }
        alive = false;
    }
}
