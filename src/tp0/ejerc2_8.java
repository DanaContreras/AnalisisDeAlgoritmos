package tp0;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ejerc2_8 {
    
    static final String NOMBRE_ARCHIVO = "src/tp0_txt/listaAlumnos.txt";
    
    public static void main(String[] args) {
    
        ArrayList<Alumno> listAlumnos = cargarAlumnos();
        iniciarMenu(listAlumnos);
        
    }
    
    private static ArrayList<Alumno> cargarAlumnos(){
        
        ArrayList<Alumno> listAlumnos = new ArrayList();
        
        try{
    		BufferedReader buff = new BufferedReader(new FileReader(NOMBRE_ARCHIVO));
    		
                String linea;
                StringTokenizer st;
                Alumno alum;
                
    		while((linea = buff.readLine()) != null){
                    
                    // Se crea un alumno con los datos obtenidos de la linea del archivo.
                    st = new StringTokenizer(linea);
                    alum = new Alumno(st.nextToken(),st.nextToken());
                
                    while (st.hasMoreTokens())
                        alum.agregarNota(Double.parseDouble(st.nextToken()));
                   
                    listAlumnos.add(alum);
                    System.out.println(alum.toString());
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
        
        return listAlumnos;
    }

    private static void iniciarMenu (ArrayList<Alumno> listAlumnos){
        
        Scanner teclado = new Scanner(System.in);
        
        int opcion;
        
        System.out.println("\n-------------------------------------------------");
        System.out.println("Menu");
        System.out.println("-------------------------------------------------");
        System.out.println("(1) Calcular media de los alumnos.");
        System.out.println("(2) Calcular media de asignaturas.");
        System.out.println("(3) Calcular media total de la clase.");
        System.out.println("(4) Ordenar listado de alumnos por notas medias. (Mergesort)");
        System.out.println("(5) Ordenar listado de alumnos por notas medias. (Quicksort)");
        System.out.println("-------------------------------------------------");
     
        opcion = teclado.nextInt();
        
        switch (opcion){
            case 1: calcularMediaALumnos(listAlumnos);
                    break;
            
            case 2: mostrarMediaAsig(calcularMediaAsig(listAlumnos));
                    break;
            
            case 3: calcularMediaTotal(listAlumnos);
                    break;
            
            case 4: mergeSort(listAlumnos,0,listAlumnos.size()-1);
                    System.out.println(listAlumnos);
                    break;
                    
            case 5: quickSort(listAlumnos,0,listAlumnos.size()-1);
                    System.out.println(listAlumnos);
                    break;
        }
        
    }
    
    private static void calcularMediaALumnos(ArrayList<Alumno> listAlumnos){
        // Calcula el promedio de notas de cada alumno.
        
        int i, max = listAlumnos.size();
        Alumno alum;
        
        for (i = 0; i < max; i++) {
            
            alum = listAlumnos.get(i);
            System.out.println("Legajo: " + alum.getLegajo() + " - Promedio: " + calcularMedia(alum.getNotas()));
            
        }
    }
    
    private static double calcularMedia (ArrayList lista){
        
        Iterator<Double> it = lista.iterator();
        double media = 0;
        
        while (it.hasNext())
            media += it.next();
        
        return media / lista.size();
    }

    private static ArrayList<Double> calcularMediaAsig (ArrayList<Alumno> listAlumnos){
        // Calcula la media de cada asignatura segun cantidad de alumnos.
        
        int i = 0;
        double suma, media;
        boolean seguir = true;
        Alumno alum;
        ArrayList<Double> notas = new ArrayList();
        ArrayList<Double> asig = new ArrayList();
        Iterator<Double> itNotas, itAsig;
        Iterator<Alumno> it = listAlumnos.iterator();
        
        while(it.hasNext()){
            
            // Se obtiene las notas del alumno actual.
            alum = it.next();
            notas = alum.getNotas();
            itNotas = notas.iterator();
            
            // Se suma la nota de cada asignatura segun su posicion.
            while(itNotas.hasNext() && seguir){
                
                if (asig.isEmpty()){
                    asig = notas;
                    seguir = false;
                }
                else{
                    suma = asig.get(i) + itNotas.next();
                    asig.set(i, suma);
                    i++;
                }
        
            }
            
            i = 0;
            seguir = true;
        }
        
        itAsig = asig.iterator();
        
        while (itAsig.hasNext()){
            
            media = itAsig.next() / notas.size();
            asig.set(i,media);
            
            i++;
        }
        
        return asig;
        
    }

    private static void mostrarMediaAsig (ArrayList<Double> asig){
        
        // Se muestra por pantalla.
        
        int i = 0;
        Iterator<Double> itAsig = asig.iterator();
        
        while (itAsig.hasNext()){
            
            System.out.println("Materia " + (i+1) + ": " + itAsig.next());
            i++;
        }
        
    }
    
    private static void calcularMediaTotal (ArrayList<Alumno> listAlumnos){
        // Calcula media total de la clase en base a la asignaturas.
        
        double suma = 0;
        ArrayList<Double> promedio = calcularMediaAsig(listAlumnos);
        Iterator<Double> it = promedio.iterator();
        
        while(it.hasNext())
            suma += it.next();
       
        System.out.println("Media total: " +(suma / promedio.size()));
        
    }
    
    private static void mergeSort (ArrayList<Alumno> lista, int izq, int der){
        
        if (izq < der) {

            int mitad = (izq + der) / 2;

            mergeSort(lista, izq, mitad);
            mergeSort(lista, mitad + 1, der);

            // Mezcla de sublistas
            merge(lista, izq, mitad, der);
        }
        
    }
    
    private static void merge (ArrayList<Alumno> lista, int izq, int m, int der){

        int n1 = m - izq + 1;
        int n2 = der - m;

        ArrayList<Alumno> listaIzq = new ArrayList();
        ArrayList<Alumno> listaDer = new ArrayList();

        // Se genera lista izq y der
        for (int i = 0; i < n1; i++)
            listaIzq.add(lista.get(izq + i));

        for (int j = 0; j < n2; j++)
            listaDer.add(lista.get(m + 1 + j));

        int i = 0, j = 0, k = izq;
       
        while (i < n1 && j < n2) {

            if (calcularMedia(listaIzq.get(i).getNotas()) <= calcularMedia(listaDer.get(j).getNotas())) {
                lista.set(k, listaIzq.get(i));
                i++;
            } else {
                lista.set(k, listaDer.get(j));
                j++;
            }

            k++;
        }

        while (i < n1) {
            lista.set(k, listaIzq.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            lista.set(k, listaDer.get(j));
            j++;
            k++;
        }
        
    }

    private static int particion (ArrayList<Alumno> lista, int izq, int der) {

        double pivote = calcularMedia(lista.get(izq).getNotas());
        boolean seguir = true;

        while (seguir) {

            while (calcularMedia(lista.get(izq).getNotas()) < pivote)
                izq++;

            while (calcularMedia(lista.get(der).getNotas()) > pivote) {
                der--;
            }

            if (izq >= der) 
                seguir = false;
            else {
                Alumno temp = lista.get(izq);
                lista.set(izq, lista.get(der));
                lista.set(der, temp);
                izq++;
                der--;
            }
        }

        return der;
    }

    private static void quickSort(ArrayList<Alumno> lista, int izq, int der) {
        
        if (izq < der) {
            int indice = particion(lista, izq, der);
            quickSort(lista, izq, indice);
            quickSort(lista, indice + 1, der);
        }

    }
    
}
