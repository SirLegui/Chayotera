/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import logica.ArbolEnario;

/**
 *
 * @author edgerik
 */
public class Chayotera {

    /**
     * Crea un nuevo arbol y abre la interfaz del usuario
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolEnario.getInstance();
        Ventana main = new Ventana();
        main.setVisible(true);
    }
    
}
