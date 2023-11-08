package ScreenGraphics;

import java.awt.*;

public class IdiotTextBuilder {
    IdiotText text;
    SmallFace smallFace1,smallFace2;
    public IdiotTextBuilder(int place){
        text = new IdiotText();
        smallFace1 = new SmallFace(place*50);
        smallFace2 = new SmallFace(place*50);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        text.setLocation(dim.width/2-250,(dim.height/10)*place);

        smallFace1.setLocation(dim.width/2-315,(dim.height/10)*place);
        smallFace2.setLocation(dim.width/2+275,(dim.height/10)*place);
    }
    public void cleanUp(){
        text.dispose();
        smallFace1.dispose();
        smallFace2.dispose();
    }
}
