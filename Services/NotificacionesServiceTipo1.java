package Services;

import Entities.CanalNotificacion.*;

import interfaces.INotificacion;
import interfaces.INotificacionesLookUp;

import java.util.Map;

public class NotificacionesServiceTipo1 implements INotificacionesLookUp {
    private Map<String, INotificacion> estrategias;

    // Constructor de NotificacionesService
    // Inyecto interfaz para desacoplar las clases
    public NotificacionesServiceTipo1() {
        estrategias =
                Map.of(
                        "EMAIL", new Email(),
                        "SMS", new Sms(),
                        "WHATSAPP", new Whatsapp());
    }

    // Metodo que tome la estrategia y devuelva el mensaje (como en la Sem 1)
    public String mostrarNotificacion(String string, String message) {
        return estrategias.getOrDefault(string, new Sms()).enviarNotificacion(message);
    }
}
