/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author rodinei.teixeira
 */
public class Enemy {
    
    public double x, y;
    public int w, h;
    
    public Enemy(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.w = 40;
        this.h = 5;
    }
    
    public void tick()
    {
        x+= (Pong.ball.x - x - 6) * 0.07;
    }
    
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, w, h);
    }
}
