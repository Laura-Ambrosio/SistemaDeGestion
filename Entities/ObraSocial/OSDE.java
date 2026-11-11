package Entities.ObraSocial;

import interfaces.IObraSocial;

public class OSDE implements IObraSocial {

    @Override
    public String obtenerInfoObraSocial() {
        return "Paciente premium";
    }

    @Override
    public Double obtenerCobertura() {
        return 0.1;
    }

    // public String toString(){
    //    return this.getClass().getName();
    // }

}
