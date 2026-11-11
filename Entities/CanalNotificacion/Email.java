package Entities.CanalNotificacion;

import interfaces.INotificacion;

public class Email implements INotificacion {

    @Override
    public String enviarNotificacion(String message) {
        return "Enviando recordatorio de turno por email: \n" + message;
    }
}
