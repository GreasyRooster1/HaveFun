package Phase;

import Core.Phase.Phase;
import Core.Utils.Sound;
import ScreenGraphics.SmallFace;

public class SmallFacePhase extends Phase {
    SmallFace smallFace;
    @Override
    public void onStart() {
        super.onStart();
        setDuration(14_000);
        Sound.playSound("src/resources/sounds/remix.wav");
        smallFace = new SmallFace();
    }

    @Override
    public void onEnd() {
        smallFace.dispose();
    }
}
