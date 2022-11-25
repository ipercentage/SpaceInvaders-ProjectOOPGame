/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectgame;

import javax.swing.*;

public class ProjectGame {

    public static void main(String[] args) {
        JFrame jf = new PlayGame();
        jf.setSize(900, 550);
        jf.setTitle("Space Invaders");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    
}
