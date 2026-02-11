package object;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest() {
        name = "Chest";
        try {
            InputStream is = getClass().getResourceAsStream("/objects/Chest.png");
            if (is != null) {
                image = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/objects/Chest.png");
                if (f.exists()) {
                    image = javax.imageio.ImageIO.read(f);
                } else {
                    System.err.println("Missing resource: /objects/Chest.png");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
