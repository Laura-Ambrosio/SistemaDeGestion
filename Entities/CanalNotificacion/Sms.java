package Entities.CanalNotificacion;

import interfaces.INotificacion;

public class Sms implements INotificacion {

    @Override
    public String enviarNotificacion(String message) {
        return "Enviando recordatorio de turno mediante SMS: \n " + message;
    }
}
