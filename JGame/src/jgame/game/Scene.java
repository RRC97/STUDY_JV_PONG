/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgame.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Matheus
 */
public class Scene extends JPanel implements ActionListener
{
    private ArrayList<GameObject> elements;
    protected int width = 800;
    protected int height = 600;
    protected ScreenGame parent;
    public Scene(ScreenGame screen)
    {
        super();
        this.setPreferredSize(new Dimension(this.width, this.height));
        
        this.elements = new ArrayList<GameObject>();
        
        this.parent = screen;
    }
    
    @Override
    public void addKeyListener(KeyListener l)
    {
        this.parent.addKeyListener(l);
    }
    
    @Override
    public void addMouseListener(MouseListener l)
    {
        this.parent.addMouseListener(l);
    }
    
    public void addElement(GameObject go)
    {
        this.elements.add(go);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(GameObject element : this.elements)
        {
            element.onDraw(g);
        }
    }
    
    public void onUpdate()
    {
        for(GameObject element : this.elements)
        {
            element.onUpdate(this.getBounds());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.onUpdate();
        this.repaint();
    }
}
