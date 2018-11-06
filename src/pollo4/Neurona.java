package pollo4;

import java.text.DecimalFormat;
import static javax.swing.text.html.HTML.Tag.HEAD;

public class Neurona {

    double[] entradas;
    double coeficiente;

    public double salida, salidaDeseada, gradiante, error, umbral=1, pez=0.6;

    double[] pesos;

    public Neurona() {
        DecimalFormat df = new DecimalFormat("#.##");
        umbral= Float.parseFloat(df.format(Math.random()*10));
    }

    public void Crearpesos() {
        DecimalFormat df = new DecimalFormat("#.##");
        pesos = new double[entradas.length];
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] = Float.parseFloat(df.format(Math.random()*10));
        }
    }

    public void agregarEntradas(double[] enSaAnt) {
        entradas = enSaAnt;
    }

    public void evaluar() {

    }

    //Error
    public double CalcularError() {
        error = salidaDeseada - salida;
        return error;
    }

    public void CrearEntradas(int nEntradas) {
        this.entradas = new double[nEntradas];
    }

    public void caluloGradinateH(float GradianteAcum) {
        gradiante = salida * (1 - salida) * GradianteAcum;
    }

    public void caluloGradinateS() {
        gradiante = salida * (1 - salida) * (salidaDeseada - salida);
    }

    public void evaluar2() {
        salida = 0;
        for (int i = 0; i < entradas.length; i++) {
            salida += entradas[i] * pesos[i]-umbral;
        }
        salida = salida - umbral;
        salida = 1 / (1 + Math.exp(-salida));
    }

    public void ajustarPesos() {
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] += pez * entradas[i] * gradiante;
        }
    }
    public void datos()
    {
        String l="";
        for(double i:entradas)
            l+=i+" ";
        System.out.println(l+" "+salida+" "+salidaDeseada+" "+error);
    }
}
