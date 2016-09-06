/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import jgame.game.BoxCollider;
import jgame.game.GameObject;
import jgame.game.Scene;

/**
 *
 * @author Matheus
 */
public class Ball extends GameObject
{
    private int x, y, width, height, speedX, speedY, xDefault, yDefault;
    private boolean overflowLeft, overflowRight;
    public Ball(Scene scene, int x, int y)
    {
        super(scene);
        this.x = x;
        this.y = y;
        this.xDefault = x;
        this.yDefault = y;
        this.width = 20;
        this.height = 20;
        
        boolean xSide = (Math.random() * 2 < 1);
        boolean ySide = (Math.random() * 2 < 1);
        
        this.speedX = xSide ? -5 : 5;
        this.speedY = ySide ? -5 : 5;
        
        this.collider = new BoxCollider(this.x - this.width/2, this.y - this.height/2, this.width, this.height);
    }
    
    @Override
    public void onDraw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        
        g.fillArc(this.x - this.width/2, this.y - this.height/2, this.width, this.height, 0, 360);
    }

    @Override
    public void onUpdate(Rectangle c)
    {
        this.x += this.speedX;
        this.y += this.speedY;
        
        overflowRight = (this.x >= c.width + this.width/2);
        overflowLeft = (this.x <= -this.width/2);
           
        if(this.y >= c.height - this.height/2 || this.y <= this.height/2) this.speedY = -this.speedY;
    
        this.collider.reset(this.x - this.width/2, this.y - this.height/2, this.width, this.height);
        
    }
    
    public void reverseSpeedX()
    {
        acelerate();
        this.speedX = -this.speedX;
        this.x += this.speedX;
    }
    public void reverseSpeedY()
    {
        acelerate();
        this.speedY = -this.speedY;
        this.y += this.speedY;
    }
    public void acelerate()
    {
        this.speedX *= 1.1f;
        this.speedY *= 1.1f;
    }
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public boolean getOverflowRight()
    {
        return overflowRight;
    }
    
    public boolean getOverflowLeft()
    {
        return overflowLeft;
    }
    
    public void resetPosition()
    {
        boolean xSide = (this.speedX > 0);
        boolean ySide = (Math.random() * 2 < 1);
        
        this.speedX = xSide ? -5 : 5;
        this.speedY = ySide ? -5 : 5;
        this.x = this.xDefault;
        this.y = this.yDefault;
    }
}
