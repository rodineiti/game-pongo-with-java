/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author rodinei.teixeira
 */
public class Ball {
    public double x, y;
    public int w, h;
    
    public double dx, dy, speed = 1.7;
    
    public Ball(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.w = 4;
        this.h = 4;
        
        int angle = new Random().nextInt(120 - 45) + 45 + 1;        
        this.dx = Math.cos(Math.toRadians(angle));
        this.dy = Math.sin(Math.toRadians(angle));
    }
    
    public void tick()
    {
        if (x+(dx*speed) + w >= Pong.WIDTH) {
            dx*= -1;
        } else if (x+(dx*speed) + w < 0) {
            dx*= -1;
        }
        
        if (y >= Pong.HEIGHT) {
            //ponto do enemy
            System.out.println("Ponto do Inimido.");
            new Pong();
            return;
        } else if (y < 0) {
            //ponto do jogador
            System.out.println("Ponto do Jogador! NOSSO.");
            new Pong();
            return;
        }
        
        Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), w, h);        
        Rectangle boundsPlayer = new Rectangle(Pong.player.x, Pong.player.y, Pong.player.w, Pong.player.h);
        Rectangle boundsEnemy = new Rectangle((int)Pong.enemy.x, (int)Pong.enemy.y, Pong.enemy.w, Pong.enemy.h);
        
        if (bounds.intersects(boundsPlayer)) {
            int angle = new Random().nextInt(120 - 45) + 45 + 1;        
            this.dx = Math.cos(Math.toRadians(angle));
            this.dy = Math.sin(Math.toRadians(angle));
            if (dy > 0) {
                dy*=-1;
            }            
        } else if (bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt(120 - 45) + 45 + 1;        
            this.dx = Math.cos(Math.toRadians(angle));
            this.dy = Math.sin(Math.toRadians(angle));
            if (dy < 0) {
                dy*=-1;
            }            
        }
        
        x+=dx*speed;
        y+=dy*speed;
    }
    
    public void render(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillRect((int)x, (int)y, w, h);
    }
}
