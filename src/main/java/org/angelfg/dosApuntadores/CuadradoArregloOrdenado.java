package org.angelfg.dosApuntadores;

import java.util.Arrays;

/**
 * Dado un arreglo de números enteros ordenados en orden ascendente,
 * devuelve una matriz de los cuadrados de cada número ordenados en orden no decreciente.
 *
 * Explicación: Después de elevar al cuadrado, el arreglo se convierte en [16,1,0,9,100].
 * Después de ordenar, se convierte en [0,1,9,16,100].
 *
 */
public class CuadradoArregloOrdenado {

    // output: [0,1,9,16,100]
    private static final int[] NUMS_1 = new int[] {-4,-1,0,3,10};

    // output: [4,9,9,49,121]
    private static final int[] NUMS_2 = new int[] {-7,-3,2,3,11};

    public static int[] arregloOrdenadoCuadrado(int[] nums) {

        int p1 = 0;
        int p2 = nums.length - 1;
        int p3 = nums.length - 1;
        int[] respuesta = new int[nums.length];

        while (p3 >= 0) {

            if (Math.abs(nums[p1]) > Math.abs(nums[p2])) {
                respuesta[p3] = nums[p1] * nums[p1];
                p1++;
            } else {
                respuesta[p3] = nums[p2] * nums[p2];
                p2--;
            }

            p3--;
        }

        return respuesta;
    }

    public static void main(String[] args) {
        Arrays.stream(arregloOrdenadoCuadrado(NUMS_1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(arregloOrdenadoCuadrado(NUMS_2)).forEach(System.out::println);
    }

}
