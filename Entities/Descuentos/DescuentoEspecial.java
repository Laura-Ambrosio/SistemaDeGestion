package Entities.Descuentos;

public class DescuentoEspecial {

    public double calcularDescuento(
            int cantidadEstudios, int edad, boolean urgente, String obraSocial) {
        double descuento = 0;

        if (cantidadEstudios > 3) {
            if (edad >= 65) {
                if (obraSocial.equals("PUBLICA")) {
                    descuento = cantidadEstudios * 100 * 0.5;
                } else if (obraSocial.equals("OSDE")) {
                    descuento = cantidadEstudios * 100 * 0.3;
                } else if (obraSocial.equals("SWISS")) {
                    descuento = cantidadEstudios * 100 * 0.25;
                } else {
                    descuento = cantidadEstudios * 100 * 0.1;
                }
            } else {
                if (obraSocial.equals("PUBLICA")) {
                    descuento = cantidadEstudios * 100 * 0.4;
                } else if (obraSocial.equals("OSDE")) {
                    descuento = cantidadEstudios * 100 * 0.2;
                } else if (obraSocial.equals("SWISS")) {
                    descuento = cantidadEstudios * 100 * 0.15;
                } else {
                    descuento = cantidadEstudios * 100 * 0.05;
                }
            }
        }

        if (urgente) {
            descuento = descuento - 50;
        }

        return descuento;
    }
}
