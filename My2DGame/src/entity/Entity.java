package entity;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {
    
   GamePanel gp;
   public int getLeftX() {
    return worldX + solidArea.x;
   }
   public int getRightX() {
    return worldX + solidArea.x + solidArea.width;
   }
   public int getTopY(){
    return worldY + solidArea.y;
   }

   public int getBottomY() {
    return worldY + solidArea.y + solidArea.height;
   }
   public int getCol() {
    return (worldX + solidArea.x)/gp.tileSize;
   }
   public int getRow() {
    return (worldY + solidArea.y)/gp.tileSize;
   }

   public int worldX, worldY ;
   public int speed;
   public BufferedImage up0, up1, up2, up3, up4, down1, down0, down2, down3, down4, left0, left1, left2, left3, left4 , left5, right5, right0, right1, right2, right3, right4;
   public BufferedImage attackUp1, attackUp2, attackDown1, attackDown2, attackLeft1, attackLeft2, attackRight1, attackRight2;
   public String direction = "down";
   public int spriteCounter = 0;
   public int spriteNum = 1;
   public Rectangle solidArea = new Rectangle(0,0,48,48);
   public Rectangle attackArea = new Rectangle(0,0,0,0);
   public int solidAreaDefaultX, solidAreaDefaultY;


   public boolean collisionOn = false; 
   public int actionLockCounter = 0;
   public boolean invincible = false;
   public int invincibleCounter = 0;
   int dyingCounter = 0;
   String dialogues[] = new String[20];

   public BufferedImage image, image2, image3;
   public String name;
   public boolean collision = false;

   boolean attacking  = false;
   public boolean alive = true;
   public boolean dying = false;


    //character status
    public int maxHealth;
    public int life;    
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public Entity currentWeapon;

    //item attributes
    public int attackValue ;
    
    //types
    public int type ;
    public final int type_player =0;
    public final int type_npc = 1;
    public final int type_monster = 2;
    public final int type_consumable = 3;
    public final int type_obstacle = 4;

   public Entity(GamePanel gp){
      this.gp = gp;
   }

   public void setAction() {}
   public void damageReaction () {}

   public void interact() {}
   public void use(Entity entity) {}
   public void update() {

        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        gp.cChecker.checkObject(this, false);
        gp.cChecker.checkEntity(this, gp.npc);
        gp.cChecker.checkEntity(this, gp.monster);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(this.type == type_monster && contactPlayer == true){

            if(gp.player.invincible == false){

                int damage = attack - gp.player.defense;

                if(damage < 0){
                    damage = 0;
                }

                gp.player.life -= damage;
                gp.player.invincible = true;
            }
        }

        if(collisionOn == false){

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
        if(spriteCounter > 15){
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

        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 40){
                invincible = false;
                invincibleCounter =0 ;
            }
        }

   }

   public void draw(Graphics2D g2){

      BufferedImage image = null;

      int screenX = worldX - gp.player.worldX + gp.player.screenX;
      int screenY = worldY - gp.player.worldY + gp.player.screenY;

      if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
      worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
      worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
      worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

         switch(direction){
            case "up":
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
                break;
            case "down":
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
                break;
            case "right":
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
                break;
            case "left":
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
                break;
            }

            if (invincible == true){
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            }

            if(dying == true){
                dyingAnimation(g2);
            }
    
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

      }  
    }

    public void dyingAnimation(Graphics2D g2) {

        dyingCounter++;

        int frames_dying = 5;

        if(dyingCounter <= frames_dying){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter > frames_dying && dyingCounter <= frames_dying*2){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter > frames_dying*2 && dyingCounter <= frames_dying*3){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter > frames_dying*3 && dyingCounter <= frames_dying*4){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter > frames_dying*4 && dyingCounter <= frames_dying*5){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter > frames_dying*5 && dyingCounter <= frames_dying*6){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter > frames_dying*6 && dyingCounter <= frames_dying*7){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0f));
        }
        if(dyingCounter > frames_dying*7 && dyingCounter <= frames_dying*8){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        if(dyingCounter > frames_dying*8){
            dying = false;
            alive = false;
        }
    }

   public BufferedImage setup(String imageName, int width, int height){

      UtilityTool uTool = new UtilityTool();
      BufferedImage image = null;

      try {
         image = ImageIO.read(new File(imageName+".png"));
         image = uTool.scaleImage(image, width, height);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return image;

   }

}







