package object;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class OBJ_Boots extends SuperObject {

     public OBJ_Boots() {
        name = "Boots";
        try {
            InputStream is = getClass().getResourceAsStream("/objects/boots.png");
            if (is != null) {
                image = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/objects/boots.png");
                if (f.exists()) {
                    image = javax.imageio.ImageIO.read(f);
                } else {
                    System.err.println("Missing resource: /objects/boots.png");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
