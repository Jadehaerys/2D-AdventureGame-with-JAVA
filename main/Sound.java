package main;

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.net.URL;

public class Sound {

    Clip clip;
    String soundFile[] = {
        "JadeAdventure.wav",
        "coin.wav",
        "powerup.wav",
        "unlock.wav",
        "fanfare.wav",
        "hitmonster.wav"
    };

    public void setFile(int i) {
        try {
            AudioInputStream ais = getAudioInputStream(soundFile[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AudioInputStream getAudioInputStream(String fileName) throws Exception {
        URL url = getClass().getResource("/sound/" + fileName);
        if (url != null) {
            return AudioSystem.getAudioInputStream(url);
        }
        return AudioSystem.getAudioInputStream(new File("resources/sound/" + fileName));
    }
    public void play() {
        clip.start();
    }
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop() {
        clip.stop();
    }

}
