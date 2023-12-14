package object;

import java.io.File;
import java.io.IOException;
import entity.Entity;
import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Potion extends SuperObject {

    public static int value = 5;

     GamePanel gp;
    public OBJ_Potion(GamePanel gp) {
        name = "Potion";
        type = type_consumable;
        try {
            image = ImageIO.read(new File("/home/praneeth/sem3Projects/oop/My2DGame/res/objects/potion_red.png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            // Note: Scaling the image here might not be appropriate since gp is not initialized
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void setGamePanel(GamePanel gp) {
        this.gp = gp;
        // Scale the image after setting the GamePanel instance
        if (gp != null) {
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }
    }

    public void use(Entity entity){

        entity.life += value;
        if(gp.player.life > gp.player.maxHealth){
            gp.player.life = gp.player.maxHealth;
        }
    }
}
