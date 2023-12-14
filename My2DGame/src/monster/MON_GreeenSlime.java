package monster;

import java.util.Random;

import entity.Entity;
import main.GamePanel;

public class MON_GreeenSlime  extends Entity{
    GamePanel gp;

    public MON_GreeenSlime(GamePanel gp){
        super(gp);
        this.gp = gp;
        type = type_monster;
        speed = 1;
        maxHealth = 4;
        life = maxHealth;
        direction = "down";
        
        attack = 1;
        defense = 0;
        exp = 2;

        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.height = 30;
        solidArea.width = 42;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {

        up0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile000", gp.tileSize, gp.tileSize);
        up1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile001", gp.tileSize, gp.tileSize);
        up2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile002", gp.tileSize, gp.tileSize);
        up3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile003", gp.tileSize, gp.tileSize);
        up4 = setup("/home/praneeth/sem3Projects/oop/My2DGamev/res/trial/tile004", gp.tileSize, gp.tileSize);

        left0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile000", gp.tileSize, gp.tileSize);
        left1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile001", gp.tileSize, gp.tileSize);
        left2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile002", gp.tileSize, gp.tileSize);
        left3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile003", gp.tileSize, gp.tileSize);
        left4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile004", gp.tileSize, gp.tileSize);
        left5 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile005", gp.tileSize, gp.tileSize);

        right0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile000", gp.tileSize, gp.tileSize);
        right1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile001", gp.tileSize, gp.tileSize);
        right2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile002", gp.tileSize, gp.tileSize);
        right3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile003", gp.tileSize, gp.tileSize);
        right4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile004", gp.tileSize, gp.tileSize);
        right5 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile005", gp.tileSize, gp.tileSize);
        
        down0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile000", gp.tileSize, gp.tileSize);
        down1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile001", gp.tileSize, gp.tileSize);
        down2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile002", gp.tileSize, gp.tileSize);
        down3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile003", gp.tileSize, gp.tileSize);
        down4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/trial/tile004", gp.tileSize, gp.tileSize); 

        
    }

    public void setAction() {

        actionLockCounter++;

        if(actionLockCounter == 100){

            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i<= 75){
                direction = "left";
            }
            if(i > 75 && i<= 100){
                direction = "right";
            }
            actionLockCounter = 0;
        }
    }

    public void damageReaction() {

        actionLockCounter = 0;
        direction = gp.player.direction;
    }
}
