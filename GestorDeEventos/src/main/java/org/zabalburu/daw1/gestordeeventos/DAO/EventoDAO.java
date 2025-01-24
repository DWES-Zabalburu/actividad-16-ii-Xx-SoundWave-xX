/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.DAO;

import java.util.List;
import org.zabalburu.daw1.gestordeeventos.modelo.Evento;

/**
 *
 * @author DAW1
 */
public interface EventoDAO {
    Evento añadirEvento(Evento nuevo);
    void eliminarEvento(int id);
    void modificarEvento(Evento evento);
    List<Evento> getEvento();
    Evento getEvento(int id);
    
}
