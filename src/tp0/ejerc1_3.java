package tp0;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import Utiles.Aleatorio;

/**
 *
 * @author dana.contreras
 */

public class ejerc1_3 {
    
    // Generar un archivo de texto que contenga 100 numeros reales (double o float) generados aleatoriamente con valores -100 y 100.
    
    static final String NOMBRE_ARCHIVO = "src/tp0_txt/realesRandom.txt";
    
    public static void main(String[] args) {
        
        try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		
                int min = -100, max = 100;
                double num;
                Aleatorio generador = new Aleatorio();
                
                for (int i = 0; i < max; i++){
                    
                    num = generador.doubleAleatorio(min,max);
                    buff.write( num +"\n");
                    System.out.println(num);
                    
                } 

    		buff.close();

    	}
    	catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        
    }
    
}
