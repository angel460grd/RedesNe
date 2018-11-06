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
    public ArrayList<Neurona> neuronas=new ArrayList<>();
    public void crearNeuronas(int nNeuronas,int entradas)
    {
        for (int i = 0; i < nNeuronas; i++){
            Neurona n=new Neurona();
            n.CrearEntradas(entradas);
            n.Crearpesos();
            neuronas.add(n);
     
        }        
    }
    public void crearNeuronasSalida(double[] salidas)
    {
        
    }
    public void valorEntrada(double[] entradas)
    {        
        for (Neurona n:neuronas)
            n.agregarEntradas(entradas);
    }
    public void valorSalida(double[] salidas)
    {        
        for (int i = 0; i < neuronas.size(); i++) {
            neuronas.get(i).salidaDeseada=salidas[i];
        }
            
    }
    public void NeuronasGradinateH(Capa Anterior)
    {
        for (int i = 0; i < neuronas.size(); i++) {
            int gradianteAcum=0;
            for (Neurona nca : Anterior.neuronas) {
                gradianteAcum+=nca.gradiante*nca.pesos[i];
            }
            neuronas.get(i).caluloGradinateH(gradianteAcum);
        }
    }
    public void NeuronasGradinateS()
    {
        for(Neurona nS:neuronas)
            nS.caluloGradinateS();
    }
    public void ajustarPesosN()
    {
        for(Neurona n:neuronas)
            n.ajustarPesos();
    }
    public void evaluarN()
    {
        for(Neurona n:neuronas)
            n.evaluar2();
        
    }
      public void agregarEn(Capa Ant)
    {
        double[] entrada=new double[Ant.neuronas.size()];
        for (int i = 0; i < entrada.length; i++)
            entrada[i]=Ant.neuronas.get(i).salida;
        for (Neurona n:neuronas)
            n.agregarEntradas(entrada);
    }
    public boolean aprendio(double errorA)
    {
        for(Neurona n:neuronas)
        {    
            if(Math.abs( n.CalcularError())>errorA)
            {
                System.out.println(n.CalcularError());
                return false;
            }
            System.out.println(n.CalcularError());
        }
        return true;
    }
}
