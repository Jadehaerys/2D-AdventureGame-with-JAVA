package Entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.awt.image.BufferedImage;
public class player extends Entity  {

    GamePanel gp;
    KeyHandler keyH;

    public player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();


    }

    

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try{
            InputStream is;
            is = getClass().getResourceAsStream("/player/sprite_jade4Up.png");
            if (is != null) {
                up1 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade4Up.png");
                if (f.exists()) up1 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade4Up.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade4Up.png");
            if (is != null) {
                up2 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade4Up.png");
                if (f.exists()) up2 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade4Up.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jadeDown1.png");
            if (is != null) {
                down1 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jadeDown1.png");
                if (f.exists()) down1 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jadeDown1.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jadeDown2.png");
            if (is != null) {
                down2 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jadeDown2.png");
                if (f.exists()) down2 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jadeDown2.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade3Left.png");
            if (is != null) {
                left1 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade3Left.png");
                if (f.exists()) left1 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade3Left.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade3Left.png");
            if (is != null) {
                left2 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade3Left.png");
                if (f.exists()) left2 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade3Left.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade2Right.png");
            if (is != null) {
                right1 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade2Right.png");
                if (f.exists()) right1 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade2Right.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade2Right.png");
            if (is != null) {
                right2 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade2Right.png");
                if (f.exists()) right2 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade2Right.png");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed == true) {
            direction = "up";
            y -= speed;
        }
        if (keyH.downPressed == true) {
            direction = "down";
            y += speed;
        }
        if (keyH.leftPressed == true) {
            direction = "left";
            x -= speed;
        }
        if (keyH.rightPressed == true) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
       // g2.setColor(java.awt.Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;
        switch(direction) {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
    
    
}
