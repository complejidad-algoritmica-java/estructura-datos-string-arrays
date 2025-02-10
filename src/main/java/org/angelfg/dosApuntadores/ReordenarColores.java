package org.angelfg.dosApuntadores;

import java.util.Arrays;

/**
 * Dado un arreglo nums con n objetos de color rojo, blanco o azul, ordénalos en su lugar para que
 * los objetos del mismo color sean adyacentes, con los colores en el orden rojo, blanco y azul.
 *
 * Utilizaremos los enteros 0, 1 y 2 para representar el color rojo, blanco y azul, respectivamente.
 * Reto 1: debes resolver este problema sin utilizar la función de ordenación de la biblioteca.
 * Reto 2: ¿podrías idear un algoritmo de una sola pasada utilizando solo un espacio extra constante?
 */
public class ReordenarColores {

    // output: [0,0,1,1,2,2]
    private static final int[] NUMB_1 = new int[] { 2,0,2,1,1,0 };

    // output: [0,1,2]
    private static final int[] NUMB_2 = new int[] { 2,0,1 };

    public static final int ROJO = 0;
    public static final int BLANCO = 1;
    public static final int AZUL = 2;

    private static int[] reordenarColores(int[] colores) {

        int p1 = 0;
        int p2 = 0;
        int p3 = colores.length - 1; // 2

        while (p2 <= p3) { // 0 <= 2

            if (colores[p2] == ROJO) { // 2 == 0 -> false
                if (p2 == p1) {
                    p2++;
                    continue;
                }

                int temp1 = colores[p1];
                int temp2 = colores[p2];

                colores[p1] = temp2;
                colores[p2] = temp1;
                p1++;
            } else if (colores[p2] == AZUL) { // 2 == 2 -> true ||
                int temp2 = colores[p2]; // temp2 = 2 ||
                int temp3 = colores[p3]; // temp3 = 1 ||

                // { 2, 0, 1 }
                colores[p3] = temp2; // igual
                colores[p2] = temp3;
                p3--;
                // { 1, 0, 2 }
                // p3 = (2 - 1) = 1
            } else {
                // BLANCO
                p2++;
            }

        }

        return colores;
    }

    public static void main(String[] args) {
        //Arrays.stream(reordenarColores(NUMB_1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(reordenarColores(NUMB_2)).forEach(System.out::println);
    }

}
