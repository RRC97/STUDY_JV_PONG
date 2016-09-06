/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Matheus
 */
public class ScreenGame extends JFrame
{
    private Scene scene;
    private Timer timer;
    public ScreenGame(String title)
    {
        super(title);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.scene = new Scene(this);
        this.timer = new Timer(1000/60, this.scene);
        this.timer.start();
        
        this.add(this.scene);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    
    public void setScene(Scene scene)
    {
        this.remove(this.scene);
        this.timer.removeActionListener(this.scene);
        
        this.scene = scene;
        this.scene.requestFocus();
        
        this.add(this.scene);
        this.timer.addActionListener(this.scene);
    }
}
