package Entities.CanalNotificacion;

import interfaces.INotificacion;

public class Push implements INotificacion {

    @Override
    public String enviarNotificacion(String message) {
        return "Enviando recordatorio de turno mediante push: \n" + message;
    }
}
