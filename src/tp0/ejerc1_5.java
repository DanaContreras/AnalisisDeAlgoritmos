package tp0;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import Utiles.Aleatorio;

/**
 *
 * @author dana.contreras
 */

public class ejerc1_5 {
    
    // Generar un archivo con numeros aleatorios de los numeros del 1 al 1000 sin que los elementos se repitan.
    
    static final String NOMBRE_ARCHIVO = "src/tp0_txt/numerosAleatorios.txt";
    
    public static void main(String[] args) {
        
        generarArchivo();
        
    }
    
    private static void generarArchivo(){
        
    	try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
    		Aleatorio generador = new Aleatorio();
                int j, num, cant = 1000;
                ArrayList<Integer> listNumAleatorios = new ArrayList();
               
    		while (listNumAleatorios.size() != cant){
                    
                    num = generador.intAleatorio(1,cant);
                    
                    if (!listNumAleatorios.contains(num)){
                        
                        listNumAleatorios.add(num);
                        buff.write( num +"\n");
                        System.out.println(num);
                        
                    }
                  
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
