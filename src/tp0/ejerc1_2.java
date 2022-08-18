package tp0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dana.contreras
 */

public class ejerc1_2 {
    
    // Con un archivo de entrada, generar el archivo lineasImpares.txt con solo las lineas impares del texto.
    
    static final String ARCHIVO_ENTRADA = "src/tp0_txt/entrada.txt";
    static final String ARCHIVO_SALIDA = "src/tp0_txt/lineasImpares.txt";
    
    public static void main(String[] args) {
        
        int n = 1;
        String linea;
        
        try {
            
            FileReader lectorArchivo = new FileReader(ARCHIVO_ENTRADA);
            FileWriter escritorArchivo = new FileWriter(ARCHIVO_SALIDA);

            
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            while ((linea = bufferLectura.readLine()) != null) {
                
                if (n%2 != 0) {
                    System.out.println(linea);
                    bufferEscritura.write(linea + "\n");
                }
                
                n++;
               
            }

            bufferLectura.close();
            bufferEscritura.close();
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
