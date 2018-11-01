/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pollo4;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Kohonen {
    double[][] pesos;
    double[][] entradas;
    int salidas;
    double pez;
    public void EntradaTajo(double [][] entradaa)
    {
        entradas=entradaa;
    }
    public void CrearPesos()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        pesos=new double[salidas][entradas[0].length];
        for (int i = 0; i < pesos.length; i++)
            for (int j = 0; j < pesos[0].length; j++)
                pesos[i][j]=Float.parseFloat( df.format( Math.random()) );
    }
    public double[] pesoVencedor(double[] entrada)
    {
        double  dis=0,disMin;
        int salidaVen=0;
        for (int i = 0; i <pesos[0].length; i++)
            dis+=Math.pow(entrada[i]-pesos[0][i], 2);
        
        disMin=dis;
        salidaVen=0;
        for (int j = 1; j < 10; j++) {
            dis=0;
            for (int i = 0; i < 10; i++) 
                dis+=Math.pow(entrada[i]-pesos[j][i], 2);
            if(dis<disMin)
            {
                disMin=dis;
                salidaVen=j;
            }
        }
        return pesos[salidaVen];
    }
    public void ajustarPesos(double[] pesoSalida,double[] entrada)
    {
        for (int i = 0; i < pesoSalida.length; i++)
            pesoSalida[i]+=pez*(entrada[i]- pesoSalida[i]);
    }
    public void aprender()
    {
        this.CrearPesos();
        
        //ciclo
        for (double[] entrada:entradas) {
            this.ajustarPesos(this.pesoVencedor(entrada), entrada);
        }
    }
}
