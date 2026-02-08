package Entity;

import main.GamePanel;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
public class player extends Entity  {

    GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2 - (gp.tileSize / 2));
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2 - (gp.tileSize / 2));

        setDefaultValues();
        getPlayerImage();
        solidArea = new Rectangle(8, 16, 32, 32);
        

    }

    

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
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
            is = getClass().getResourceAsStream("/player/sprite_jade3Left2.png");
            if (is != null) {
                left2 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade3Left2.png");
                if (f.exists()) left2 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade3Left2.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade2Right.png");
            if (is != null) {
                right1 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade2Right.png");
                if (f.exists()) right1 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade2Right.png");
            }
            is = getClass().getResourceAsStream("/player/sprite_jade2Right2.png");
            if (is != null) {
                right2 = javax.imageio.ImageIO.read(is);
            } else {
                File f = new File("resources/player/sprite_jade2Right2.png");
                if (f.exists()) right2 = javax.imageio.ImageIO.read(f); else System.err.println("Missing resource: /player/sprite_jade2Right2.png");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
            direction = "up";
            worldY -= speed;
        }
        if (keyH.downPressed == true) {
            direction = "down";
            worldY += speed;
        }
        if (keyH.leftPressed == true) {
            direction = "left";
            worldX -= speed;
        }
        if (keyH.rightPressed == true) {
            direction = "right";
            worldX += speed;
        }
        spriteCounter++;
        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
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
                if(spriteNum ==1){
                    image = down1;
                } if (spriteNum ==2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum ==1){
                    image = left1;
                } if (spriteNum ==2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum ==1){
                    image = right1;
                } if (spriteNum ==2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
    
    
}
