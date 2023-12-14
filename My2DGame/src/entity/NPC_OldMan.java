package entity;

import java.util.Random;

import main.GamePanel;

public class NPC_OldMan  extends Entity{
    
    public NPC_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();
    }

    public void getImage(){
        
        up0 =setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile119", gp.tileSize, gp.tileSize);
        up1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile118", gp.tileSize, gp.tileSize);
        up2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile117", gp.tileSize, gp.tileSize);
        up3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile119", gp.tileSize, gp.tileSize);
        up4 =setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile118", gp.tileSize, gp.tileSize);

        down0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile074", gp.tileSize, gp.tileSize);
        down1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile073", gp.tileSize, gp.tileSize);
        down2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile072", gp.tileSize, gp.tileSize);
        down3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile074", gp.tileSize, gp.tileSize);
        down4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile073", gp.tileSize, gp.tileSize);
        
        left0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile087", gp.tileSize, gp.tileSize);
        left1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile088", gp.tileSize, gp.tileSize);
        left2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile089", gp.tileSize, gp.tileSize);
        left3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile087", gp.tileSize, gp.tileSize);
        left4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile088", gp.tileSize, gp.tileSize);

        right0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile104", gp.tileSize, gp.tileSize);
        right1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile103", gp.tileSize, gp.tileSize);
        right2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile102", gp.tileSize, gp.tileSize);
        right3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile104", gp.tileSize, gp.tileSize);
        right4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile102", gp.tileSize, gp.tileSize);
        
    }

    public void setDialogue() {

        dialogues[0] = " hello lad";
    }

    public void setAction() {

        actionLockCounter++;

        if(actionLockCounter == 100){

            Random random = new Random();
            int i  = random.nextInt(100)+1; //piccking a number from 1 to 100

            if(i <=25){
                direction = "up";
            }
            if(i > 25 && i <=50){
                direction = "down";
            }
            if(i > 50 && i<=75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }
}
