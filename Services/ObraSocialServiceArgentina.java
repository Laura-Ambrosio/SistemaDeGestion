package Services;

import Entities.ObraSocial.*;

import Enums.EObraSocial;

import interfaces.IObraSocial;
import interfaces.IObraSocialLookUp;

import java.util.Map;

public class ObraSocialServiceArgentina implements IObraSocialLookUp {
    private Map<EObraSocial, IObraSocial> estrategias;

    // Constructor de ObraSocial
    public ObraSocialServiceArgentina() {
        estrategias =
                Map.of( // temp harcoded obrasociales, esto se leeria desde un doc o db
                        EObraSocial.OSDE, new OSDE(),
                        EObraSocial.SWISS, new SWISS(),
                        EObraSocial.PUBLICA, new PUBLICA());
    }

    public String infoObraSocial(EObraSocial obraSocial) {
        return estrategias.getOrDefault(obraSocial, new PUBLICA()).obtenerInfoObraSocial();
    }

    public double porcentajeCobertura(EObraSocial obraSocial) {
        return estrategias.getOrDefault(obraSocial, new PUBLICA()).obtenerCobertura();
    }
}
