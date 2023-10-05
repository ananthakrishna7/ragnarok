package main;

import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Ragnarok");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack(); // windows shrink wraps around the components inside it. in this case, the gamePanel
		//now we can see it
		
		window.setLocationRelativeTo(null); //centres the window on the screen
		window.setVisible(true);
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}

}
