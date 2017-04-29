package logica;



import java.util.ArrayList;
import java.util.Random;

/*
 * Clase generica de nodo para cualquier tipo de dato
 */
public final class Nodo<T>
{
    private T Valor;
    private int cantidad;
    private ArrayList<Nodo<T>> hijos;

    /*
     * Crea la instancia del nodo
     */
    private Nodo()
    {
        Random r = new Random();
        cantidad = (r.nextInt(4))+3;
        hijos = new ArrayList(cantidad);
    }

    /*
     * Muestra el contenido del nodo en un solo string
     */
    public String show(){
        return Valor.toString();
    }
    /*
     * Crea la instancia del nodo con un objeto dado
     */
    public Nodo(T pValue)
    {
        setValue(pValue);
        Random r = new Random();
        cantidad = (r.nextInt(4))+2;
        hijos = new ArrayList<>(cantidad);
    }
    /*
     * Devuelve el objeto guardado en el nodo
     */
    public T getValue() 
    {

            return Valor;
    }
    /*
     * Cambia el objeto del nodo por otro dado por parametro
     */
    public void setValue(T pValue) 
    {
            Valor = pValue;
    }
    public int getCantidad()
    {
        return cantidad;
    }
    public ArrayList<Nodo<T>> getHijos() 
    {
        return hijos;
    }
    public void addHijo(int index,Nodo<T> n)
    {
        hijos.add(index, n);
    }
    public void addHijo(Nodo<T> n)
    {
        hijos.add(n);
    }
    public T isValor() 
    {
        return Valor;
    }
    public T getValor() 
    {
        return Valor;
    }
}