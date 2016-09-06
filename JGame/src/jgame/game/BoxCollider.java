/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game;

/**
 *
 * @author Matheus
 */

public class BoxCollider
{
    private int x, y, width, height;
    
    private boolean completeCollision, widthCollision, heightCollision;
    
    public BoxCollider(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int onCollisionBoxCollider(BoxCollider box)
    {
        if(!this.heightCollision && box.x <= this.x + this.width && box.x + box.width >= this.x)
        {
            this.widthCollision = true;
            if(box.y + box.height >= this.y && box.y <= this.y + this.height)
            {
                this.completeCollision = true;
                return 0;
            }
        }
        else this.widthCollision = false;
        
        if(!this.widthCollision && box.y + box.height >= this.y && box.y <= this.y + this.height)
        {
            this.heightCollision = true;
            if(box.x <= this.x + this.width && box.x + box.width >= this.x)
            {
                this.completeCollision = true;
                return 1;
            }
        }
        else this.heightCollision = false;
        
        return -1;
    }
    
    public void reset(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
