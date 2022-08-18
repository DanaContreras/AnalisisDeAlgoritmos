package tp0;

import java.util.Scanner;
import Utiles.Aleatorio;

/**
 *
 * @author dana
 */

public class ejerc2_4 {

    // Realizar un juego para adivinar un numero: Generar un numero entero en forma aleatoria dentro de un rango, y luego, ir pidiendo numeros indicando  ́ mayor o menor segun sea mayor o menor con respecto a n. El proceso termina cuando el usuario acierta.
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Aleatorio generador = new Aleatorio();
        
        int min = 0, max = 10, num;
        int res = generador.intAleatorio(min,max);
        boolean seguir = true;
        
        while (seguir){
            
            System.out.println("Ingrese un numero entre " + min + " y " + max);
            num = teclado.nextInt();
          
            if (num == res){
                System.out.println("Adivinaste! La respuesta era: " + res);
                 seguir = false;
            }
            else if(num > res)
                System.out.println("El numero es menor a " + num);
            else {
                 System.out.println("El numero es mayor a " + num);
            }
               
        }

    }
   
}
