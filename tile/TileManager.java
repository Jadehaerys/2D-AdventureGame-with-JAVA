package tile;

import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/maps/world02.txt");
    }

    private BufferedImage load(String resourcePath, String fallbackPath) throws Exception {
        java.io.InputStream is = getClass().getResourceAsStream(resourcePath);
        if (is != null) return javax.imageio.ImageIO.read(is);
        return javax.imageio.ImageIO.read(new File(fallbackPath));
    }

    public void getTileImage() {
       try{
           Tile tile0 = new Tile();
            tile0.image = load("/tiles/grass.png", "resources/tiles/grass.png");
            tile[0] = tile0;
            Tile tile1 = new Tile();
            tile1.image = load("/tiles/wall.png", "resources/tiles/wall.png");
            tile1.collision = true;
            tile[1] = tile1;
            Tile tile2 = new Tile();
            tile2.image = load("/tiles/water.png", "resources/tiles/water.png");
            tile2.collision = true;
            tile[2] = tile2;
            Tile tile3 = new Tile();
            tile3.image = load("/tiles/earth.png", "resources/tiles/earth.png");
            tile[3] = tile3;
            Tile tile4 = new Tile();
            tile4.image = load("/tiles/tree.png", "resources/tiles/tree.png");
            tile4.collision = true;
            tile[4] = tile4;
            Tile tile5 = new Tile();
            tile5.image = load("/tiles/sand.png", "resources/tiles/sand.png");
            tile[5] = tile5;
            Tile tile6 = new Tile();
            tile6.image = load("/tiles/bridge.png", "resources/tiles/pondBottom.png");
            tile[6] = tile6;
            Tile tile7 = new Tile();
            tile7.image = load("/tiles/road.png", "resources/tiles/pondTopM.png");
            tile[7] = tile7;

            
       }catch(Exception e) {
           e.printStackTrace();
       }
    }

    public void loadMap(String filePath) {
        try {
            
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br;
            if (is != null) {
                br = new BufferedReader(new java.io.InputStreamReader(is));
            } else {
                String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
                File f = new File("resources/maps/" + fileName);
                br = new BufferedReader(new java.io.FileReader(f));
            }

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        
       int worldCol = 0;
       int worldRow = 0;

         while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
              int tileNum = mapTileNum[worldCol][worldRow];
              int worldX = worldCol * gp.tileSize;
              int worldY = worldRow * gp.tileSize;
              int screenX = worldX - gp.player.worldX + gp.player.screenX;
              int screenY = worldY - gp.player.worldY + gp.player.screenY;
    
                if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                 worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&     
                 worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                 worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                     g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                 }
              worldCol++;
    
              if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
              }
         


        }
}}




