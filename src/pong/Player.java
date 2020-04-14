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
public class Player {
    
    public boolean right, left;
    public int x, y, w, h;
    
    public Player(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.w = 40;
        this.h = 5;
    }
    
    public void tick()
    {
        if (right) {
            x++;
        } else if (left) {
            x--;
        }
        
        if (x+w > Pong.WIDTH) {
            x = Pong.WIDTH - w;
        } else if (x < 0) {
            x = 0;
        }
    }
    
    public void render(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, w, h);
    }
}
