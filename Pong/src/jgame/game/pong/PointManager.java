/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game.pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import jgame.game.GameObject;
import jgame.game.Scene;

/**
 *
 * @author Matheus
 */
public class PointManager extends GameObject
{
    private int player, enemy;
    private Ball ball;
    public PointManager(Scene scene)
    {
        super(scene);
    }

    @Override
    public void onDraw(Graphics g)
    {
        
        int centerX = g.getClipBounds().width / 2;
        Font font = new Font("Arial Bold", Font.BOLD, 74);
        
        g.setColor(Color.GRAY);
        g.setFont(font);
        
        g.drawString("" + player, centerX - 80, 80);
        g.drawString("" + enemy, centerX + 40, 80);
    }

    @Override
    public void onUpdate(Rectangle c)
    {
        SceneGame scene = (SceneGame)this.parent;
        Ball ball = scene.getBall();
        if(ball.getOverflowLeft()){ enemy++; ball.resetPosition(); }
        if(ball.getOverflowRight()){ player++; ball.resetPosition(); }
    }
    
    public void checkBallOverflow(Ball ball)
    {
        
    }
}
