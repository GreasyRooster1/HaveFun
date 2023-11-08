package Phase;

import Core.Phase.Phase;
import ScreenGraphics.FaceSnake.FaceSnakeHead;
import ScreenGraphics.FlashFace;
import ScreenGraphics.LargeFaces.LargeBlackFace;
import ScreenGraphics.LargeFaces.LargeWhiteFace;

import java.awt.*;

import static Core.Utils.ArrayUtils.append;

public class SnakePhase extends Phase {
    FaceSnakeHead[] faceSnakeHeads = {};
    LargeBlackFace largeBlackFace;
    LargeWhiteFace largeWhiteFace;
    @Override
    public void onStart() {
        super.onStart();
        setDuration(12_000);
        for (int i = 0; i < 5; i++) {
            faceSnakeHeads = append(faceSnakeHeads,new FaceSnakeHead());
        }
        largeBlackFace = new LargeBlackFace();
        largeWhiteFace = new LargeWhiteFace();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        largeWhiteFace.setLocation(dim.width/5-250,dim.height/2-250);
        largeBlackFace.setLocation((dim.width/5)*4-250,dim.height/2-250);
    }

    @Override
    public void onEnd() {
        for (FaceSnakeHead f:faceSnakeHeads) {
            f.dispose();
        }
        largeBlackFace.dispose();
        largeWhiteFace.dispose();
    }
}
