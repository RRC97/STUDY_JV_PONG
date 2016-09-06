/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game.pong;

import jgame.game.ScreenGame;

/**
 *
 * @author Matheus
 */
public class Main
{
    public static void main(String[] args)
    {
        ScreenGame screen = new ScreenGame("Pong");
        
        SceneGame game = new SceneGame(screen);
        screen.setScene(game);
    }
}
