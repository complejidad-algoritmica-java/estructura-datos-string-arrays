package org.angelfg.dosApuntadores;

import java.util.Arrays;

/**
 *
 * 1. Mover ceros al final
 * Dada la lista de enteros nums, mueve todos los ceros al final de la misma, manteniendo el orden relativo de los elementos no nulos.
 * Reto: reordena los valores “in place”, sin hacer una copia de la lista.
 *
 */
public class MoverCeroAlFinal {

    // output: [1,3,12,0,0]
    private static final int[] NUMBERS_1 = new int[] {0,1,0,3,12};

    // output: [0]
    private static final int[] NUMBERS_2 = new int[] {0};

    private static int[] moverCeros(int[] numeros) {
        int p1 = 0;

        // Mover los números no cero al inicio
        // [0,1,0,3,12]
        // 0 != 0 -> false
        // 1 != 0 -> true
        // temp = 1; || numeros[p2] = 1;
        for (int p2 = 0; p2 < numeros.length; p2++) {
            if (numeros[p2] != 0) {
                // Intercambiar elementos
                int temp = numeros[p2];
                numeros[p2] = numeros[p1];
                numeros[p1] = temp;
                p1++;
            }
        }

        return numeros;
    }

    public static void main(String[] args) {
        Arrays.stream(moverCeros(NUMBERS_1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(moverCeros(NUMBERS_2)).forEach(System.out::println);
    }

}
