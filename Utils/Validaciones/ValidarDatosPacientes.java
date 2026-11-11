package Utils.Validaciones;

import Entities.Paciente;

public final class ValidarDatosPacientes { // final > no se puede heredar

    // Los Metodos de las utilidades son estaticos (no pertenecen a un objeto o instancia)

    // ------------ Validar Datos --------------//
    public static boolean isDatosValidos(Paciente paciente) {
        if (validarNombre(paciente) && validarEdad(paciente) && validarObraSocial(paciente)) {
            return true;
        } else {
            System.out.println("Datos de paciente no valido ");
            return false;
        }
    }

    // ----- Validar datos paciente: nombre
    public static boolean validarNombre(Paciente paciente) {
        if (paciente.getNombre() != null && !paciente.getNombre().equals("")) {
            return true;
        }
        System.out.println("El campo nombre se encuentra vacio");
        return false;
    }

    // ----- Validar datos paciente: edad

    public static boolean validarEdad(Paciente paciente) {
        if (paciente.getEdad() > 0) {
            return true;
        }
        System.out.println("El campo edad se encuentra vacio");
        return false;
    }

    // ----- Validar datos paciente: ObraSocial
    public static boolean validarObraSocial(Paciente paciente) {
        if (paciente.getObraSocial() != null) {
            return true;
        } else {
            System.out.println("Obra Social no seleccionada");
            return false;
        }
    }
}
