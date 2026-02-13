package object;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OBJ_Sword extends SuperObject {
    
    public OBJ_Sword() {
        name = "Sword";
        try {
            InputStream is = getClass().getResourceAsStream("/objects/sword_normal.png");
            if (is != null) {
                image = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/objects/sword_normal.png");
                if (f.exists()) {
                    image = javax.imageio.ImageIO.read(f);
                } else {
                    System.err.println("Missing resource: /objects/sword_normal.png");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
