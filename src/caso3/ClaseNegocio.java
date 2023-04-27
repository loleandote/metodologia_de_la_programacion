package caso3;

import java.util.List;

public class ClaseNegocio {
    /**
     * La función llena una matriz 2D con valores de una lista de enteros, asegurando que no se
     * superpongan dos valores y que cada valor se use tantas veces como sea posible.
     * 
     * @param suelo una matriz 2D que representa el suelo que se va a rellenar con mosaicos
     * @param baldosas Una lista de números enteros que representan los tamaños de los mosaicos que se
     * pueden usar para llenar una matriz 2D llamada "suelo". La función "rellenarSuelo" usa estos
     * mosaicos para llenar los espacios vacíos (representados por 0) en la matriz "suelo".
     */
    public static void rellenarSuelo(int[][] suelo, List<Integer> baldosas) {
        for (int i = 0; i < suelo.length; i++)
            for (int j = 0; j < suelo.length; j++) {
                // La sentencia `if (suelo[i][j] == 0)` verifica si el elemento actual en la matriz 2D
                // `suelo` en la posición `(i,j)` es igual a 0, lo que representa un espacio vacío que
                // necesita ser llenado con un azulejo.
                if (suelo[i][j] == 0) {
                    int posicion = 0;
                    boolean suficiente = false;
                    // Este es un ciclo while que itera a través de la lista de enteros llamados
                    // "baldosas". Comprueba si el entero actual en la posición "posición" puede caber
                    // en el espacio vacío actual en la matriz 2D "suelo" que comienza en la posición
                    // (i,j). Si puede caber, llena el espacio con el valor entero y establece la
                    // variable booleana "suficiente" en verdadero para indicar que el espacio se ha
                    // llenado. Si no cabe, pasa al siguiente número entero de la lista incrementando
                    // "posición". El ciclo continúa hasta que se encuentra un número entero adecuado
                    // para llenar el espacio o se han verificado todos los números enteros en la
                    // lista.
                    while (posicion < baldosas.size() && !suficiente) {
                        if ((i + baldosas.get(posicion) <= suelo.length) && (j + baldosas.get(posicion) <= suelo.length)
                                && (suelo[i][j + baldosas.get(posicion) - 1] == 0)) {
                            for (int k = 0; k < baldosas.get(posicion); k++)
                                for (int l = 0; l < baldosas.get(posicion); l++)
                                    suelo[i + k][j + l] = baldosas.get(posicion);
                            suficiente = true;
                        } else
                            posicion++;
                    }
                }
            }
    }
}
