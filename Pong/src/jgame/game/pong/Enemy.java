/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import jgame.game.BoxCollider;
import jgame.game.GameObject;
import jgame.game.Scene;

/**
 *
 * @author Matheus
 */
public class Enemy extends GameObject
{
    private int x, y, width, height, speed;
    private boolean moveUp, moveDown;
    private BoxCollider collider;
    public Enemy(Scene scene, int x, int y)
    {
        super(scene);
        
        this.width = 30;
        this.height = 120;
        this.x = x;
        this.y = y - this.height/2;
        this.speed = 5;
        
        this.collider = new BoxCollider(this.x, this.y, this.width, this.height);
    }

    @Override
    public void onDraw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void onUpdate(Rectangle c)
    {
        if(moveUp) this.y -= this.speed;
        if(moveDown) this.y += this.speed;
        
        if(this.y + this.height >= c.height) this.y = c.height - this.height;
        if(this.y <= 0) this.y = 0;
        
        this.collider.reset(this.x, this.y, this.width, this.height);
        
        SceneGame scene = (SceneGame)this.parent;
        Ball ball = scene.getBall();
        BoxCollider ballCollider = ball.getCollider();

        moveUp = (ball.getY() < y + this.height/2);
        moveDown = (ball.getY() > y + this.height/2);
        
        if(ballCollider != null)
        {
            int iCollider = this.collider.onCollisionBoxCollider(ballCollider);
            
            if(iCollider == 0)ball.reverseSpeedY();
            if(iCollider == 1)ball.reverseSpeedX();
        }
    }
}
