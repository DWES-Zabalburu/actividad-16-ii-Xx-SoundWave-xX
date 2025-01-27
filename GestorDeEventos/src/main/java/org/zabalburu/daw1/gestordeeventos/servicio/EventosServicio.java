/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.servicio;

import java.util.GregorianCalendar;
import java.util.List;
import org.zabalburu.daw1.gestordeeventos.DAO.EventoDAO;
import org.zabalburu.daw1.gestordeeventos.DAO.EventoList;
import org.zabalburu.daw1.gestordeeventos.DAO.PersonaDAO;
import org.zabalburu.daw1.gestordeeventos.DAO.PersonaImpl;
import org.zabalburu.daw1.gestordeeventos.LoginException;
import org.zabalburu.daw1.gestordeeventos.modelo.Evento;
import org.zabalburu.daw1.gestordeeventos.modelo.Persona;

/**
 *
 * @author DAW1
 */
public class EventosServicio {
    private PersonaDAO personaDao = new PersonaImpl();
    private EventoDAO eventoDao = new EventoList();
    
    public EventosServicio(){
        personaDao.añadirPersona(new Persona("Juan","Lopez","12345678A","juan", new GregorianCalendar(1990,2,1).getTime()));
        personaDao.añadirPersona(new Persona("Ana","marin","12345678B","ana", new GregorianCalendar(1993,2,1).getTime()));
        personaDao.añadirPersona(new Persona("Carlos","Martin ","12345678C","carlos", new GregorianCalendar(1990,1,15).getTime()));
        personaDao.añadirPersona(new Persona("Eva","Sanz","12345678D","eva", new GregorianCalendar(1989,0,11).getTime()));
        personaDao.añadirPersona(new Persona("Luisa","Simon","12345678E","luisa", new GregorianCalendar(1992,2,23).getTime()));
        personaDao.añadirPersona(new Persona("Miguel","De Miguel","12345678F","miguel", new GregorianCalendar(1978,4,13).getTime()));
        personaDao.añadirPersona(new Persona("Sonia","Lucas","12345678G","sonia", new GregorianCalendar(1995,11,21).getTime()));
        eventoDao.añadirEvento(new Evento("Evento Uno",new GregorianCalendar(2025,1,21).getTime(),"Bilbao", true,50));
        eventoDao.añadirEvento(new Evento("Evento Dos",new GregorianCalendar(2025,5,10).getTime(),"Santutxu", true,55));
        eventoDao.añadirEvento(new Evento("Evento Tres",new GregorianCalendar(2025,2,7).getTime(),"Donosti", false,70));
        eventoDao.añadirEvento(new Evento("Evento Cuatro",new GregorianCalendar(2025,12,11).getTime(),"Barakaldo", true,30));
        this.apuntarAEvento(2, 3);
        this.apuntarAEvento(3, 2);
        this.apuntarAEvento(4, 1);
        
    }
    
    public Persona añadirPersona(Persona nueva){
        return personaDao.añadirPersona(nueva);
    }
    public void eliminarPersona(int id){
        personaDao.eliminarPersona(id);
    }
    
    public void modificarPersona(Persona modificar){
        personaDao.modificarPersona(modificar);
    }
    public List<Persona> getPersonas(){
        return personaDao.getPersonas();
    }
    Persona getPersona(int id){
        return personaDao.getPersona(id);
    }
    
    public Evento añadirEvento(Evento nuevo){
        return eventoDao.añadirEvento(nuevo);
    }
    void eliminarEvento(int id){
        eventoDao.eliminarEvento(id);
    }
    
    void modificarEvento(Evento evento){
        eventoDao.modificarEvento(evento);
    }
    
    public List<Evento> getEvento(){
        return eventoDao.getEvento();
    }
    
    public Evento getEvento(int id){
        return eventoDao.getEvento(id);
    }
    
    public Persona login(String dni , String password)throws LoginException{
        boolean ok = false;
        Persona p = personaDao.getPersona(dni);
        if(p != null && password.equals(p.getPassword())){
            return p;
        }
        throw new LoginException();
    }
    
    public boolean apuntarAEvento(int idPersona, int idEvento){
        Persona p = personaDao.getPersona(idPersona);
        Evento e = eventoDao.getEvento(idEvento);
        if (p!= null && e != null){
            e.getAsistentes().add(p);
            p.getEventos().add(e);
            return true;
        }
        return false;
    }
    
    public void desapuntarAEvento(int idPersona,int idEvento){
        Persona p = personaDao.getPersona(idEvento);
        Evento e = eventoDao.getEvento(idEvento);
        if (e != null && p != null){
            e.getAsistentes().remove(p);
            p.getEventos().remove(e);
        }     
    }
    
    public static void main(String[] args) {
        EventosServicio servicio = new EventosServicio();
        for (Persona p : servicio.getPersonas()){
            System.out.println(p);
        }
        for (Evento e : servicio.getEvento()){
            System.out.println(e);
        }
    }
}
