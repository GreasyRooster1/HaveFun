package Phase;

import Core.Phase.Phase;
import ScreenGraphics.ReadyForFunText;
import ScreenGraphics.SmallFace;

import static Core.Utils.Sound.setOutputVolume;

public class IntroPhase extends Phase {
    ReadyForFunText readyForFunText;
    @Override
    public void onStart() {
        super.onStart();
        setDuration(15_000);
        readyForFunText = new ReadyForFunText();
        setOutputVolume(0.3f);
    }

    @Override
    public void onEnd() {
        readyForFunText.dispose();
    }
}
