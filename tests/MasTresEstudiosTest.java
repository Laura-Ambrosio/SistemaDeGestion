package tests;

import Entities.Descuentos.MasTresEstudios;

// Suite de pruebas unitarias para MasTresEstudios.descuentoEstudios()
// Cada test sigue el patrón AAA: Arrange, Act, Assert
public class MasTresEstudiosTest {

    private static int fallos = 0;

    public static void main(String[] args) {
        aplicaDescuentoCuandoHayMasDeTresEstudios();
        noAplicaDescuentoConMenosDeTresEstudios();
        noAplicaDescuentoConExactamenteTresEstudios();

        // Si algún test falló, el programa termina con error (código 1)
        // para que el pre-commit hook lo detecte
        if (fallos > 0) {
            System.exit(1);
        }
    }

    static void aplicaDescuentoCuandoHayMasDeTresEstudios() {
        // Arrange
        MasTresEstudios descuento = new MasTresEstudios();
        int cantidadEstudios = 4;

        // Act
        int resultado = descuento.descuentoEstudios(cantidadEstudios);

        // Assert
        verificar("Más de 3 estudios", 100, resultado);
    }

    static void noAplicaDescuentoConMenosDeTresEstudios() {
        // Arrange
        MasTresEstudios descuento = new MasTresEstudios();
        int cantidadEstudios = 2;

        // Act
        int resultado = descuento.descuentoEstudios(cantidadEstudios);

        // Assert
        verificar("Menos de 3 estudios", 0, resultado);
    }

    static void noAplicaDescuentoConExactamenteTresEstudios() {
        // Arrange
        MasTresEstudios descuento = new MasTresEstudios();
        int cantidadEstudios = 3; // caso de borde

        // Act
        int resultado = descuento.descuentoEstudios(cantidadEstudios);

        // Assert
        verificar("Exactamente 3 estudios (caso de borde)", 0, resultado);
    }

    // Cumple el rol del assertEquals de un framework de pruebas
    static void verificar(String nombreTest, int esperado, int obtenido) {
        if (esperado == obtenido) {
            System.out.println("PASA: " + nombreTest);
        } else {
            fallos++;
            System.out.println(
                    "FALLA: "
                            + nombreTest
                            + " -> esperado: "
                            + esperado
                            + ", obtenido: "
                            + obtenido);
        }
    }
}
