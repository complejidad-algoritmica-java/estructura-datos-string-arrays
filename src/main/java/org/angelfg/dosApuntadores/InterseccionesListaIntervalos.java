package org.angelfg.dosApuntadores;

import java.util.ArrayList;
import java.util.List;

/**
 * Dadas dos listas de intervalos cerrados,
 * lista1 y lista2, donde lista1[i] = [inicio_i, final_i] y lista2[j] = [inicio_j, final_j].
 * Cada lista de intervalos es disjunta por pares y está ordenada.
 *
 * Devuelve la intersección de estas dos listas de intervalos.
 *
 * Un intervalo cerrado [a, b] (con a <= b) denota el conjunto de números reales x con a <= x <= b.
 * La intersección de dos intervalos cerrados es un conjunto de números reales que está vacío o representado como un intervalo cerrado.
 * Por ejemplo, la intersección de [1, 3] y [2, 4] es [2, 3].
 */
public class InterseccionesListaIntervalos {

    // output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    private static final int[][] FIRST_LIST_1 = new int[][] { {0,2}, {5,10}, {13,23}, {24,25} };
    private static final int[][] SECOND_LIST_1 = new int[][] { {1,5}, {8,12}, {15,24}, {25,26} };

    private static final int[][] FIRST_LIST_2 = new int[][] { {1,3}, {5,9} };
    private static final int[][] SECOND_LIST_2 = new int[][] {};

    public static int[][] interseccionesListaIntervalos(int[][] firstList, int[][] secondList) {

        List<int[]> resultado = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while (p1 < firstList.length && p2 < secondList.length) {
            int low = Math.max(firstList[p1][0], secondList[p2][0]);
            int high = Math.min(firstList[p1][1], secondList[p2][1]);

            if (low <= high) {
                resultado.add(new int[]{low, high});
            }

            if (firstList[p1][1] < secondList[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }

        // Convertir la lista a un array bidimensional
        return resultado.toArray(new int[resultado.size()][]);
    }

    public static void main(String[] args) {

        int[][] intersecciones = interseccionesListaIntervalos(FIRST_LIST_1, SECOND_LIST_1);

        System.out.println("Intersecciones:");
        for (int[] intervalo : intersecciones) {
            System.out.println("[" + intervalo[0] + ", " + intervalo[1] + "]");
        }

        System.out.println();
        System.out.println();

        int[][] intersecciones2 = interseccionesListaIntervalos(FIRST_LIST_2, SECOND_LIST_2);

        System.out.println("Intersecciones:");
        for (int[] intervalo : intersecciones2) {
            System.out.println("[" + intervalo[0] + ", " + intervalo[1] + "]");
        }

    }

}
