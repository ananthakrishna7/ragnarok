package object;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Key extends SuperObject {
     GamePanel gp;
    public OBJ_Key() {
        name = "Key";
        
        try {
            image = ImageIO.read(new File("/home/praneeth/sem3Projects/oop/My2DGame/res/objects/key.png"));
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
}
