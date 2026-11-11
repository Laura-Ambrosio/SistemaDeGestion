package Entities.ObraSocial;

import interfaces.IObraSocial;

public class SWISS implements IObraSocial {

    @Override
    public String obtenerInfoObraSocial() {
        return "Paciente premium";
    }

    @Override
    public Double obtenerCobertura() {
        return 0.1; // Cubre 20%
    }

    //    public String toString(){
    //     return this.getClass().getName();
    // }

}
