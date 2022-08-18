package TP0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class punto2_9 {
    static int [] A = new int [100];
    static int [] B = new int [60];
    static int [] C = new int [160];
    
   
    private static int[] generarLista(int cantidad){
        int [] lista = new int [cantidad];
        Random generador = new Random();
        for(int i = 0; i<cantidad;i++){
            int num = generador.nextInt(200);
            lista[i]=num;
        }
        return lista;
    }

    public static void mergeSort(int[ ] matrix, int init, int n){
        int n1;
        int n2;
        if (n > 1){
            n1 = n / 2;
            n2 = n - n1;
            mergeSort(matrix, init, n1);
            mergeSort(matrix, init + n1, n2);
            merge(matrix, init, n1, n2);
       }
    }

    private static void merge(int[ ] matrix, int init, int n1, int n2){
        int[ ] buffer = new int[n1+n2];
        int temp = 0;
        int temp1 = 0;
        int temp2 = 0;
        int i;
        while ((temp1 < n1) && (temp2 < n2)){
            if (matrix[init + temp1] < matrix[init + n1 + temp2]){
                buffer[temp++] = matrix[init + (temp1++)];
            }else{
                buffer[temp++] = matrix[init + n1 + (temp2++)];
            }
        }
        while (temp1 < n1){
            buffer[temp++] = matrix[init + (temp1++)];
        }
        while (temp2 < n2){
            buffer[temp++] = matrix[init + n1 + (temp2++)];
        }
        for (i = 0; i < n1+n2; i++){
            matrix[init + i] = buffer[i];
        }
    }

    private static int particion(int arreglo[], int izquierda, int derecha) {
        int pivote = arreglo[izquierda];
        // Ciclo infinito
        while (true) {
            while (arreglo[izquierda] < pivote) {
                izquierda++;
            }
            while (arreglo[derecha] > pivote) {
                derecha--;
            }
            if (izquierda >= derecha) {
                return derecha;
            } else {
                int temporal = arreglo[izquierda];
                arreglo[izquierda] = arreglo[derecha];
                arreglo[derecha] = temporal;
                izquierda++;
                derecha--;
            }
        }
    }

    private static void quicksort(int arreglo[], int izquierda, int derecha) {
        if (izquierda < derecha) {
            int indiceParticion = particion(arreglo, izquierda, derecha);
            quicksort(arreglo, izquierda, indiceParticion);
            quicksort(arreglo, indiceParticion + 1, derecha);
        }
    }

    public static void main(String[] args) {
        A=generarLista(100);
        B=generarLista(60);
        
        quicksort(A,0,A.length-1);
        mergeSort(B,0,B.length);
       
        
       for(int i=0;i<A.length;i++){
            C[i]=A[i];
       }
       for(int i=0;i<B.length;i++){
            C[A.length+i]=B[i];
        }
        quicksort(C,0,C.length-1);
        
        
        for(int i=0;i<C.length;i++){
            System.out.print(C[i]+" ");
        }
        System.out.println("");
    }
}
