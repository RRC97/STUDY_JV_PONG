/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game.pong;

import java.awt.Color;
import jgame.game.Scene;
import jgame.game.ScreenGame;

/**
 *
 * @author Matheus
 */
public class SceneGame extends Scene
{
    private Ball ball;
    private Player player;
    private Enemy enemy;
    private Division division;
    private PointManager pManager;
    public SceneGame(ScreenGame screen)
    {
        super(screen);
        this.setBackground(Color.BLACK);
        
        int xCenter = this.width/2;
        int yCenter = this.height/2;
        
        this.division = new Division(this);
        this.pManager = new PointManager(this);
        this.ball = new Ball(this, xCenter, yCenter);
        this.player = new Player(this, 20, yCenter);
        this.enemy = new Enemy(this, this.width - 50, yCenter);
        
        this.addKeyListener(player);
    }
    
    public Ball getBall()
    {
        return this.ball;
    }
}
