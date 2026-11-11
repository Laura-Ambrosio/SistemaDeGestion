package Entities.Descuentos;

import interfaces.IDescuento;

public class MasTresEstudios implements IDescuento {
    private static final int MONTO_DESCUENTO = 100;
    private static final int CANT_ESTUDIOS_PARA_DESCUENTO = 3;

    @Override
    public int descuentoEstudios(int cantidadEstudios) {
        if (cantidadEstudios > CANT_ESTUDIOS_PARA_DESCUENTO) {
            return MONTO_DESCUENTO;
        }
        return 0;
    }
}
