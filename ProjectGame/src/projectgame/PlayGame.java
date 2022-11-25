/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PlayGame extends JFrame implements ActionListener{
    HomeGame home = new HomeGame();
    AllGame all = new AllGame();
    GameOver gameover = new GameOver();
    
    PlayGame(){
        this.setSize(900, 550);
        home.BStart.addActionListener(this);
        this.add(home);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home.BStart) {
            this.setLocationRelativeTo(null);
            this.setSize(950,500);
            this.remove(home);
            this.add(all); 
            all.requestFocusInWindow();
            all.timestart = false;
           
        repaint();
        }
    }
    public static void main(String[] args) {
        JFrame jf = new PlayGame();
        jf.setSize(900,550);
        jf.setTitle("Space Invaders");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
}
