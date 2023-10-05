package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{ //GamePanel is a child of JPanel. implements Implements an interface. add this interface in UML class diagram.

	// Screen Settings
	final int originalTileSize = 16; // final --> constant; this is 16x16 tile. Determines the size of the player, npc, everything. possibly why this is 16 bit game
	// let us use 32x32 later...
	final int  scale = 3; //scaling it up so we can see it
	//can adjust the scale if required
	public final int tileSize = originalTileSize * scale; // now 48x48
	//can change the below things
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12; // 3:4 ratio
	public final int screenWidth = tileSize * maxScreenCol; //768 pixels
	public final int screenHeight = tileSize * maxScreenRow; //576 pixels
	
	// WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	// FPS
	int FPS = 60; // can change if necessary
	
	// Background Tiles
	TileManager tileM = new TileManager(this);
	
	// Movement
	KeyHandler keyH = new KeyHandler(); //this handles the keypresses. see KeyHandler.java for details 
	Thread gameThread; //gives the game the concept of time... Thread keeps running until you stop it.
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public Player player = new Player(this, keyH); // Instantiate Player class
	public SuperObject obj[] = new SuperObject[10];
	
	
	//now we create the constructor 
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // this function is inherited from JPanel
		this.setBackground(Color.black); //can experiment with this 
		this.setDoubleBuffered(true); // draws whatever comes out of 'this' class in an off screen painting buffer. good for improving rendering performance of the game.
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
	}
	
	
	public void startGameThread()
	{
		gameThread = new Thread(this); //this means this class. we are instantiating this thread
		gameThread.start();
	}

	@Override
//	public void run() {  // here we will create a game loop
//		
//		// gameLoop methodology: 1. Sleep method
//		double drawInterval = 1000000000/FPS; // 1 second/60 for 60 frames per second. unit used here is nano seconds. result ~ 0.0166 second
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		
//		while (gameThread != null) {
//		
//			// 1. UPDATE: Update information such as character position
//			update();
//			
//			// 2. DRAW: Draw the screen using the updated information.
//			repaint(); //That's how you call the paintComponent() method. idk why
//			
//			// Now some time must have passed. we have to sleep for the remaining time until the next draw time
//			
//			try {
//				
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime /= 1000000; // because sleep only accepts millis 
//				if (remainingTime < 0) remainingTime = 0; // this is incase update and repaint take longet than the total time between redraws
//				Thread.sleep((long) remainingTime);
//				
//				// now that the thread has been awakened, we need to set the next draw time
//				
//				nextDrawTime += drawInterval;
//				
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		}
//	} // this is laggy
	
	public void run() {
		
		// 2. Delta/Accumulator method
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		// To display FPS
		long timer = 0;
		int drawCount = 0;
		
		while (gameThread != null)
		{
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	} // also laggy
	
	public void update() {
		
		player.update();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		for(int i = 0; i < obj.length; i++) {
			if (obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		player.draw(g2);
		
		g2.dispose();
	}
}
