/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollo4;

import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Capa {
    ArrayList<Neurona> neuronas=new ArrayList<>();
    public void crearNeuronas(int nNeuronas,int entradas)
    {
        for (int i = 0; i < nNeuronas; i++){
            Neurona n=new Neurona();
            n.CrearEntradas(entradas);
            n.Crearpesos();
            neuronas.add(n);

        }        
    }
    public void crearNeuronasSalida(int[] salidas)
    {
        
    }
}
