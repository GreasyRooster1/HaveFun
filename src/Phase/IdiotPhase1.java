package Phase;

import Core.Phase.Phase;
import ScreenGraphics.IdiotTextBuilder;
import ScreenGraphics.LargeFaces.LargeBlackFace;
import ScreenGraphics.LargeFaces.LargeWhiteFace;

import java.awt.*;

import static Core.Utils.ArrayUtils.append;

public class IdiotPhase1 extends Phase {
    IdiotTextBuilder[] idiotTextBuilders = {};
    LargeBlackFace largeBlackFace;
    LargeWhiteFace largeWhiteFace;
    @Override
    public void onStart() {
        super.onStart();
        setDuration(20_000);
        for (int i = 0; i < 10; i++) {
            idiotTextBuilders = append(idiotTextBuilders,new IdiotTextBuilder(i));
        }
        largeBlackFace = new LargeBlackFace();
        largeWhiteFace = new LargeWhiteFace();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        largeWhiteFace.setLocation(dim.width/5-250,dim.height/2-250);
        largeBlackFace.setLocation((dim.width/5)*4-250,dim.height/2-250);
    }

    @Override
    public void onEnd() {
        for (IdiotTextBuilder f:idiotTextBuilders) {
            f.cleanUp();
        }
        largeBlackFace.dispose();
        largeWhiteFace.dispose();
    }
}
