package entity;

import main.KeyHandler;
import main.UtilityTool;
import object.OBJ_Sword;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Player extends Entity {

    UtilityTool uTool = new UtilityTool();
    
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH){

        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 6;
        solidArea.y = 14;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;

        attackArea.width = 36;
        attackArea.height = 36; 

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
    }

    public void setDefaultValues() {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 2;
        direction = "down";
        //player status
        level = 1;
        strength = 1;
        dexterity = 1;
        defense = getDefense();
        exp = 0;
        nextLevelExp = 6;
        coin = 0;
        currentWeapon = new OBJ_Sword(gp);
        attack = getAttack();
        maxHealth = 6;
        life = maxHealth;
    }

    public int getAttack() {
        return attack = strength * currentWeapon.attackValue;
    }

    public int getDefense() {
        return defense = strength * dexterity;
    }

    public void getPlayerImage() {
 

        up0 =setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile053", gp.tileSize, gp.tileSize);
        up1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile052", gp.tileSize, gp.tileSize);
        up2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile051", gp.tileSize, gp.tileSize);
        up3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile053", gp.tileSize, gp.tileSize);
        up4 =setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile052", gp.tileSize, gp.tileSize);

        down0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile008", gp.tileSize, gp.tileSize);
        down1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile007", gp.tileSize, gp.tileSize);
        down2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile006", gp.tileSize, gp.tileSize);
        down3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile008", gp.tileSize, gp.tileSize);
        down4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile007", gp.tileSize, gp.tileSize);
        
        left0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile021", gp.tileSize, gp.tileSize);
        left1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile022", gp.tileSize, gp.tileSize);
        left2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile023", gp.tileSize, gp.tileSize);
        left3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile021", gp.tileSize, gp.tileSize);
        left4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile022", gp.tileSize, gp.tileSize);

        right0 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile038", gp.tileSize, gp.tileSize);
        right1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile037", gp.tileSize, gp.tileSize);
        right2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile036", gp.tileSize, gp.tileSize);
        right3 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile038", gp.tileSize, gp.tileSize);
        right4 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/nes/tile037", gp.tileSize, gp.tileSize);
            
        
        
    }

    public void getPlayerAttackImage() {

        int attackSize = gp.tileSize * 2;

        attackUp1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_up_1", gp.tileSize, attackSize);
        attackUp2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_up_2",  gp.tileSize, attackSize);

        attackLeft1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_left_1", attackSize, gp.tileSize);
        attackLeft2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_left_2", attackSize, gp.tileSize);

        attackRight1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_right_1", attackSize, gp.tileSize);
        attackRight2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_right_2", attackSize, gp.tileSize);

        attackDown1 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_down_1", gp.tileSize, attackSize);
        attackDown2 = setup("/home/praneeth/sem3Projects/oop/My2DGame/res/blue-boy/boy_attack_down_2", gp.tileSize, attackSize);
        
    }
    
    public void update(){

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed == true  || keyH.JPressed == true){

            if(keyH.upPressed == true){
                direction = "up";
            }
            if(keyH.downPressed == true){
                direction = "down";
            }
            if(keyH.leftPressed == true){
                direction = "left";
            }
            if(keyH.rightPressed == true){
                direction = "right";
            }


            if(keyH.JPressed == true){
                attacking = true;
                performAttack();
            }else if(keyH.JPressed == false){
                attacking = false;
            }

            //check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            //check object collision
            int objIndex = gp.cChecker.checkObject(this, true);
            pickupObject(objIndex);

            //check npc collision

            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);


            //check monster collision
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            contactMonster(monsterIndex);


            //if collision is false, player can moce 

            if(collisionOn == false && attacking == false){

                switch(direction){
                    case "up":
                        worldY = worldY - speed;
                        break;

                    case "down":
                        worldY = worldY + speed;
                        break;

                    case "right":
                        worldX = worldX + speed;
                        break;

                    case "left":
                        worldX = worldX - speed;
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter > 16){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 3;
                }
                else if(spriteNum == 3){
                    spriteNum = 4;
                }
                else if(spriteNum == 4){
                    spriteNum = 5;
                }
                else if (spriteNum == 5){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }

    }

    public void performAttack() {

        spriteCounter++;

        if(spriteCounter <= 5){
            spriteNum = 1;
        }
        if(spriteCounter > 5 && spriteCounter <= 25){
            spriteNum = 2;

            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //adjust player's worldx/worldy for attackarea

            switch(direction){
                case "up" : worldY -= attackArea.height ; break;
                case "down": worldY += attackArea.height; break;
                case "left" : worldX -= attackArea.width; break;
                case "right" : worldX += attackArea.width; break;
            }

            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;

            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            damageMonster(monsterIndex);

            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;




        }
        if(spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking = false;
        }

    }

    public void pickupObject(int i){

        if (i != 999){
            String objectName = gp.obj[i].name;

            switch(objectName){
                case "Key":
                    hasKey ++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Key acquired!");
                    break;
                case "Door":
                    if(hasKey > 0){
                        gp.obj[i] = null;
                        hasKey -- ;
                        gp.ui.showMessage("Door unlocked, lost the key in the process !!");
                    }else{
                        gp.ui.showMessage("You need a key to open this door!!");
                    }
                    System.out.println("Key: " + hasKey);
                    break;
                case "Boot":
                    speed = speed+ 1;
                    gp.obj[i] =null;
                    gp.ui.showMessage("Speed increased !!");
                    break;
                case "Chest":
                    gp.ui.gameFinished = true;
                    break;
            }

        }
    }

    public void interactNPC(int i ){
        if(i != 999){
            System.out.println("u are hitting an npc");
        }
    }

    public void contactMonster(int i ){
        if(i != 999){

            if(invincible == false){
                life = life - 1;
                invincible = true;
            }
        }
    }

    public void damageMonster(int i ){
        if(i != 999){
            if (gp.monster[i].invincible == false){
                gp.monster[i].life -= 1;
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();

                if(gp.monster[i].life <= 0){
                    gp.monster[i].dying = true;
                }
            }
        }
    }
    
    public void draw(Graphics2D g2){

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        switch(direction){
            case "up":
                if(attacking == false){
                    if(spriteNum == 1){
                    image = up0;
                    }
                    if(spriteNum == 2){
                        image = up1;
                    }
                    if(spriteNum == 3){
                        image = up2;
                    }
                    if(spriteNum == 4){
                        image = up3;
                    }
                    if(spriteNum == 5){
                        image = up4;
                    }   
                     
                }
                if(attacking == true){
                    tempScreenY = screenY - gp.tileSize;
                    if(spriteNum == 1){
                        image = attackUp1;
                    }
                    if(spriteNum == 2){
                        image = attackUp2;
                    }
                    if(spriteNum == 3){
                        image = attackUp1;
                    }
                    if(spriteNum == 4){
                        image = attackUp2;
                    }
                    if(spriteNum == 5){
                        image = attackUp1;
                    }
                }
                
                break;
            case "down":
                if(attacking == false){
                    if(spriteNum == 1){
                    image = down0;
                    }
                    if(spriteNum == 2){
                        image = down1;
                    }
                    if(spriteNum == 3){
                        image = down2;
                    }
                    if(spriteNum == 4){
                        image = down3;
                    }
                    if(spriteNum == 5){
                        image = down4;
                    }    
                }
                if(attacking == true){
                    if(spriteNum == 1){
                        image = attackDown1;
                    }
                    if(spriteNum == 2){
                        image = attackDown2;
                    }
                    if(spriteNum == 3){
                        image = attackDown1;
                    }
                    if(spriteNum == 4){
                        image = attackDown2;
                    }
                    if(spriteNum == 5){
                        image = attackDown1;
                    }
                }
                
                break;
            case "right":
                if(attacking == false){
                    if(spriteNum == 1){
                    image = right0;
                    }
                    if(spriteNum == 2){
                        image = right1;
                    }
                    if(spriteNum == 3){
                        image = right2;
                    }
                    if(spriteNum == 4){
                        image = right3;
                    }
                    if(spriteNum == 5){
                        image = right4;
                    }    
                }
                if(attacking == true){
                    if(spriteNum == 1){
                        image = attackRight1;
                    }
                    if(spriteNum == 2){
                        image = attackRight2;
                    }
                    if(spriteNum == 3){
                        image = attackRight1;
                    }
                    if(spriteNum == 4){
                        image = attackRight2;
                    }
                    if(spriteNum == 5){
                        image = attackRight1;
                    }
                }
                
                break;
            case "left":
                if(attacking == false){
                    if(spriteNum == 1){
                    image = left0;
                    }
                    if(spriteNum == 2){
                        image = left1;
                    }
                    if(spriteNum == 3){
                        image = left2;
                    }
                    if(spriteNum == 4){
                        image = left3;
                    }
                    if(spriteNum == 5){
                        image = left4;
                    }    
                }
                if(attacking == true){
                    tempScreenX = screenX - gp.tileSize;
                    
                    if(spriteNum == 1){
                        image = attackLeft1;
                    }
                    if(spriteNum == 2){
                        image = attackLeft2;
                    }
                    if(spriteNum == 3){
                        image = attackLeft1;
                    }
                    if(spriteNum == 4){
                        image = attackLeft2;
                    }
                    if(spriteNum == 5){
                        image = attackLeft1;
                    }
                }
                
                break;
            }

            

            if(invincible == true){

                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            }

            g2.drawImage(image,tempScreenX, tempScreenY , null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}
