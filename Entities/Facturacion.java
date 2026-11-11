package Entities;

import interfaces.IDescuento;
import interfaces.IObraSocialLookUp;

import java.util.List;

public class Facturacion {
    private IObraSocialLookUp obraSocialLookUp;
    private IDescuento descuentos;

    public Facturacion(IObraSocialLookUp obraSocialLookUp, IDescuento descuentos) {
        this.obraSocialLookUp = obraSocialLookUp;
        this.descuentos = descuentos;
    }

    // La lista de precios simularia la base de datos

    public double calcularCostoTotalEstudios(
            List<Double> precioEstudiosPaciente, Paciente paciente) {
        try {

            // Obtener porcentaje de cobertura segun obraSocial
            double porcentajeCobertura =
                    obraSocialLookUp.porcentajeCobertura(paciente.getObraSocial());

            // Obtener costo total sin descuentos
            double totalSinDescuentos = sumarListaDoubles(precioEstudiosPaciente);

            // Aplicar descuento
            double totalPagar = totalSinDescuentos * (1 - porcentajeCobertura);

            // Aplicar descuento por cantidad si corresponde
            int cantidadEstudios = precioEstudiosPaciente.size();
            int promocion = descuentos.descuentoEstudios(cantidadEstudios);

            return totalPagar - promocion;

        } catch (Exception e) {
            throw new RuntimeException("Error al calcular el costo de estudios del paciente", e);
        }
    }

    // ---- Metodos auxiliares
    // Obtener descuento
    // Metodo en ObraSocialServiceArgentina

    // ----Metodo sumar lista numerica (decimales)
    private double sumarListaDoubles(List<Double> listaPreciosEstudios) {
        return listaPreciosEstudios.stream().mapToDouble(Double::doubleValue).sum();
    }

    // ------------------ Funcion con nombre original de la funcion ----------------------------
    // Se cambiaron los nombres de los parametros
    public double calc(
            List<Double> precioEstudiosPaciente,
            boolean publica,
            boolean obraSocial,
            int cantidadEstudios) {

        double resultado = 0;

        // itera sobre cada precio de la lista
        for (Double precio : precioEstudiosPaciente) {

            // Determina si su OSocial es publica
            if (publica == true) {

                // Aplica descuento a cada item y luego lo suma
                // No es necesario calcular la cobertura sobre cada precio porque el valor es fijo
                // La funcion no prevee que el valor pueda cambiar
                resultado += precio * 0.5;

                // Si no es publica suma todos los precios
            } else {
                resultado += precio;
            }
        }

        // NO prevee que puede haber mas de una obra social
        // No prevee cambios en el porcentaje de cobertura
        // No tiene en cuenta que si no es ObraSocial es Publica (default) al menos en
        // ObraSocialServiceArgentina
        // Toma el valor resultado de la variable global pero
        if (obraSocial == true) {
            resultado = resultado * 0.9;
        }

        // Si la cantidad de estudios realizados es mayor a 3 se descuentan 100 extra
        if (cantidadEstudios > 3) {
            resultado = resultado - 100;
        }

        return resultado;
    }
}
