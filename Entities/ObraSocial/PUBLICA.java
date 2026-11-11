package Entities.ObraSocial;

import interfaces.IObraSocial;

public class PUBLICA implements IObraSocial {

    @Override
    public String obtenerInfoObraSocial() {
        return "Paciente publico";
    }

    @Override
    public Double obtenerCobertura() {
        return 0.5;
    }

    // public String toString(){
    //    return this.getClass().getName();
    // }

}
