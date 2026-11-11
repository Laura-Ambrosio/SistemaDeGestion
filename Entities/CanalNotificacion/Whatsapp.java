package Entities.CanalNotificacion;

import interfaces.INotificacion;

public class Whatsapp implements INotificacion {

    @Override
    public String enviarNotificacion(String message) {
        return "Enviando recordatorio de turno mediante Whatsapp: \n" + message;
    }
}
