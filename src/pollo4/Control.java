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
    int nEntradas,nSalidas;
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
       int nNeuronas=entrada.length,nCapas=(int) Math.sqrt(nEntradas*nSalidas);
            this.AgragarCapa(nNeuronas,nNeuronas);
       for (int i = 1; i < nCapas; i++) {
           this.AgragarCapa(nNeuronas+2,nNeuronas);
           nNeuronas=nNeuronas+2;
       }
       this.AgragarCapa(salidas.get(0).length,nNeuronas);
       
   }
    public void AgragarCapa(int nNeuronas,int entradas)
    {
        //esto espara neuronas internas, se debe hacer antes de gragar la capa de salida
        Capa cn=new Capa();
        cn.crearNeuronas(nNeuronas,entradas);
        capas.add(cn);
    }
    public void sacarGradante()
    {
        Capa capaAnt= capas.get(capas.size()-1);
        capaAnt.NeuronasGradinateS();
        for (int i = capas.size()-2; i>=0; i--) {
            capas.get(i).NeuronasGradinateH(capaAnt);
            capaAnt=capas.get(i);
        }
    }
    
}
