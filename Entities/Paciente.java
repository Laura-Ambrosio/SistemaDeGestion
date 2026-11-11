package Entities;

import Enums.EObraSocial;

// -----Clase Paciente
public class Paciente {
    private String nombre;
    private int edad;
    private EObraSocial obraSocial;

    // Constructor
    public Paciente(String nombre, int edad, EObraSocial obraSocial) {
        this.nombre = nombre;
        this.edad = edad;
        this.obraSocial = obraSocial;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public EObraSocial getObraSocial() {
        return this.obraSocial;
    }
}
