/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollo4;

import java.text.DecimalFormat;

/**
 *
 * @author lenovo
 */
public class Neurona {
    int[] entradas;
    double coeficiente;
    double salida,salidaDeseada,gradiante,error,umbral,pez;
    double[]pesos;
    
    public void Crearpesos()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        pesos=new double[entradas.length];
        for (int i = 0; i < pesos.length; i++)
            pesos[i]=Float.parseFloat( df.format( Math.random()) );
    }
    public void agregarEntradas(int[] enSaAnt)
    {
        entradas=enSaAnt;
    }
    public void evaluar()
    {
 
    }
    public void CalcularError()
    {
        
    }
    public void AjustarPesos()
    {
        
    }
    public void CrearEntradas(int nEntradas)
    {
        this.entradas=new int[nEntradas];
    }
    
}
