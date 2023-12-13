package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import object.OBJ_Heart;
import object.OBJ_Key;
import object.SuperObject;

public class UI {
    
    GamePanel gp;
    Graphics2D g2;
    Font arial_30, arial_80B, arial20;
    BufferedImage key_image;
    BufferedImage heart_full , heart_half, heart_blank;
    public boolean messageOn = false;
    public String message = " ";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = " ";
    
    public UI(GamePanel gp){
        this.gp = gp;

        arial20 = new Font("Arial", Font.PLAIN, 10);
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        OBJ_Key key = new OBJ_Key();
        key_image = key.image;

        //create HUD object

        SuperObject heart = new OBJ_Heart(gp);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
    }

    public void showMessage(String text){

        message = text ; 
        messageOn = true;
    }
    public void draw(Graphics2D g2){

    //     if(gameFinished == true){

    //         g2.setFont(arial_30);
    //         g2.setColor(Color.white);
    //         String text;
    //         int textLength;
    //         int x;
    //         int y;
    //         text = "You fount the treasure!!";
    //         textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    //         x = gp.screenWidth/2 - textLength/2;
    //         y  = gp.screenHeight/2 - (gp.tileSize * 3);
    //         g2.drawString(text, x, y);

    //         g2.setFont(arial_80B);
    //         g2.setColor(Color.yellow);
    //         text = "Congrats!!";
    //         textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
    //         x = gp.screenWidth/2 - textLength/2;
    //         y  = gp.screenHeight/2 + (gp.tileSize * 2);
    //         g2.drawString(text, x, y);

    //         gp.gameThread = null;

    //     }else{
    //     g2.setFont(arial_30);
    //     g2.setColor(Color.white);
    //     g2.drawImage(key_image, gp.tileSize/2 , gp.tileSize/2, gp.tileSize, gp.tileSize, null);
    //     g2.drawString("x "+ gp.player.hasKey, 74, 65);

    //     //message

    //     if(messageOn == true){

    //         g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
    //         messageCounter ++;

    //         if(messageCounter > 120){
    //             messageCounter = 0;
    //             messageOn = false;
    //         }
    //     }
    //     }
    // }

        this.g2 = g2;
        g2.setFont(arial_30);
        g2.setColor(Color.white);

        if(gp.gameState == gp.playState){
            //Do playstate stuff later
            drawPlayerLife();
        }

        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }

        if (gameFinished) {
            gp.gameThread = null;
            drawGameoverScreen();
        }

        //character status screen
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
        }

    }




    public void drawPlayerLife() {

        int x = gp.tileSize/2;
        int y = gp.tileSize/2;
        int i = 0;

        //draw max life
        while(i < gp.player.maxHealth/2){
            g2.drawImage(heart_blank, x, y,null);
            i++;
            x+= gp.tileSize;
        }
        
        //reset

        x = gp.tileSize/2;
        y = gp.tileSize/2;
        i = 0;

        while(i < gp.player.life){
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i < gp.player.life){
                g2.drawImage(heart_full, x,y,null);
            }
            i++;
            x += gp.tileSize;
        }

    }
    public void drawPauseScreen() {

        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text,x,y);
    }

    public void drawCharacterScreen() {
        
        //create a frama
        final int frameX = gp.tileSize *2;
        final int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize * 7;
        final int frameHeight = gp.tileSize * 10;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //displaying the text in the status screen

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        
        int textX = frameX + 20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 45;

        //names
        g2.drawString("Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Life" , textX, textY);
        textY += lineHeight;
        g2.drawString("Strength", textX, textY);
        textY += lineHeight;
        g2.drawString("Dexterity" , textX, textY);
        textY += lineHeight;
        g2.drawString("Attack", textX, textY);
        textY += lineHeight;
        g2.drawString("Defense" , textX, textY);
        textY += lineHeight;
        g2.drawString("Exp", textX, textY);
        textY += lineHeight;
        g2.drawString("Next Level" , textX, textY);
        textY += lineHeight;
        g2.drawString("Coin", textX, textY);
        textY += lineHeight;

        //padding values
        int tailX = (frameX + frameWidth) - 30;
        // reset textY
        textY = frameY + gp.tileSize;
        String value;
        
        value  = String.valueOf(gp.player.level);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);
        
        textY = textY + lineHeight;

        value  = String.valueOf(gp.player.life + "/" + gp.player.maxHealth);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;

        value  = String.valueOf(gp.player.strength);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;

        value  = String.valueOf(gp.player.dexterity);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;

        value  = String.valueOf(gp.player.attack);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;

        value  = String.valueOf(gp.player.defense);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;

        value  = String.valueOf(gp.player.exp);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;


        value  = String.valueOf(gp.player.nextLevelExp);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;


        value  = String.valueOf(gp.player.coin);
        textX = getXforAllRightText(value, tailX);
        g2.drawString(value, textX, textY);

        textY = textY + lineHeight;

        g2.drawImage(gp.player.currentWeapon.down1, tailX - gp.tileSize , textY , null );
    }

    public void drawSubWindow(int x, int y, int width, int height){

        Color c = new Color(0,0,0);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c= new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width - 10, height-10, 25, 25);

    }

    public void drawGameoverScreen() {

        g2.setColor(Color.red);
        String text = "GAME OVER";
        String subt = "Start again from the beginning. Close the window now.";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text,x,y);
        x = getXforCenteredText(subt);
        g2.setFont(arial20);
        y = y + gp.tileSize;
        g2.setColor(Color.yellow);
        g2.drawString(subt, x, y);
    }

    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

    public int getXforAllRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }
}
