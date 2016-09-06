/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Matheus
 */
public abstract class GameObject
{
    protected BoxCollider collider;
    protected Scene parent;
    public GameObject(Scene scene)
    {
        this.parent = scene;
        this.parent.addElement(this);
    }
    
    public abstract void onDraw(Graphics g);
    public abstract void onUpdate(Rectangle c);
    
    public BoxCollider getCollider()
    {
        if(collider != null)
            return this.collider;
        
        return null;
    }
}
