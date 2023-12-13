package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
    
    // screen settings - NEEDS TO BE CHANGED AS PER OUR REQUIREMENT
    final int originaTileSize = 16; // 16x16 size basically 16 bit stuff
    final int scale  = 3;

    public final int tileSize = originaTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight  =  tileSize * maxScreenRow;

    //world map settings

    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    int FPS = 200;

    TileManager tileM = new TileManager(this);

    KeyHandler keyH = new KeyHandler(this);
  

    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player player =  new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10];
    ArrayList<Entity> entityList = new ArrayList<>();

    //npc
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[100];

    //sound settigns
    // Sound sound = new Sound();
    // SOUND 
	Sound music = new Sound();
	Sound soundEffect = new Sound();


    public AssetSetter aSetter = new AssetSetter(this);
    Thread gameThread;
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);

    //gamestate

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int characterState = 3;
    public final int gameOverState = 4;
    // public final int deadState = 0;

    
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //efficinet rendering done in the offscreen
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void die(){
        if (this.player.life == 0){
            this.ui.gameFinished = true;
        }
    }

    public void setupGame() {

        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        gameState = playState;
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    //the below one is for game loop

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; 
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){

            // 1.updating: update information such as character position
            update();

            // 2. draw the screen with the updatede information
            repaint();

            

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime +=drawInterval;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void update(){

        if (gameState == playState){
            player.update();
            die();

            for(int i = 0 ; i< npc.length ; i++){
                if(npc[i] != null){
                    npc[i].update();
                }
            }

            for (int i = 0; i< monster.length ; i++){
                if(monster[i]!=null){
                    if(monster[i].alive == true && monster[i].dying == false){
                        monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i] = null;;
                    }
                }
            }
        }
        if (gameState == pauseState){
            //nothing
        }
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 =  (Graphics2D)g;  //this graphics2d class extends the grpahics class to provide some more sophisticated control over the geometery coordinatie transformations and much mroe
        
        //debug
        long drawStart = 0;
        if(keyH.checkDrawTime == true){
            drawStart = System.nanoTime();            
        }

        //tile
        tileM.draw(g2);
        
        //object
        for(int i  = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2,this);
            }
        }

        //npc
        for(int i  = 0 ; i < npc.length ; i++){
            if(npc[i] != null){
                npc[i].draw(g2);
            }
        }

        for(int i = 0 ; i< monster.length; i++){
            if(monster[i] != null){
                monster[i].draw(g2);
            }
        }

        //player
        player.draw(g2);

        //ui

        ui.draw(g2);

        if(keyH.checkDrawTime == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("dtraw time: " + passed, 10, 400);
            System.out.println(passed);
        }


        g2.dispose();
    }

    public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSE(int i) {
		soundEffect.setFile(i);
		soundEffect.play();
	}

}
 