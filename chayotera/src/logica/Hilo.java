package logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

class Hilo implements Runnable
{

    private int Nivel_Recursivo;
    private Nodo Actual;
    private Thread Hilo;
    private Controlador controlador;
    

    
    public Hilo(Nodo n, int nivel) 
    {
        this.Nivel_Recursivo = nivel;
        this.Actual = n;
        Hilo = new Thread(this);
    }
    public void start()
    {
        Hilo.start();
    }
    @Override
    public void run() 
    {
        controlador = Controlador.getInstance();
        Nodo n;
        int pos, cant;
        Figura f;
        cant =  Actual.getCantidad();
        for(int i=0; i<Actual.getCantidad();i++)
        {
            if(controlador.isFull() && controlador.seguir())
            {
                System.out.println("Se ha llegado al limite");
                break;
            }
            f = (Figura) Actual.getValue();
            pos = (f.getX()-f.getAncho()/2) + i* (f.getAncho()/(cant));
            n = new Nodo(new Figura(pos,   f.getY()+100,   controlador.isChayote(),   (f.getAncho()/cant)));
            controlador.insertNodo(Actual,n);
            
            //Si es coyol crea nuevo hilo
            if(((Figura) n.getValue()).getChayote())
            {
                (new Hilo(n, Nivel_Recursivo+1)).start();
            }
            else
            {
                System.out.println("Nuevo chayote en nivel: "+this.Nivel_Recursivo);
                controlador.incrementa_chayotes();
            }
            
            try {
                Hilo.sleep(controlador.getDelay()*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //controlador.setSeguir(false);
        
    }
    
}

