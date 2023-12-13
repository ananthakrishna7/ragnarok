package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GamePanel gp;
    
    public boolean enterPressed, upPressed, downPressed, leftPressed, rightPressed, JPressed, escPressed, qPressed;

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

        if (code == KeyEvent.VK_Q){
            qPressed = true;
        }
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

        if(code == KeyEvent.VK_W){
            if(gp.ui.slotRow !=0 ){
                gp.ui.slotRow--;
            }
        }        
        if(code == KeyEvent.VK_A){
            if(gp.ui.slotCol != 0 ){
                gp.ui.slotCol--;
            }
        }        
        if(code == KeyEvent.VK_S){
            if(gp.ui.slotRow != 3){
                gp.ui.slotRow++;
            }
        }        
        if(code == KeyEvent.VK_D){
            if(gp.ui.slotCol != 4){
                gp.ui.slotCol++;
            }
        } 
        
        if(code  == KeyEvent.VK_ENTER){
            gp.player.selectItem();
        }

        // if(gp.gameState == gp.gameOverState){
        //     if(code == KeyEvent.VK_UP){
        //         gp.ui.commandNum--;
        //         if(gp.ui.commandNum < 0){
        //             gp.ui.commandNum = 1;
        //         }
        //     }
        //     if(code == KeyEvent.VK_DOWN){
        //         gp.ui.commandNum++;
        //         if(gp.ui.commandNum > 1){
        //             gp.ui.commandNum = 0;
        //         }
        //     }

        //     if(code == KeyEvent.VK_O){
        //         if(gp.ui.commandNum == 0){
        //             gp.gameState = gp.playState;
        //         }
        //         else if (gp.ui.commandNum == 1){
        //             gp.gameState = gp.pauseState;
        //         }
        //     }
        // }

        
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
