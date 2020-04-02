/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackgame;

import javax.swing.JFrame;

/**
 *
 * @author COMPUTER
 */
public class Main {

    static void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Main(){
        
        JFrame frame = new JFrame();
        GamePn gamepn = new GamePn();
        
        frame.add(gamepn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SNAKE GAME !!"); //Show NameGame
        
        
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);//Middle Screen
        
        
    }
    public static void main(String[] args){
        
        new Main();
        
    }
   

    private void add(GamePn s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
