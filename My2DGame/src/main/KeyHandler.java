package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    
    public boolean enterPressed, upPressed, downPressed, leftPressed, rightPressed, JPressed, escPressed;

    boolean checkDrawTime;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }

        //debug
        if(code == KeyEvent.VK_T){
            if(checkDrawTime == false){
                checkDrawTime = true; 
            }
            else if (checkDrawTime == true){
                checkDrawTime = false;
            }
        }

        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }

        if(code  == KeyEvent.VK_E){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
        }

        //attacking

        if(code == KeyEvent.VK_J){
            JPressed = true;
        }

        if(code  == KeyEvent.VK_ESCAPE){
            escPressed = true;
        }

        if(escPressed == true){
            gp.gameState = gp.characterState;
        }
    }

    

    @Override
    public void keyReleased(KeyEvent e){

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }

        if(code == KeyEvent.VK_ENTER){
            enterPressed = false;
        }

        if(code == KeyEvent.VK_J){
            JPressed = false;
        }

        if(code == KeyEvent.VK_ESCAPE){
            escPressed = false;
        }

        if(escPressed == false){
            gp.gameState = gp.playState;
        }
    }
    
}
