package org.angelfg.dosApuntadores;

/**
 * Dada una cadena de caracteres, invierte solo todas las vocales de la cadena.
 * Las vocales son ‘a’, ‘e’, ‘i’, ‘o’ y ‘u’, ‘A’, ‘E’, ‘I’, ‘O’, ‘U’.
 */
public class InvertirVocales {

    // output: "halo"
    private static final String STRING_1 = "hola";

    // output: "leotcede"
    private static final String STRING_2 = "leetcode";

    private static final char[] VOCALES = new char[] { 'a','e','i','o','u','A','E','I','O','U' };

    public static String invertirVocales(String word) {

        char[] caracteres = word.toCharArray();

        int p1 = 0;
        int p2 = caracteres.length - 1;

//        Complejidad cuadratica O(n^2)
//        String vocales = "";
//        for (int i = 0; i < VOCALES.length; i++) {
//            vocales += VOCALES[i];
//        }

//        ó usar O(n)
//        public static String obtenerVocales() {
//            StringBuilder vocales = new StringBuilder(VOCALES.length);
//            for (char c : VOCALES) {
//                vocales.append(c);
//            }
//            return vocales.toString();
//        }

        String vocales = new String(VOCALES); // O(n)

        while (p1 < p2) {

            // Ambos punteros están en vocales, intercambiamos
            if (vocales.indexOf(caracteres[p1]) != -1 && vocales.indexOf(caracteres[p2]) != -1) {
                char temp = caracteres[p1];
                caracteres[p1] = caracteres[p2];
                caracteres[p2] = temp;
                p1++;
                p2--;
            } else {

                // Mover p1 si no es vocal
                if (vocales.indexOf(caracteres[p1]) == -1) {
                    p1++;
                }

                // Mover p2 si no es vocal
                if (vocales.indexOf(caracteres[p2]) == -1) {
                    p2--;
                }

            }

        }

        return new String(caracteres);
    }

    public static void main(String[] args) {
        System.out.println("Salida 1: " + invertirVocales(STRING_1));
        System.out.println("Salida 2: " + invertirVocales(STRING_2));
    }

}
