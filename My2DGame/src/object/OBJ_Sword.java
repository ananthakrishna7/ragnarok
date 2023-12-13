package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword extends Entity {
    
    public OBJ_Sword(GamePanel gp){
        super(gp);
        down1 = setup("/res/objects/sword_normal",gp.tileSize, gp.tileSize);
        attackValue = 1;
        
    }
}
