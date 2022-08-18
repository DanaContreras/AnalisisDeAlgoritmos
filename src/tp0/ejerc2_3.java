package tp0;

import java.util.Scanner;

/**
 *
 * @author dana
 */

public class ejerc2_3 {
    
    // Realizar un programa que nos pida un numero n y nos diga cuantos numeros primos existen entre 1 y n.
    
    public static void main(String[] args) {
        
        int n;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese un numero entero.");
        n = teclado.nextInt();
        
        System.out.println("Hay " + contarNumPrimos(n) + " numeros primos entre 1 y " + n);
    }
    
    private static int contarNumPrimos(int max) {
        
        int i, n, cant = 0;
        
        for (i = 2; i < max; i++) {
            
            n = 2;
            
            while ((n < i) && ((i % n) != 0))
                n++;
            
            if (n == i)
                cant++;
        }
        
        return cant;
    }
   
}
