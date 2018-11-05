package backpropagation;

import javax.swing.JOptionPane;

public class main 
{
    public static void main(String[] args)
    {
    int n_capas_inter, neuronas_salida;
    double humbral;
    backpropagation back= new backpropagation();
   //Inicializar entradas y sus salidas deseadas.
    int []p1= {0,0,0};
    int []p2= {0,1,1};
    int []p3= {1,0,1};
    int []p4= {1,1,0};
    
    n_capas_inter= Integer.parseInt(JOptionPane.showInputDialog("Introduce en numero de neuronas que tiene la capa intermedia"));
    humbral= Integer.parseInt(JOptionPane.showInputDialog("Introduce el humbral de activación"));
    neuronas_salida= Integer.parseInt(JOptionPane.showInputDialog("Introduce el numer de neuronas de salida"));
    
    back.crear_neurona(p1, neuronas_salida,  n_capas_inter);
    
   
    
    
  
         
    }
    
}
