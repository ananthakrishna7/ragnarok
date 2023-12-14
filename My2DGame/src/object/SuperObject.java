package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.UtilityTool;

public class SuperObject {
     GamePanel gp;    
   public BufferedImage image, image2, image3;
   public String name;
   public boolean collision = false;
   public int worldX , worldY;
   public Rectangle solidArea = new Rectangle(0,0,48,48);
   public int solidAreaDefaultX = 0; 
   public int solidAreaDefaultY = 0;

   public int type ;
   public final int type_player =0;
   public final int type_npc = 1;
   public final int type_monster = 2;
   public final int type_consumable = 3;
   public final int type_obstacle  =4;

   UtilityTool uTool = new UtilityTool();

   public void draw(Graphics2D g2, GamePanel gp) {
  
      int screenX = worldX - gp.player.worldX + gp.player.screenX;
      int screenY = worldY - gp.player.worldY + gp.player.screenY;
      
      // STOP MOVING CAMERA
      if(gp.player.worldX < gp.player.screenX) {
       screenX = worldX;
      }
      if(gp.player.worldY < gp.player.screenY) {
       screenY = worldY;
      }   
      int rightOffset = gp.screenWidth - gp.player.screenX;      
      if(rightOffset > gp.worldWidth - gp.player.worldX) {
       screenX = gp.screenWidth - (gp.worldWidth - worldX);
      } 
      int bottomOffset = gp.screenHeight - gp.player.screenY;
      if(bottomOffset > gp.worldHeight - gp.player.worldY) {
       screenY = gp.screenHeight - (gp.worldHeight - worldY);
      }
      
      if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
         worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
         worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
         worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
       
       g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
      }
      // If player is around the edge, draw everything
      else if(gp.player.worldX < gp.player.screenX ||
        gp.player.worldY < gp.player.screenY ||
        rightOffset > gp.worldWidth - gp.player.worldX ||
        bottomOffset > gp.worldHeight - gp.player.worldY) {
       g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); 
      }  
    }
    

    public void interact() {

        
        String text ;
        text = "You need a key to open this.";
        gp.ui.showMessage(text);
    
    }
    
}