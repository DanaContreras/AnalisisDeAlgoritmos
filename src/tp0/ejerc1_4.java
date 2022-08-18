package tp0;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author dana.contreras
 */

public class ejerc1_4 {
    
    // Generar un archivo de texto con cadenas aleatorias de 10 caracteres alfanumericos (0-9, a-z, A-Z).
    
    static final String NOMBRE_ARCHIVO = "src/tp0_txt/cadenasAleatorias.txt";
    
    public static void main(String[] args) {
        
        char[] arrayCaracteres = generarCaracteres();
        generarArchivo(arrayCaracteres);
        
    }
    
    private static char[] generarCaracteres(){
        // Genera los caracteres validos para la generacion de cadenas.
        
        int i, letras = 26, dig = 0, max = letras*2, cant = 62;
        char ch = 'a';
        char[] caracter = new char[cant];
        
        for (i = 0; i < letras; i++){
            caracter[i] = ch;
            ch++;
        }
            
        ch = 'A';
        
        for (i = letras; i < max; i++){
            caracter[i] = ch;
            ch++;
        }
        
        ch = '0';
        
        for (i = max; i < cant; i++){
            caracter[i] = ch;
            ch++;
        }
        
        return caracter;
        
    }
    
    
    private static void generarArchivo(char[] arrayCaracteres){
        // Genera txt con cadenas aleatorias de caracteres alfanumericos.
        
        try{
    		BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
                Random generador = new Random();
                int i, max = arrayCaracteres.length, cantCh = 10, cantCadenas = generador.nextInt(50);
                char ch;
    		
    		for (i = 0; i < cantCadenas ; i++){
                    
                    for (int j = 0; j < cantCh; j++) {
                        ch = arrayCaracteres[generador.nextInt(max)];
    			buff.write(ch);
                    }
                    
                    buff.write("\n");
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
