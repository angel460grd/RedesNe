/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pollo4;

import java.util.ArrayList;

public class Control {
    ArrayList<Capa> capas=new ArrayList<>();
    ArrayList<int[]>patronesEntrada=new ArrayList();
    int entradas,salidas;
    
    double coeficiente;
    double salidaobtenida,salidaDeseada,gradiante,error,umbral,pez;
    double[]pesos;
    public void entrenar()
    {
        
    }
    public void AgragarCapa()
    {
        
    }
    
    public void AjustarPesos(  )
    {
        //Para sacar el gradiante
        Neurona n = new Neurona();
       error= n.CalcularError();
       int contador =0;
       if(contador==0)
       {
           gradiante=salidaobtenida* (1-salidaobtenida)*error;
           contador=1;
       }
       else 
       {
           
       }
        
        
    }
    
    
}
