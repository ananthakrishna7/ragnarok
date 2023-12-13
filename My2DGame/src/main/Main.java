package main;

import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //lets the window close when the user clicks the x button
        window.setResizable(false);
        window.setTitle("GraphGear");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null); //to mkae the window appear in the center
        window.setVisible(true);

        gamePanel.setupGame();

        gamePanel.startGameThread();
    }
}