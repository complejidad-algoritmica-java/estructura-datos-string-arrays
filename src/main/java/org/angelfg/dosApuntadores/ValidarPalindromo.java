package org.angelfg.dosApuntadores;

/**
 * Dada una cadena de caracteres, averigua si la cadena dada es un palíndromo o no.
 * Puedes eliminar un carácter de la cadena.
 * Una cadena es un palíndromo si se lee igual hacia adelante y hacia atrás
 */
public class ValidarPalindromo {

    // output: true
    private static final String PALINDROMO_1 = "aba";

    // Explicación: Podría eliminar el carácter 'c'.
    // output: true
    private static final String PALINDROMO_2 = "abca";

    public static boolean validarPalindromo(String word) {

        char[] letters = word.toCharArray();
        int p1 = 0;
        int p2 = letters.length - 1;

        while (p1 < p2) {

            if (letters[p1] != letters[p2]) {
                return esPalindromo2(p1, p2, letters);
            } else {
                p1 += 1;
                p2 -= 1;
            }

        }

        return true;
    }

    private static boolean esPalindromo2(int p1, int p2, char[] letters) {
        while (p1 < p2) {
            if (letters[p1] == letters[p2]) {
                p1 += 1;
                p2 -= 1;
            } else {
                return false;
            }
        }

        return true;
    }

    // SOLUCION
    public static boolean esPalindromoValido(String frase) {
        int p1 = 0;
        int p2 = frase.length() - 1;

        while (p1 < p2) {
            if (frase.charAt(p1) != frase.charAt(p2)) {
                return esPalindromo(frase, p1 + 1, p2) || esPalindromo(frase, p1, p2 - 1);
            }
            p1++;
            p2--;
        }
        return true;
    }

    private static boolean esPalindromo(String frase, int p1, int p2) {
        while (p1 < p2) {
            if (frase.charAt(p1) != frase.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Es palindromo: (" + PALINDROMO_1 + ") -> " + esPalindromoValido(PALINDROMO_1));
        System.out.println("Es palindromo: (" + PALINDROMO_2 + ") -> " + esPalindromoValido(PALINDROMO_2));
    }

}
