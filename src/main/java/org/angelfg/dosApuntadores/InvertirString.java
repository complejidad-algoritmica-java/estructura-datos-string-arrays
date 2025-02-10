package org.angelfg.dosApuntadores;

import java.util.Arrays;

public class InvertirString {

    // output: ["o","l","l","e","h"]
    private static final String[] STRING_1 = new String[] { "h", "e", "l", "l", "o" };

    // output: ["h","a","n","n","a","H"]
    private static final String[] STRING_2 = new String[] { "H", "a", "n", "n", "a", "h" };

    private static String[] invertirString(String[] cadena) {

        int p1 = 0;
        int p2 = cadena.length - 1;

        while (p1 < p2) {

            String temp1 = cadena[p1];
            String temp2 = cadena[p2];

            cadena[p1] = temp2;
            cadena[p2] = temp1;

            p1++;
            p2--;
        }

        return cadena;
    }

    public static void main(String[] args) {
        Arrays.stream(invertirString(STRING_1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(invertirString(STRING_2)).forEach(System.out::println);
    }

}
