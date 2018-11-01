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
    ArrayList<int[]>salidas=new ArrayList();
    public void entrenar()
    {
        for(int i=0;i<patronesEntrada.size();i++)
        {
            capas.get(0).valorEntrada(patronesEntrada.get(i));
            capas.get(capas.size()-1).crearNeuronasSalida( salidas.get(i) );
            
            
        }
        
    }
   public void arquitectura()
   {
       int[] entrada=patronesEntrada.get(0);
       int neuronasCapaAnterior=entrada.length;
       int neuronas=Integer.parseInt( JOptionPane.showInputDialog("cantidad de neuronas") ) ;
       this.AgragarCapa(neuronas,neuronasCapaAnterior);
       while (JOptionPane.showConfirmDialog(null, "otra capa interna")==1){
           neuronas=Integer.parseInt( JOptionPane.showInputDialog("cantidad de neuronas") ) ;
           this.AgragarCapa(neuronas,neuronasCapaAnterior);
           neuronasCapaAnterior=neuronas;
           
       }
       this.AgragarCapa(salidas.get(0).length,neuronasCapaAnterior);
       
   }
    public void AgragarCapa(int nNeuronas,int entradas)
    {
        //esto espara neuronas internas, se debe hacer antes de gragar la capa de salida
        Capa cn=new Capa();
        cn.crearNeuronas(nNeuronas,entradas);
        capas.add(cn);
    }
    
    
}
