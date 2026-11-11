package Services;

import Entities.CanalNotificacion.*;

import interfaces.INotificacion;
import interfaces.INotificacionesLookUp;

import java.util.Map;

public class NotificacionesServiceTipo2 implements INotificacionesLookUp {
    private Map<String, INotificacion> estrategias;

    // Constructor de NotificacionesService
    // Inyecto interfaz para desacoplar las clases
    public NotificacionesServiceTipo2() {
        estrategias =
                Map.of(
                        "TELEGRAM", new Telegram(),
                        "PUSH", new Push());
    }

    // Metodo que tome la estrategia y devuelva el mensaje (como en la Sem 1)
    public String mostrarNotificacion(String string, String message) {
        return estrategias.getOrDefault(string, new Sms()).enviarNotificacion(message);
    }
}
