/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author edgerik
 */
public class Figura {
    private int x, y, ancho;
    private boolean coyol;

    public Figura(int x, int y, boolean is, int ancho) 
    {
        this.ancho = ancho;
        this.x = x;
        this.y = y;
        this.coyol = is;
    }
    public void pintar(Graphics g, int cantidad)
    {
        if(coyol){
            g.setColor(Color.BLACK);
            int cx, cy;
            cx = x-ancho/2;
            cy = y+100;
            for(int i =0;i<cantidad;i++){
                int corrimiento = cx+i*(ancho/cantidad);
                g.drawLine(x, y,corrimiento, cy);
            }
        }else{
            g.setColor(Color.GREEN);
            g.fillOval(x-15, y-15, 30, 30);
        }
    }
    public boolean getChayote() 
    {
        return coyol;
    }
    public int getAncho() 
    {
        return ancho;
    }
    public int getX() 
    {
        return x;
    }
    public int getY() 
    {
        return y;
    }
}
