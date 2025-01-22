/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestordeeventos.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAW1
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona {
    
    
    private static int numPersona = 0;
    
    @EqualsAndHashCode.Include
    private int id;
    private String nombre;
    private String apellidos;
    private String password;
    private String dni;
    private List<Evento> eventos = new ArrayList<>();
    private Date fechaNacimiento;

    public Persona() {
        Persona.numPersona++;
        this.id = Persona.numPersona;
        
    }

    public Persona(String nombre, String apellidos, String password, String dni, Date fechaNacimiento) {
        this();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public boolean isMayorEdad(){
        GregorianCalendar gcHoy = new GregorianCalendar();
        GregorianCalendar gcFechaNacimiento = new GregorianCalendar();
        gcFechaNacimiento.setTime(this.fechaNacimiento);
        int añoActual = gcHoy.get(Calendar.YEAR);
        int añoNacimiento = gcFechaNacimiento.get(Calendar.YEAR);
        int edad = añoActual - añoNacimiento;
        if(gcHoy.get(Calendar.DAY_OF_YEAR) < gcFechaNacimiento.get(Calendar.DAY_OF_YEAR)){
            edad--;
        }
        return edad >= 18;
    }
    
    
    
    
    
}
