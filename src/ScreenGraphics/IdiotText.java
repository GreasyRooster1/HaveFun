package ScreenGraphics;

import Core.Window.ForcedImageWindow;

import java.awt.*;

public class IdiotText extends ForcedImageWindow {
    public IdiotText() {
        super(500, 100);

        setupWithPath("src/resources/images/IdiotText1.png",500,100);
        Image icon = Toolkit.getDefaultToolkit().getImage("src/resources/images/SmileIconBlack.png");
        setIconImage(icon);
    }
}
