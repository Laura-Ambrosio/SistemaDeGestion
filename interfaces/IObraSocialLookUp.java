package interfaces;

import Enums.EObraSocial;

public interface IObraSocialLookUp {

    String infoObraSocial(EObraSocial obrasocial);

    double porcentajeCobertura(EObraSocial obrasocial);
}
