/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pollo4;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Control {
    ArrayList<Capa> capas=new ArrayList<>();
    ArrayList<int[]>patronesEntrada=new ArrayList();
    int Nentradas,nsalidas;
    int[] salidas;
    public void entrenar()
    {
        
    }
   public void arquitectura()
   {
       int[] entrada=patronesEntrada.get(0);
       this.AgragarCapa(entrada.length);
       do {
           int neuronas=Integer.parseInt( JOptionPane.showInputDialog("cantidad de neuronas") ) ;
           this.AgragarCapa(neuronas);
       } while (JOptionPane.showConfirmDialog(null, "otra capa interna")==1);
       this.AgragarCapa(salidas.length);
       
   }
    public void AgragarCapa(int nNeuronas)
    {
        //esto espara neuronas internas, se debe hacer antes de gragar la capa de salida
        Capa cn=new Capa();
        cn.crearNeuronas(nNeuronas);
        capas.add(cn);
    }
    
}
