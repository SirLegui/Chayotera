/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;


/**
 *
 * @author edgerik
 * @param <T> any value
 */
public class ArbolEnario<T> 
{
    
    private static ArbolEnario Instance;
    private int cantidad_hijos;
    private T value;
    private Nodo<T> raiz;
    private int nivel;
    private ArrayList<Nodo<T>> figuras;
    
    private ArbolEnario()
    {
        cantidad_hijos = 0;
        nivel = 0;
        raiz = new Nodo(new Figura(850, 100, true, 850));
        figuras = new ArrayList();
        figuras.add(raiz);
    }
    public ArrayList<Nodo<T>> getFiguras() 
    {
        return figuras;
    }
    public synchronized static ArbolEnario getInstance()
    {
        if(Instance == null)
        {
            Instance = new ArbolEnario();
        }
        return Instance;
        
    }
    public int getCantidad_hijos() 
    {
        return cantidad_hijos;
    }
    public Nodo getRaiz() 
    {
        return raiz;
    }
    public void vaciarArbol()
    {
        figuras = new ArrayList();
    }
    public void aumentarChayotes()
    {
        cantidad_hijos++;
    }
    public void insertNodo(Nodo<T> actual, Nodo<T> nuevo)
    {
        if(actual!=null)
        {
            System.out.println("El actual tiene "+actual.getCantidad()+" hijos");
            actual.addHijo(nuevo);
            figuras.add(nuevo);
        }
        System.out.println("Tengo "+cantidad_hijos+ " hijos.");
    }
}