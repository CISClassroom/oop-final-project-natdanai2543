/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackgame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author COMPUTER
 */
public class MyBody {
    
    private int xCoor, yCoor, width, height;
    
    public MyBody(int xCoor, int yCoor, int titleSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        width = titleSize;
        height = titleSize;
    }
    public void tick(){
        
    }
    public void draw(Graphics g){
        g.setColor(Color.LIGHT_GRAY); // Color Snake
        g.fillRect(xCoor * width-1, yCoor *  height-1, height-2, width-2); // . Snake
    }
    public int getxCoor(){
        return xCoor;
    }
    public void setxCoor(int xCoor){
        this.xCoor = xCoor;
    }
    public int getyCoor(){
        return yCoor;
    }
    public void setyCoor(int yCoor){
        this.yCoor = yCoor;
    }
}
