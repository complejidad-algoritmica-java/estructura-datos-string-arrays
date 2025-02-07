package org.angelfg.containerWithMostWater;

/**
 * En este desafío vas a recibir una lista de números que representan un grupo de líneas con diferentes alturas.
 * Encuentra las dos líneas que forman el contenedor que más agua puede contener.
 * Debes retornar esa máxima cantidad de agua que puede almacenar un contendor.
 *
 * area = base * altura;
 *
 */
public class ContainerWithMostWaterSolucion {

    // Output = 49
    private static final int[] ALTURAS_1 = new int[] {1,8,6,2,5,4,8,3,7};

    // Output = 56
    private static final int[] ALTURAS_2 = new int[] {8,1,6,2,5,4,1,3,7};

    private static int maxArea(int[] alturas) {
        int izquierda = 0;
        int derecha = alturas.length - 1;
        int areaMaxima = 0;

        while (izquierda < derecha) {

            int altura = Math.min(alturas[izquierda], alturas[derecha]);
            int base = derecha - izquierda;
            int areaActual = base * altura;

            areaMaxima = Math.max(areaActual, areaMaxima);

            if (alturas[izquierda] < alturas[derecha]) {
                izquierda += 1;
            } else {
                derecha -= 1;
            }

        }

        return areaMaxima;
    }

    public static void main(String[] args) {
        System.out.println("Altura max. 1: " + maxArea(ALTURAS_1));
        System.out.println("Altura max. 2: " + maxArea(ALTURAS_2));
    }

}
