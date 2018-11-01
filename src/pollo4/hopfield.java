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
public class hopfield {
    public ArrayList<int[]> patrones =new ArrayList<>();
    public int tamanioP=0;
    int[][]pesos;
    int[]lumbralA;
    public void AgregarPatron(int [] patron)
    {
        patrones.add(patron);
    }
    public void ajustarPesos()
    {
        pesos=new int[tamanioP][tamanioP];
        for(int[] patron:patrones)
        {
            int[][] matrizAux=new int[tamanioP][tamanioP];
            for (int i = 0; i < patron.length; i++)
                for (int j = 0; j < patron.length; j++) 
                    matrizAux[i][j]=patron[i]*patron[j];
            for (int i = 0; i < tamanioP; i++) 
                for (int j = 0; j < tamanioP; j++)
                    pesos[i][j]+=matrizAux[i][j];
        }
        for (int i = 0; i < tamanioP; i++)
            pesos[i][i]=0;
    }
    
    public int[] evaluar (int[]patron)
    {
        int []patronAux,patronAnt=patron;
        boolean patronCercano;
        do
        {
            patronAux=new int [tamanioP];
            for (int i = 0; i < tamanioP; i++)
                patronAux[i]=0;
            
            patronCercano=true;
            for (int i = 0; i < tamanioP; i++) {
                for (int j = 0; j < tamanioP; j++)
                    patronAux[i]+=patronAnt[j]*pesos[j][i];
                patronAux[i]-=lumbralA[i];
                if(patronAux[i]>1)
                    patronAux[i]=1;
                else if(patronAux[i]<-1)
                    patronAux[i]=-1;
               
            }
            
            for (int i = 0; i < tamanioP; i++)
            {
                if(patronAux[i]!=patronAnt[i])
                {
                    patronCercano=false;
                    patronAnt=patronAux;
                    break;
                }
                
            }    
        }while(patronCercano==false);
        return patronAnt;
    }
}
