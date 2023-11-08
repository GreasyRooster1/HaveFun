package ScreenGraphics;

import Core.Window.ForcedImageWindow;

import java.awt.*;

public class ReadyForFunText extends ForcedImageWindow {
    public ReadyForFunText() {
        super(500, 100);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-250,dim.height/2-100);
        setupWithPath("src/resources/images/ReadyForFunTextBlack.png",500,100);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/SmileIconBlack.png");
        setIconImage(icon);
    }
}
