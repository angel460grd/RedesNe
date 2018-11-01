/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pollo4;

/**
 *
 * @author lenovo
 */
public class Pollo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        hopfield p=new hopfield();
//        int[] x1={1, 1, 1,-1};
//        int[] x2={-1,-1,-1,1};
//        int[]lumbral={0,0,0,0};
//        int[] a={-1, -1, -1 ,-1};
//        p.tamanioP=x1.length;
//        p.lumbralA=lumbral;
//        p.AgregarPatron(x1);
//        p.AgregarPatron(x2);
//        
//        p.ajustarPesos();
//        for (int i = 0; i < p.tamanioP; i++) {
//            System.out.println();
//            for (int j = 0; j < p.tamanioP; j++)
//                System.out.print(p.pesos[i][j]+" ");
//            
//        }
//            System.out.println();
//        for(int i:p.evaluar(a))
//           System.out.print(i+",");
        Kohonen k=new Kohonen();
       
        double[][] entradas=new double[4][];
         entradas[0]=new double[]{0.5, 0.1};
         entradas[1]=new double[]{0.3, 0.6}; 
         entradas[2]=new double[]{0.4, 0.7}; entradas[3]=new double[]{0.3, 1.0};
         k.salidas=2;
         k.EntradaTajo(entradas);
         k.CrearPesos();
        

    }
    
}
