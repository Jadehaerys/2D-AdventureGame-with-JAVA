package main;

import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.*;
import javax.swing.JPanel;

import Entity.player;


public class GamePanel extends JPanel implements Runnable {
   
   
   //SCREEN SETTINGS
   final int originalTileSize = 16; //16x16 tile
   final int scale = 3;
   public final int tileSize = originalTileSize * scale; //48x48 tile
   
   
   final int maxScreenCol = 16;
   final int maxScreenRow = 12;
   final int screenWidth = tileSize * maxScreenCol; // 768 pixels
   final int screenHeight = tileSize * maxScreenRow; // 576 pixels
   
   //fps

   int fps = 60;

   Thread gameThread;
   KeyHandler keyH = new KeyHandler();
   player player = new player(this, keyH); 

   //setup player default position
   int playerX = 100;
   int playerY = 100;
   int playerSpeed = 4;
   

   public GamePanel() {
      this.setPreferredSize(new Dimension(screenWidth, screenHeight));
      this.setBackground(Color.black);
      this.setDoubleBuffered(true);
      this.addKeyListener(keyH);
      this.setFocusable(true);
   }
   
   public void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
   }
   
    @Override
    public void run() {

         double drawInterval = 1000000000 / fps;
         double nextDrawTime = System.nanoTime() + drawInterval;


        while(gameThread != null) {
            
           double currentTime = System.nanoTime();
           double remainingTime = nextDrawTime - currentTime;
           if (remainingTime < 0) {
              nextDrawTime = currentTime + drawInterval;
           } else {
              try {
                 Thread.sleep((long) (remainingTime / 1_000_000));
              } catch (InterruptedException e) {
                 e.printStackTrace();
              }
              nextDrawTime += drawInterval;
           }

            //UPDATE: update information such as character positions
         update();

            //DRAW: draw the screen with the updated information
            repaint();
            


        }
    }
   
    public void update() {
       
         player.update();
       
    }
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       
         Graphics2D g2 = (Graphics2D)g;
       
         player.draw((Graphics2D)g2);
       g2.dispose();
    }
      

}
