package main;
import Entity.Entity;
public class CollisionChecker {
    GamePanel gp;


    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    public void checkTile(Entity entity) {
        entity.collisionOn = false;
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int tileLeftCol = entityLeftWorldX / gp.tileSize;
        int tileRightCol = entityRightWorldX / gp.tileSize;
        int tileTopRow = entityTopWorldY / gp.tileSize;
        int tileBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                
                tileNum1 = gp.tileM.mapTileNum[tileLeftCol][tileTopRow];
                tileNum2 = gp.tileM.mapTileNum[tileRightCol][tileTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                tileNum1 = gp.tileM.mapTileNum[tileLeftCol][tileBottomRow];
                tileNum2 = gp.tileM.mapTileNum[tileRightCol][tileBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                tileNum1 = gp.tileM.mapTileNum[tileLeftCol][tileTopRow];
                tileNum2 = gp.tileM.mapTileNum[tileLeftCol][tileBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                tileNum1 = gp.tileM.mapTileNum[tileRightCol][tileTopRow];
                tileNum2 = gp.tileM.mapTileNum[tileRightCol][tileBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
}}}
