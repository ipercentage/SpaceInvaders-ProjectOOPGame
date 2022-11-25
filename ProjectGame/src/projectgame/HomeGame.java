/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HomeGame extends JPanel{
    private ImageIcon bg1 = new ImageIcon(this.getClass().getResource("bghome3.gif"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("startbutton.png"));
    public JButton BStart = new JButton(start);
    HomeGame(){
            setLayout(null);
            BStart.setBounds(330,300,220,100);
            add(BStart);
	}
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(bg1.getImage(),0,0,900,550,this);
            g.setColor(Color.ORANGE);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));		
            g.drawString("Space Invaders",100,210);	
	}
}
