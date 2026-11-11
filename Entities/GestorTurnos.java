package Entities;

import Utils.Validaciones.ValidarDatosPacientes;

import interfaces.INotificacionesLookUp;
import interfaces.IObraSocialLookUp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//
public class GestorTurnos {
    private List<Turno> turnos = new ArrayList<>();
    private IObraSocialLookUp lookUpObraSocial;
    private INotificacionesLookUp lookUpNotificacion;

    // Constructor
    public GestorTurnos(
            IObraSocialLookUp lookUpObraSocial, INotificacionesLookUp lookUpNotificacion) {
        this.lookUpObraSocial = lookUpObraSocial;
        this.lookUpNotificacion = lookUpNotificacion;
    }

    // ---- Funcion principal: crear turno

    public Turno crearTurno(Paciente paciente, LocalDateTime fecha, Boolean urgente) {
        if (ValidarDatosPacientes.isDatosValidos(paciente)) {
            Turno turno = new Turno(fecha, paciente, urgente);

            // Mensaje obrasocial
            String infoObraSocial = lookUpObraSocial.infoObraSocial(paciente.getObraSocial());
            System.out.println(infoObraSocial);

            // Mensaje de confirmacion
            actualizarListaTurnos(turno);
            System.out.println("Turno Agregado");

            // Muestra el Turno
            Turno turnoGenerado = obtenerTurnoGenerado();
            System.out.println(turnoGenerado);
            return turno;
        }
        return null;
    }

    // ---- Enviar Notificacion/Recordatorio de turno

    public void enviarNotificacion(Paciente paciente, Turno turno, String tipoNotificacion) {
        String notificacionTurno =
                lookUpNotificacion.mostrarNotificacion(tipoNotificacion, turno.toString());
        System.out.println(notificacionTurno);
    }

    // Actualizar listado de turnos
    private void actualizarListaTurnos(Turno turno) {
        turnos.add(turno);
    }

    // --- Mostrar turno ultimo turno
    private Turno obtenerTurnoGenerado() {
        return turnos.get(turnos.size() - 1);
    }

    // ---- Mostrar Listado de turnos
    public void mostrarListadoTurnos() {
        for (int i = 0; i < turnos.size(); i++) {
            System.out.println(turnos.get(i).toString());
        }
    }

    //

}
