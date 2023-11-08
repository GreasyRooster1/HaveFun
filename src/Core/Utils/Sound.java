package Core.Utils;

import com.sun.tools.javac.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sound {
    public static synchronized void playSound(String filePath) {
        try {
            Clip clip;
            AudioInputStream audioInputStream;
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);
            clip.start();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void setOutputVolume(float value)
    {
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("cmd.exe setsysvolume 32767.5");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
