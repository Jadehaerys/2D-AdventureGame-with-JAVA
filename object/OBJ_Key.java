package object;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;

public class OBJ_Key extends SuperObject {
    public OBJ_Key() {
        name = "Key";
        try {
            InputStream is = getClass().getResourceAsStream("/objects/Key.png");
            if (is != null) {
                image = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/objects/Key.png");
                if (f.exists()) {
                    image = javax.imageio.ImageIO.read(f);
                } else {
                    System.err.println("Missing resource: /objects/Key.png");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
