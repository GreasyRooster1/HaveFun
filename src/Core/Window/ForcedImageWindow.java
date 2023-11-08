package Core.Window;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ForcedImageWindow extends TransparentForcedWindow{
    JLabel image = new JLabel();
    public ForcedImageWindow(int w,int h) {
        super(w,h);
    }
    public void setupWithPath(String filePath,int w,int h){
        setImage(filePath,w,h);
        add(image);
    }
    public void setImage(String filePath,int w,int h){
        remove(image);
        String fullPath = new File(filePath).getAbsolutePath();
        Image initialImage = new ImageIcon(fullPath).getImage();
        Image img = initialImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
        setSize(new Dimension(w,h));
        image=new JLabel(new ImageIcon(img));
        add(image);
        repaint();
        revalidate();
    }
}
