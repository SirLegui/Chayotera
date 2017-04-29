/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

/**
 *
 * @author edgerik
 * @param <T>
 */
public class Controlador<T> {
    
    private static Controlador Instance;
    private final ArbolEnario nario = ArbolEnario.getInstance();
    private final int probabilidad, delay, max;
    private int cantidad_hijos;
    private Random r = new Random();
    private boolean seguir;
    
    public Controlador(int probabilidad, int delay, int max) 
    {
        this.probabilidad = probabilidad;
        this.delay = delay;
        this.max = max;
        seguir = true;
        this.cantidad_hijos = 0;
    }
    public Controlador()
    {
        probabilidad = 80;
        delay = 2;
        max = 25;
        seguir = true;
        this.cantidad_hijos = 0;
    }
    public boolean isChayote()
    {
        return r.nextInt(100)>probabilidad;
    }
    public void draw(Graphics g,Nodo<T> nodo)
    {
        ((Figura) nodo.getValue()).pintar(g, nodo.getCantidad());
    }
    public int getDelay() 
    {
        return delay;
    }
    public boolean seguir() 
    {
        return seguir;
    }
    public void setSeguir(boolean seguir) 
    {
        this.seguir = seguir;
    }
    public void incrementa_chayotes()
    {
        nario.aumentarChayotes();
        
    }
    public int getMax() 
    {
        return max;
    }
    public boolean isFull()
    {
        
        return nario.getCantidad_hijos()>=max;
    }
    public void insertNodo(Nodo<T> padre, Nodo<T> nuevo)
    {
        nario.insertNodo(padre, nuevo);
    }
    public void IniciarArbol()
    {
        Hilo inicio = new Hilo(nario.getRaiz(), 0);
        inicio.start();
    }
    public synchronized static Controlador getInstance()
    {
        if(Instance == null)
        {
            Instance = null;
        }
        return Instance;
        
    }
    public synchronized static Controlador getInstance(int probabilidad, int delay, int max)
    {
        if(Instance == null)
        {
            Instance = new Controlador(probabilidad, delay,  max);
        }
        return Instance;
        
    }
    
}
