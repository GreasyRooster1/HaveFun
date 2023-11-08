package Core.Window;

import javax.swing.*;

public class TransparentForcedWindow extends TransparentWindow{
    public TransparentForcedWindow(int w,int h){
        super(w,h);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
    }
}
