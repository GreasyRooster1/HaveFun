package Phase;

import Core.Phase.Phase;
import ScreenGraphics.FaceSnake.FaceSnakeHead;
import ScreenGraphics.PosterWindow;

import static Core.Utils.ArrayUtils.append;

public class PosterPhase extends Phase {
    PosterWindow[] posterWindows = {};
    @Override
    public void onStart() {
        super.onStart();
        setDuration(12_000);
        for (int i = 0; i < 15; i++) {
            posterWindows = append(posterWindows,new PosterWindow());
        }
    }

    @Override
    public void onEnd() {
//        for (PosterWindow f:posterWindows) {
//            f.dispose();
//        }
    }
    public void clear() {
        for (PosterWindow f:posterWindows) {
            f.dispose();
        }
    }
}
