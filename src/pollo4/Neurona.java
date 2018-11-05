package pollo4;
import java.text.DecimalFormat;
public class Neurona {
    int[] entradas;
    double coeficiente;
    double salidaobtenida,salidaDeseada,gradiante,error,umbral,pez;
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
    //Error
    public double CalcularError()
    {
       error=salidaDeseada-salidaobtenida;
       return error;
    }
    
    
}
