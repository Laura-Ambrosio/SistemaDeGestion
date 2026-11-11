package Entities;

import java.time.LocalDateTime;

public class Turno {
    private LocalDateTime fecha;
    private Paciente paciente;
    private Boolean urgente;

    public Turno(LocalDateTime fecha, Paciente paciente, Boolean urgente) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.urgente = urgente;
    }

    public String toString() {
        return "----------------Turno----------------------"
                + "\n"
                + "Fecha: "
                + fecha.toString()
                + "\n"
                + "-------------------------------------------"
                + "\n"
                + "Nombre: "
                + paciente.getNombre()
                + "\n"
                + "Edad: "
                + paciente.getEdad()
                + "\n"
                + "ObraSocial "
                + paciente.getObraSocial()
                + "\n"
                + "Urgente: "
                + (urgente ? "urgente" : "-")
                + "\n"
                + "-------------------------------------------"
                + "\n";
    }
}
