/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.DAO;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.gestordeeventos.modelo.Persona;

/**
 *
 * @author DAW1
 */
public class PersonaImpl implements PersonaDAO {
    
    private static Persona[] personas = new Persona[100];
    private static int numPersonas = 0;
    
    

    @Override
    public Persona añadirPersona(Persona nueva) {
        if(numPersonas < personas.length){
            personas[numPersonas] = nueva;
            numPersonas++;
        }
        return nueva;
    }

    @Override
    public void eliminarPersona(int id) {
        int i = buscarPosicionPersona(id);
        if (i != -1){
            for(i=i+1; i < numPersonas; i++){
                personas[i-1] = personas[i];
            }
            numPersonas--;
        }
    }

    @Override
    public void modificarPersona(Persona modificar) {
        int pos = buscarPosicionPersona(modificar.getId());
        if (pos != -1){
            personas[pos] = modificar;
        }
        
    }

    @Override
    public List<Persona> getPersonas() {
        List<Persona> temp = new ArrayList<>();
        for (int i = 0; i<numPersonas; i++){
            temp.add(personas[i]);
        }
        return temp;
    }

    @Override
    public Persona getPersona(int id) {
        int pos = buscarPosicionPersona(id);
        if(pos != -1){
            return personas[pos];
        }else {
            return null;
        }
    }

    @Override
    public Persona getPersona(String dni) {
        int i;
        for (i= 0; i<numPersonas &&
                !dni.equalsIgnoreCase(dni);i++);
        return (i == numPersonas)?null:personas[i];
    }
    
    private int buscarPosicionPersona(int id){
        int i;
        for(i=0; i<numPersonas && 
            id != personas[i].getId(); i++);
        if (i < numPersonas){
            return i;
        }else {
            return -1;
        }
    }
    
    public void limpiarDatos(){
        personas = new Persona[100];
        numPersonas = 0;
    }
}
