package pollo4;
import java.text.DecimalFormat;
import static javax.swing.text.html.HTML.Tag.HEAD;
public class Neurona {
    int[] entradas;
    double coeficiente;

    

    public double salida,salidaDeseada,gradiante,error,umbral,pez;

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
    public void CrearEntradas(int nEntradas)
    {
        this.entradas=new int[nEntradas];
    }
    public void caluloGradinateH(float GradianteAcum)
    {
        gradiante=salida*(1-salida)* GradianteAcum;
    }
    public void caluloGradinateS()
    {
        gradiante=salida*(1-salida)*(salidaDeseada-salida);
    }
}
