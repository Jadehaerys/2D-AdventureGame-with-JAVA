package object;

public class OBJ_Chest extends SuperObject {
    public OBJ_Chest() {
        name = "Chest";
        try {
            image = javax.imageio.ImageIO.read(getClass().getResourceAsStream("/objects/Chest.png"));
        } catch (Exception e) {
            e.printStackTrace();
    
}}
}