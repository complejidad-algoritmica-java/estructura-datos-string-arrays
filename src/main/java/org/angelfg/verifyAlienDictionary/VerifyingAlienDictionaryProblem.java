package org.angelfg.verifyAlienDictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * En una lengua alienígena también utilizan las letras del español, pero posiblemente en un orden diferente.
 * Es una permutación de nuestro alfabeto.
 * Tu desafío es, dada una secuencia de palabras escritas en el idioma extranjero y el orden del alfabeto alienígena,
 * devolver verdadero si y solo si las palabras dadas están ordenadas lexicográficamente
 * según el orden de letras del alfabeto alienígena dado.
 */
public class VerifyingAlienDictionaryProblem {

    // true
    private static final String[] WORDS_1 = new String[]{"habito", "hacer", "lectura", "sonreir"};
    private static final String ORDER_1 = "hlabcdfgijkmnopqrstuvwxyz";

    // false
    private static final String[] WORDS_2 = new String[]{"habito", "hacer", "sonreir", "lectura"};
    private static final String ORDER_2 = "hlabcdfgijkmnopqrstuvwxyz";

    // false
    private static final String[] WORDS_3 = new String[]{"conocer", "cono"};
    private static final String ORDER_3 = "abcdefghijkmnopqrstuvwxyz";

    private static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> dict = new HashMap<>();

        int longitudAbecedarioAlienigena = order.length();

        for (int index = 0; index < longitudAbecedarioAlienigena; index++) {
            dict.put(order.charAt(index), index + 1);
        }
        // Obtener map de letras con numero
        // {h:0},{l:1},{a:2},{b:3}

        // iniciamos 1 es menor que 4 (total de palabras) -> true (entra)
        for (int i = 0; i + 1 < words.length; i++) {

            // i = 0
            // words[0] = habito
            // words[0 + 1] equivalente a words[1] = hacer
            if (words[i].equals(words[i + 1])) { // habito es igual que hacer false -> no entra
                continue;
            }

            // habito = (6 longitud) es mayo o igual que hacer = (5 longitud)
            int wordLength = Math.max(words[i].length(), words[i + 1].length()); // El maximo es habito -> 6

            // wordIndex es menor que wordLength (0 < 6) -> true entra
            for (int wordIndex = 0; wordIndex < wordLength; wordIndex++) {

                // 6 > 6 -> false entonces es 0
                // De lo contrario obtengo el value a partir del key de la palabra mayor al mas largo wordIndex
                int val1 = words[i].length() > wordIndex ? dict.get(words[i].charAt(wordIndex)) : 0;
                int val2 = words[i + 1].length() > wordIndex ? dict.get(words[i + 1].charAt(wordIndex)) : 0;

                if (val1 > val2) {
                    return false;
                } else if (val1 < val2) {
                    break;
                }
            }

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Esta ordenado 1: " + isAlienSorted(WORDS_1, ORDER_1));
        System.out.println("Esta ordenado 2: " + isAlienSorted(WORDS_2, ORDER_2));
        System.out.println("Esta ordenado 3: " + isAlienSorted(WORDS_3, ORDER_3));
    }


}
