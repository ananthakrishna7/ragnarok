package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed, downPressed, leftPressed, rightPressed;	
	
	@Override
	public void keyTyped(KeyEvent e) { //we're not going to use this in most cases for our game
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) { // VK_W is W key. for up, use VK_UP same for all the others
			upPressed = true;
		}
		
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) { 
			downPressed = true;
		}
		
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) { 
			leftPressed = true;
		}
		
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) { 
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) { // VK_W is W key. for up, use VK_UP same for all the others
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) { 
			downPressed = false;
		}
		
		if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) { 
			leftPressed = false;
		}
		
		if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) { 
			rightPressed = false;
		}
	}

}
