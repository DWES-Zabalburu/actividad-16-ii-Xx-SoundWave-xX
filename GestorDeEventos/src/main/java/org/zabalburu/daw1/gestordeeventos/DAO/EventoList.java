/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.DAO;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.gestordeeventos.modelo.Evento;

/**
 *
 * @author DAW1
 */
public class EventoList implements EventoDAO{
    
    private static List<Evento> eventos = new ArrayList<Evento>();

    @Override
    public Evento añadirEvento(Evento nuevo) {
        eventos.add(nuevo);
        return nuevo;
    }

    @Override
    public void eliminarEvento(int id) {
        Evento e = new Evento();
        e.setId(id);
        eventos.remove(e);
    }

    @Override
    public void modificarEvento(Evento evento) {
        int pos = eventos.indexOf(evento);
        if (pos != -1){
            eventos.set(pos, evento);
        }
        
    }

    @Override
    public List<Evento> getEvento() {
        return eventos;
    }

    @Override
    public Evento getEvento(int id) {
        Evento evt = new Evento();
        evt.setId(id);
        int pos = eventos.indexOf(evt);
        if (pos != -1){
            return eventos.get(pos);
        }else {
            return null;
        }
    }
}
