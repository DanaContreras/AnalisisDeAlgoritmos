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

public class ejerc1_1 {
    
    // Generar  ́ sinEspacios.txt eliminando todos los espacios en blanco de un archivo.
    
    static final String ARCHIVO_ENTRADA = "src/tp0_txt/entrada.txt";
    static final String ARCHIVO_SALIDA = "src/tp0_txt/sinEspacios.txt";
    
    public static void main(String[] args) {
        
        String linea, res;
        
        try {
            
            FileReader lectorArchivo = new FileReader(ARCHIVO_ENTRADA);
            FileWriter escritorArchivo = new FileWriter(ARCHIVO_SALIDA);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            while ((linea = bufferLectura.readLine()) != null){
                
                res = linea.replaceAll("\\s","");
                
                if (!res.equals(""))
                    res += "\n";
   
                bufferEscritura.write(res);
                System.out.print(res);
                
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
