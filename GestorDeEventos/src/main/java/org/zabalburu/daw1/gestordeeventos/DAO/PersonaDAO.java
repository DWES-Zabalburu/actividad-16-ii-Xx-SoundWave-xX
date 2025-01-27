/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.DAO;

import java.util.List;
import org.zabalburu.daw1.gestordeeventos.modelo.Persona;

/**
 *
 * @author DAW1
 */
public interface PersonaDAO {
    Persona añadirPersona(Persona nueva);
    void eliminarPersona(int id);
    void modificarPersona(Persona modificar);
    List<Persona> getPersonas();
    Persona getPersona(int id);
    Persona getPersona(String dni);  
}
