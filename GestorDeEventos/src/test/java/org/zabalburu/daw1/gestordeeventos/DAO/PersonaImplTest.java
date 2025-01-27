/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.DAO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.zabalburu.daw1.gestordeeventos.modelo.Persona;

/**
 *
 * @author DAW1
 */
public class PersonaImplTest {
    
    private PersonaImpl dao = new PersonaImpl();
    
    public PersonaImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        dao.limpiarDatos();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of añadirPersona method, of class PersonaImpl.
     */
    @Test
    public void testAñadirPersona() {
        Persona p = new Persona("Juan","Lopez","12345678A","jlopez",null);
        dao.añadirPersona(p);
        assertEquals(dao.getPersonas().size(),1);
        Persona p2 = new Persona("Juana", "Lopeza", "12345678A", "jlope<",null);
        assertEquals(dao.getPersonas().size(), 1);
        assertEquals(dao.getPersonas().get(0), p);
        
    }

    /**
     * Test of eliminarPersona method, of class PersonaImpl.
     */
    @Test
    public void testEliminarPersona() {
        Persona p = new Persona("Juan","Lopez","12345678A","jlopez",null);
        dao.añadirPersona(p);
        assertEquals(dao.getPersonas().size(),1);
        Persona p2 = new Persona("Juana", "Lopeza", "12345678A", "jlope<",null);
        dao.añadirPersona(p2);
        dao.eliminarPersona(1);
        assertEquals(dao.getPersonas().size(), 1);
        assertEquals(dao.getPersonas().get(0), p2);
    }

    /**
     * Test of modificarPersona method, of class PersonaImpl.
     */
    @Test
    public void testModificarPersona() {
        Persona p = new Persona("Juan","Lopez","12345678A","jlopez",null);
        dao.añadirPersona(p);
        assertEquals(dao.getPersonas().get(0), p);
        Persona nueva = new Persona("Nueva", "NUeva", "121212121212", "fghh", null);
        nueva.setId(p.getId());
        assertEquals(dao.getPersonas().size(), 1);
        assertEquals(dao.getPersonas().get(0), nueva);

    }

    /**
     * Test of getPersonas method, of class PersonaImpl.
     */
    @Test
    public void testGetPersonas() {
    }

    /**
     * Test of getPersona method, of class PersonaImpl.
     */
    @Test
    public void testGetPersona_int() {
    }

    /**
     * Test of getPersona method, of class PersonaImpl.
     */
    @Test
    public void testGetPersona_String() {
    }  
}
