package Entities.CanalNotificacion;

import interfaces.INotificacion;

public class Telegram implements INotificacion {

    @Override
    public String enviarNotificacion(String message) {
        return "Enviando recordatorio de turno mediante: \n" + message;
    }
}
