package object;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;

public class OBJ_Door extends SuperObject {
    public OBJ_Door() {
        name = "Door";
        try {
            InputStream is = getClass().getResourceAsStream("/objects/door.png");
            if (is != null) {
                image = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/objects/door.png");
                if (f.exists()) {
                    image = javax.imageio.ImageIO.read(f);
                } else {
                    System.err.println("Missing resource: /objects/door.png");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}