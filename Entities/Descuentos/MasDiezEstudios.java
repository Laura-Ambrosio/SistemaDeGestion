package Entities.Descuentos;

import interfaces.IDescuento;

public class MasDiezEstudios implements IDescuento {
    private static final int MONTO_DESCUENTO = 300;
    private static final int CANT_ESTUDIOS_PARA_DESCUENTO = 10;

    @Override
    public int descuentoEstudios(int cantidadEstudios) {
        if (cantidadEstudios > CANT_ESTUDIOS_PARA_DESCUENTO) {
            return MONTO_DESCUENTO;
        }
        return 0;
    }
}
