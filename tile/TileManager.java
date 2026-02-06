package tile;

import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/maps/map01.txt");
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
                File f = new File("resources/maps/map01.txt");
                br = new BufferedReader(new java.io.FileReader(f));
            }

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();
                while (col < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
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
        
       int col = 0;
       int row = 0;
       int x = 0;
       int y = 0;

       while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
           
           int tileNum = mapTileNum[col][row];
           g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
           col++;
           x += gp.tileSize;

           if(col == gp.maxScreenCol) {
               col = 0;
               x = 0;
               row++;
               y += gp.tileSize;
           }

        }
}}




