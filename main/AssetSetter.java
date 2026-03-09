package main;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new object.OBJ_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        gp.obj[1] = new object.OBJ_Key();
        gp.obj[1].worldX = 23 * gp.tileSize;
        gp.obj[1].worldY = 40 * gp.tileSize;

        gp.obj[2] = new object.OBJ_Chest();
        gp.obj[2].worldX = 10 * gp.tileSize;
        gp.obj[2].worldY = 9 * gp.tileSize;
        
        gp.obj[3] = new object.OBJ_Sword();
        gp.obj[3].worldX = 23 * gp.tileSize;
        gp.obj[3].worldY = 23 * gp.tileSize;

        gp.obj[4] = new object.OBJ_Door();
        gp.obj[4].worldX = 10 * gp.tileSize;
        gp.obj[4].worldY = 11 * gp.tileSize;

        gp.obj[5] = new object.OBJ_Boots();
        gp.obj[5].worldX = 12 * gp.tileSize;
        gp.obj[5].worldY = 7 * gp.tileSize;
    }
}
