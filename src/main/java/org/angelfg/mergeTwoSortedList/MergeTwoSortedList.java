package org.angelfg.mergeTwoSortedList;


import java.util.Arrays;

/**
 * En este desafío vas a recibir 4 elementos:
 * 2 arrays de números enteros (nums1 y nums2) ordenada de forma ascendente.
 * 2 números enteros (m y n) con la cantidad de elementos de cada una de las listas anteriores (nums1 y nums2 respectivamente).
 *
 * Importante: la longitud de nums1 es de m + n, siendo m los primeros elementos de la lista
 * (los números que posteriormente se deben combinar) y n los últimos elementos (teniendo todos el valor de 0 y
 * que deben ser ignorados en la combinación).
 *
 * La función merge_lists debe retornar 1 único array con la combinación de nums1 y nums2 ordenado de forma ascendente.
 */
public class MergeTwoSortedList {

    // output: [1,2,2,3,5,6]
    private static final int[] NUMS_1_1 = new int[] {1,2,3,0,0,0};
    private static final int M_1 = 3;
    private static final int[] NUMS_1_2 = new int[] {2,5,6};
    private static final int N_1 = 3;

    // output: [-4,1,2,2,3,3,9]
    private static final int[] NUMS_2_1 = new int[] {1,2,3,0,0,0,0};
    private static final int M_2 = 3;
    private static final int[] NUMS_2_2 = new int[] {-4,2,3,9};
    private static final int N_2 = 4;

    public static int[] mergeLists(int[] nums1, int m, int[] nums2, int n) {

        // 3 - 1 = 2
        int p1 = m - 1; // p1 = 2

        // 3 - 1 = 2
        int p2 = n - 1; // p2 = 2

        // 6 - 1 = 5
        int p = nums1.length - 1; // p = 5

        // p1 es mayor o igual a cero -> 2 >= 0 (true)
        // p2 es mayor o igual a cero -> 2 >= 0 (true)
        while (p1 >= 0 && p2 >= 0) { // (2 >= 0 && 2 >= 0)

            // nums1[p1] -> nums1[2] = 3
            // nums2[p2] -> nums2[2] = 6
            if (nums1[p1] > nums2[p2]) { // 3 > 6 -> false
                nums1[p] = nums1[p1];
                p1--;
            } else {
                // antes [1,2,3,0,0,0]
                // nums1[5] = 0 igual nums2[2] = 6
                nums1[p] = nums2[p2]; // ya no es 0 es 6 (nums1[5] = 6) [1,2,3,0,0,6]
                p2--; // p2 = 1
            }

            p--; // p = 4

        }

        // Si aún hay elementos en nums2, los copiamos a nums1
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }

        return nums1; // Devolvemos el array fusionado
    }

    public static int[] mergeLists2(int[] nums1, int m, int[] nums2, int n) {
        int[] result = Arrays.copyOf(nums1, m + n); // Creamos un nuevo array con el tamaño final
        int p1 = m - 1, p2 = n - 1, p = result.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            result[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }

        // Copiar lo que queda de nums2, si es necesario
        if (p2 >= 0) {
            System.arraycopy(nums2, 0, result, 0, p2 + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = mergeLists(NUMS_1_1, M_1, NUMS_1_2, N_1);
        int[] nums2 = mergeLists(NUMS_2_1, M_2, NUMS_2_2, N_2);

        Arrays.stream(nums1).forEach(System.out::print);
        System.out.println("\n");
        Arrays.stream(nums2).forEach(System.out::print);
    }

}
