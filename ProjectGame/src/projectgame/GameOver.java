/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOver extends JPanel{
	
    private ImageIcon feildover = new ImageIcon("bghome2.gif");
    AllGame all = new AllGame();
	
    GameOver(){
	this.setLayout(null);
        this.remove(all);
    } 
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
	g.drawImage(feildover.getImage(),0,0,1000,800,this); 
	}
        
}
