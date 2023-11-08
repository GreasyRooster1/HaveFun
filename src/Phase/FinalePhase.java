package Phase;

import Core.Phase.Phase;
import Core.Phase.PhaseManager;
import Core.Utils.Url;
import ScreenGraphics.FaceSnake.FaceSnakeHead;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static Core.Utils.ArrayUtils.append;
import static Core.Utils.Sound.playSound;
import static Core.Utils.Sound.setOutputVolume;

public class FinalePhase extends Phase {
    @Override
    public void onStart() {
        super.onStart();
        setDuration(20_000);
        setOutputVolume(1f);
        Runnable helloRunnable = new Runnable() {
            public void run() {
                Url.open("www.youtube.com/watch?v=hiRacdl02w4&t=61s");
                Url.open("https://www.youtube.com/watch?v=48rz8udZBmQ");
                playSound("src/resources/sounds/remix.wav");
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0L, 5_000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void onEnd() {
        ((PosterPhase)PhaseManager.phases[5]).clear();
        System.exit(23);
    }
}
