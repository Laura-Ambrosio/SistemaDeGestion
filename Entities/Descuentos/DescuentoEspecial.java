package Entities.Descuentos;

import Enums.EObraSocial;

public class DescuentoEspecial {
    private static final int CANT_MINIMA_ESTUDIOS = 3;
    private static final int EDAD_JUBILADO = 65;
    private static final int PRECIO_BASE = 100;
    private static final int RECARGO_URGENCIA = 50;

    // Porcentajes de descuento según obra social (jubilado / no jubilado)
    private static final double PUBLICA_JUBILADO = 0.5;
    private static final double PUBLICA_GENERAL = 0.4;
    private static final double OSDE_JUBILADO = 0.3;
    private static final double OSDE_GENERAL = 0.2;
    private static final double SWISS_JUBILADO = 0.25;
    private static final double SWISS_GENERAL = 0.15;
    private static final double OTRA_JUBILADO = 0.1;
    private static final double OTRA_GENERAL = 0.05;

    public double calcularDescuento(
            int cantidadEstudios, int edad, boolean urgente, EObraSocial obraSocial) {
        double descuento = 0;

        if (cantidadEstudios > CANT_MINIMA_ESTUDIOS) {
            descuento =
                    cantidadEstudios * PRECIO_BASE * porcentaje(obraSocial, edad >= EDAD_JUBILADO);
        }

        if (urgente) {
            descuento = descuento - RECARGO_URGENCIA;
        }

        return descuento;
    }

    private double porcentaje(EObraSocial obraSocial, boolean jubilado) {
        switch (obraSocial) {
            case PUBLICA:
                return jubilado ? PUBLICA_JUBILADO : PUBLICA_GENERAL;
            case OSDE:
                return jubilado ? OSDE_JUBILADO : OSDE_GENERAL;
            case SWISS:
                return jubilado ? SWISS_JUBILADO : SWISS_GENERAL;
            default:
                return jubilado ? OTRA_JUBILADO : OTRA_GENERAL;
        }
    }
}
