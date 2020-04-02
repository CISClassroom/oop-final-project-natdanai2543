/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snackgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author COMPUTER
 */
public class GamePn extends JPanel implements Runnable, KeyListener{
    
    private static final long serialVersionUID = 1L;
    
    public static final int WIDTH = 600,HEIGHT = 500;
    
    private Thread thread;
    
    private boolean running=false;
    
    private boolean right = true, left = false, up = false, down = false;
    
    private MyBody b;
    private ArrayList<MyBody> snake;
    
    private int xCoor = 10, yCoor = 10, size = 3;
    private int ticks = 0;
    
    private Mapple mapple;
    private ArrayList<Mapple> apples;
    
    private Random r;
    private Thread th;
            
    private int score = 0;
    
    public GamePn(){
        setFocusable(true);
        
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
        
        
        snake = new ArrayList<MyBody>();
        apples = new ArrayList<Mapple>();
        
        
        r = new Random();
        
        
        start();
        
    }
    public void start(){
        running = false;
        th = new Thread(this);
        
        
    }
    
    public void stop(){
        running = false;
        try {
            th.join();
        }catch(InterruptedException e){
            // TOOO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public void tick(){
        if(snake.size() ==0){
            b = new MyBody(xCoor, yCoor, 1);
            snake.add(b);
        }
        ticks++;
        if(ticks > 605000){ // Speed Snake
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;
            
            ticks = 0 ;
            
            b = new MyBody(xCoor, yCoor, 10);
            snake.add(b);
            
            if(snake.size() > size) {
                snake.remove(0);
            }
        } 
        if(apples.size() ==0){
            int xCoor = r.nextInt(59);
            int yCoor = r.nextInt(49);
            
            mapple = new Mapple(xCoor, yCoor, 10);
            apples.add(mapple);
        }
        for(int i = 0 ; i < apples.size(); i++){
                if(xCoor == apples.get(i).getxCoor() && yCoor == apples.get(i).getyCoor()){
                   size++;
                   apples.remove(i);
                   i++;
                   score++;
                   //Hit Screen
                }
            }
        for(int i = 0 ; i < snake.size(); i ++){
            if(xCoor == snake.get(i).getxCoor() && yCoor == snake.get(i).getyCoor()){
                if(i != snake.size()- 1){ //Hit Body
                System.out.println("Game Over !!");
                
                stop();
            }
            }
        }
            if(xCoor < 0|| xCoor > 59 || yCoor < 0 || yCoor > 49){
    System.out.println("Game Over !!");
    // Show Game OVer
    
    stop();
    }
    }
    public void paint(Graphics g){
        g.clearRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.BLACK);      //BackGround
        g.fillRect(0,0,WIDTH,HEIGHT);
   if(running==false){                //Fisrt Screen Game
        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.BOLD,40));
        g.drawString("SnakeGame", WIDTH/2-120,HEIGHT/2);
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD,15));
        g.drawString("Plase Enter Spacebar To In Game", WIDTH/2-130,HEIGHT/2+15);
   }else{
        for(int i = 0 ; i < WIDTH/10 ; i++){
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
        }
        for(int i = 0 ; i < HEIGHT/10 ; i++){
            g.drawLine(0, i * 10, HEIGHT, i * 10);
        }
        for(int i = 0 ; i < snake.size() ; i++){
            snake.get(i).draw(g);
        }
        for(int i = 0 ; i < apples.size(); i++){
            apples.get(i).draw(g);
            
            g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN,14));
        g.drawString("Scores: "+score,520,25);
            //Show Score
            }
        }
    }

    public void STGame(){
        running=true;
        
        th.start();
    }
    
    @Override
    public void run() {
        while(running){
            tick();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

}

    @Override
    //Key Control
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
       if(key == KeyEvent.VK_RIGHT && !left){
           right = true;
           up = false;
           down = false;
       }
       if(key == KeyEvent.VK_LEFT && !right){
           left = true;
           up = false;
           down = false;
       }
           if(key == KeyEvent.VK_UP && !down){
           up = true;
           left = false;
           right = false;
           }
           if(key == KeyEvent.VK_DOWN && !up){
           down = true;
           left = false;
           right = false;
    }
           if(key==KeyEvent.VK_SPACE){
               STGame();
               
           }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
         
    }

    private void pack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
