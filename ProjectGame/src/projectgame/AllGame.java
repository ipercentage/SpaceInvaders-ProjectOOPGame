/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AllGame extends JPanel{
    private ImageIcon bg2 = new ImageIcon(this.getClass().getResource("bggame.png"));
    SpaceShip ss = new SpaceShip();
    HomeGame home = new HomeGame();
 
    public ArrayList<Bullet> bullet = new ArrayList<Bullet>();
    public ArrayList<Alien> alien = new ArrayList<Alien>();
    
    ImageIcon feildover = new ImageIcon(this.getClass().getResource("bghome2.gif"));
    private JLabel score = new JLabel();
    public int countscore = 0;
    
    boolean timestart = true;
    boolean startball = false;
    boolean run =true;
     
    public int times;
      
    Thread time = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }

                if (timestart == true) {
                    repaint();
                }
            }
        }
    });
    
    Thread actor = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
                repaint();
            }
        }
    });
      
     Thread tball = new Thread(new Runnable() {
        public void run() {
            while (true) {
                try {
                    if (startball == false) {
                        Thread.sleep((long) (Math.random() * 100) + 1500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (startball == false) {
                    alien.add(new Alien());
                }
            }
        }
    });
      
    AllGame(){
        this.setFocusable(true);
        this.setLayout(null);
        this.add(score);
  
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
               super.keyPressed(e);
               int a = e.getKeyCode();
                if(a==KeyEvent.VK_UP ){
                    ss.y-=10;
                    repaint();
                }
                if(a==KeyEvent.VK_DOWN){
                    ss.y+=10;   
                    repaint();   
                }
                if(a==KeyEvent.VK_SPACE){
                     run=true;
                
                } if (ss.count > 3) {
                        ss.count = 0;
                    }
                else if (a == KeyEvent.VK_SPACE) {
                        bullet.add(new Bullet(90,ss.y+ 30));
                    } 
            }        
        });
        ss.y = 125;
        time.start();
        actor.start();
        tball.start();
    }
    
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg2.getImage(),0,0,1000,800,this);
            g.setColor(Color.YELLOW);
            g.drawString("SCORE    " + countscore, 820, 40);
            g.drawImage(ss.spaceship.getImage(),ss.x,ss.y,ss.h,ss.w,this);
            
            for (int i = 0; i < bullet.size(); i++) {
                Bullet bl = bullet.get(i);
                g.drawImage(bl.imball[bl.count % 5].getImage(), bl.x, bl.y, 18, 18, null);
                bl.move();
                
                if (bl.x  < 0) {
                    bullet.remove(i);
                }
            }
          
            for (int i = 0; i < alien.size(); i++) {
                g.drawImage(alien.get(i).getImage(), alien.get(i).getX(), alien.get(i).getY(), 60, 60, this);
            }
            for (int i = 0; i < bullet.size(); i++) {
                for (int j = 0; j < alien.size(); j++) {
                    if (Intersect(bullet.get(i).getbound(), alien.get(j).getbound())) {
                        alien.remove(j);
                        bullet.remove(i);
                        countscore += 10;
                        g.drawString("+10", ss.x + 100, 650);
                    }
                }
            }
            for (int i = 0; i < alien.size(); i++) {
                g.drawImage(alien.get(i).getImage(), alien.get(i).getX(), alien.get(i).getY(), 60, 60, this);
            }
           
           for (int j = 0; j < alien.size(); j++) {
            if (Intersect(ss.getbound(), alien.get(j).getbound())) {
                this.setLayout(null);
                run = false;
            }
            if(run == false){
              g.drawImage(feildover.getImage(), 0, 0, 1000, 800, this);
              g.setColor(Color.LIGHT_GRAY);
              g.setFont(new Font("2005_iannnnnTKO", Font.CENTER_BASELINE, 40));
              g.drawString("SCORE   " + countscore, 340, 150);
              g.setFont(new Font("2005_iannnnnTKO", Font.CENTER_BASELINE, 70));
              g.drawString("GAME OVER", 250, 100);
              g.setFont(new Font("2005_iannnnnTKO", Font.HANGING_BASELINE, 27));
              g.drawString("TAP TO PLAY AGAIN", 310, 420);
             }
                }            
    }
     
    public boolean Intersect(Rectangle2D a, Rectangle2D b) {
        return (a.intersects(b));
    }

}
