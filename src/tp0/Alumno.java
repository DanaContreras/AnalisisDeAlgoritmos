package tp0;

import java.util.*;

/**
 *
 * @author dana
 */

public class Alumno {
    
    private String legajo;
    private String nombre;
    private ArrayList<Double> notas;
    
    // Constructor
    Alumno (String legajo, String nombre){
        this.legajo = legajo;
        this.nombre = nombre;
        this.notas = new ArrayList();
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo (String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getNotas (){
        return (ArrayList<Double>) this.notas.clone();
    }
    
    public boolean agregarNota (double nota) {
        return this.notas.add(nota);
    }

    public boolean eliminarNota (int pos){
        this.notas.remove(pos);
        return true;
    }
    
    public String toString(){
        return "\nLegajo: " + legajo + "\nNombre: " + nombre + "\nNotas: " + notas.toString();
    }
}
