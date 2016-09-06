/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game.pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import jgame.game.GameObject;
import jgame.game.Scene;

/**
 *
 * @author Matheus
 */
public class Division extends GameObject
{
    public Division(Scene scene)
    {
        super(scene);
    }

    @Override
    public void onDraw(Graphics g)
    {
        int lineCount = 6;
        int lineHeight = g.getClipBounds().width / lineCount;
        int lineWidth = 20;
        int space = 50;
        int centerX = g.getClipBounds().width / 2;
        
        g.setColor(Color.DARK_GRAY);
        
        for(int i = 0; i < lineCount; i++)
        {
            g.fillRect(centerX - lineWidth/2, i * lineHeight - space/4, lineWidth, lineHeight - space);
        }
    }
    @Override
    public void onUpdate(Rectangle c){}
}
