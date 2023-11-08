package Phase;

import Core.Phase.Phase;
import ScreenGraphics.FlashFace;
import ScreenGraphics.ReadyForFunText;

import static Core.Utils.ArrayUtils.append;

public class FlashFacePhase extends Phase {
    FlashFace[] flashFaces = {};
    @Override
    public void onStart() {
        super.onStart();
        setDuration(10_000);
        for (int i = 0; i < 50; i++) {
            flashFaces = append(flashFaces,new FlashFace());
        }
    }

    @Override
    public void onEnd() {
        for (FlashFace f:flashFaces) {
            f.dispose();
        }
    }
}
