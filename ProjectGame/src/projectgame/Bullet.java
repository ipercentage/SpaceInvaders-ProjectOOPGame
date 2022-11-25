/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgame;

import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Bullet extends JPanel{
    public ImageIcon[] imball = new ImageIcon[5];
    public int y;
    public int x;
    public int count=0;
    Bullet(int x,int y){
        for(int i=0;i<imball.length;i++){
            String imageLocation = "ballr"+(i+1)+".png";
            imball[i] = new ImageIcon(this.getClass().getResource(imageLocation));
	}
            this.x = x;
            this.y = y;   
    }
	
    public void move(){
	this.x+=15;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,10,10));
    }
}
