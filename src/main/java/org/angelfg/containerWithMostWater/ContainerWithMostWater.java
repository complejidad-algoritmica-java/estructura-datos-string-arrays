package org.angelfg.containerWithMostWater;

/**
 * En este desafío vas a recibir una lista de números que representan un grupo de líneas con diferentes alturas.
 * Encuentra las dos líneas que forman el contenedor que más agua puede contener.
 * Debes retornar esa máxima cantidad de agua que puede almacenar un contendor.
 *
 * area = base * altura;
 *
 */
public class ContainerWithMostWater {

    // Output = 49
    private static final int[] ALTURAS_1 = new int[] {1,8,6,2,5,4,8,3,7};

    // Output = 56
    private static final int[] ALTURAS_2 = new int[] {8,1,6,2,5,4,1,3,7};

    private static int maxArea(int[] alturas) {

        int initialPosition = 0;
        int size = alturas.length - 1;
        int area = 0;

        // (cero es menor que ocho) -> si
        while (initialPosition < size) { // 0 < 8 = true

            // Obtiene la base mediante los punteros del inicio hacia el ultimo
            int primerPuntero = alturas[initialPosition];
            int segundoPuntero = alturas[size];

            int base = Math.min(primerPuntero, segundoPuntero); // cual es menor 1 o el 7 -> base = 1;
            int altura = (size - initialPosition);
            int minorArea = base * altura; // 1 * (8 - 0) -> minorArea = 8
            area = Math.max(area, minorArea); // Del area global cual es mayor (0 o 8) -> area = 8; va tomando el valor mayor

            // 0 > 7 -> no
            if (primerPuntero > segundoPuntero) {
                size--;
            } else {
                initialPosition++; // Suma en uno de la posicion 0 a la 1 asi sucesivamente
            }

        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println("Altura max. 1: " + maxArea(ALTURAS_1));
        System.out.println("Altura max. 2: " + maxArea(ALTURAS_2));
    }

}
