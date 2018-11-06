/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pollo4;

import java.util.ArrayList;

public class Control {
    ArrayList<Capa> capas=new ArrayList<>();
    ArrayList<double[]>patronesEntrada=new ArrayList(),salidas2=new ArrayList<>();
    int entradas,salidas;
    
    double coeficiente;
    double salidaobtenida,salidaDeseada,gradiante,error,umbral,pez;
    double[]pesos;
    
    int nEntradas,nSalidas;
    public void entrenar()
    {
        
    }
    public void AgragarCapa()
    {
        
    }
    
    public void AjustarPesos(  )
    {
        
        
        
        for(int i=0; i<0;i++)
        {
            
        }   
     
        
        
        
        
        
    }
       public void arquitectura()
   {
       double[] entrada=patronesEntrada.get(0);
       int nNeuronas=entrada.length,nCapas=(int) Math.sqrt(nEntradas*nSalidas);
            this.AgragarCapa(nNeuronas,nNeuronas);
       for (int i = 1; i < nCapas; i++) {
           this.AgragarCapa(nNeuronas+2,nNeuronas);
           nNeuronas=nNeuronas+2;
       }
       this.AgragarCapa(salidas2.get(0).length,nNeuronas);
       
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
        //Para sacar el gradiante
        Neurona n = new Neurona();
        error= n.CalcularError();
       
    }
    public void entrenar2()
    {
        for(int i=0;i<patronesEntrada.size();i++)
        {
            capas.get(0).valorEntrada(patronesEntrada.get(i));
            capas.get(capas.size()-1).valorSalida(salidas2.get(i) );
            this.sacarGradante();
            this.evaluar();
            this.AjustarPesos();
            
        }
        
    }
    public void evaluar()
    {
       capas.get(0).evaluarN();
       
        for (int i = 1; i < capas.size(); i++) {
            capas.get(i).agregarEn(capas.get(1-1));
            capas.get(i).evaluarN();
        }
    }
    public void ajuste()
    {
        for(Capa c:capas)
            c.ajustarPesosN();
    }
}
