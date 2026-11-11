import Entities.Descuentos.MasTresEstudios;
import Entities.Facturacion;
import Entities.GestorTurnos;
import Entities.Paciente;
import Entities.Turno;

import Enums.EObraSocial;

import Services.*;

import interfaces.IDescuento;
import interfaces.IObraSocialLookUp;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Pacientes
        Paciente p1 = new Paciente("alex", 35, EObraSocial.OSDE);
        Paciente p2 = new Paciente("laura", 36, EObraSocial.PUBLICA);

        // >>>>"Inyeccion de Dependencias" mediante main <<<<<
        GestorTurnos manager =
                new GestorTurnos(
                        new ObraSocialServiceArgentina(), new NotificacionesServiceTipo1());

        // ---  Crear turnos
        System.out.println("\n Creando Turnos ... \n");
        Turno t1 = manager.crearTurno(p1, LocalDateTime.now(), true);
        Turno t2 = manager.crearTurno(p2, LocalDateTime.now(), false);

        // --- Enviar Recordatorios

        System.out.println("\n Enviando Notificaciones... \n");
        manager.enviarNotificacion(p1, t1, "WHATSAPP");
        manager.enviarNotificacion(p2, t2, "EMAIL");

        // --- Facturacion
        IObraSocialLookUp lookup = new ObraSocialServiceArgentina();
        IDescuento descuentos = new MasTresEstudios();
        Facturacion facturacion = new Facturacion(lookup, descuentos);

        // --- Calcular costo
        List<Double> p2PrecioEstudios_3 = List.of(200.50, 150.0, 310.80); // Inmutable
        List<Double> p2PrecioEstudios_4 = List.of(200.50, 150.0, 310.80, 120.20); // Inmutable

        // List<Double> p2PrecioEstudios = new ArrayList<>(List.of(200.50, 150.0, 310.80)); //Se
        // puede modificar

        System.out.println("\n Calculando costo Metodo Refactorizado... \n");
        System.out.println("Sin Descuento (3 estudios)... ");
        double costo = facturacion.calcularCostoTotalEstudios(p2PrecioEstudios_3, p2); // PUBLICA
        System.out.println("Total: " + costo + "\n");

        System.out.println("Con Descuento (4 estudios)... ");
        double costo1 = facturacion.calcularCostoTotalEstudios(p2PrecioEstudios_4, p2); // PUBLICA
        System.out.println("Total: " + costo1 + "\n");

        System.out.println("\n Calculando costo Metodo Original... \n");
        System.out.println("Sin Descuento (3 estudios)... ");
        double costo2 = facturacion.calc(p2PrecioEstudios_3, true, false, 3); // PUBLICA
        System.out.println("Total: " + costo2 + "\n");

        System.out.println("Con Descuento (4 estudios)... ");
        double costo3 = facturacion.calc(p2PrecioEstudios_4, true, false, 4); // PUBLICA
        System.out.println("Total: " + costo3 + "\n");

        System.out.println("Con Descuento (3 estudios pero la cantidad dice 4)... ");
        double costo4 = facturacion.calc(p2PrecioEstudios_3, true, false, 4); // PUBLICA
        System.out.println("Total: " + costo4 + "\n");
        System.out.println(
                "No detecta la longitud real y aplica el descuento aunque no corresponde \n");
    }
}
