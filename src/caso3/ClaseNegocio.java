package caso3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }    public static void devolverBaldosas(double area, List<Double> baldosas) {
        double areaOriginal = area;
        Map<Double, Integer> baldosasH = new HashMap<>();
        // Crear Cuadrado
        boolean encontrado = false;
        for (int i = 0; i < baldosas.size() && !encontrado && area > 0; i++) {
            double baldosa = baldosas.get(i);
            if (area >= baldosa) {
                int veces = (int) (area / baldosa);
                baldosasH.put(baldosa, veces);
                area %= baldosa;
                encontrado = true;
            }
        }
        // Rellenar
        if (encontrado) {
            double alto = area;
            double ancho = area;
            for (int i = 0; i < baldosas.size() && (alto > 0 || ancho > 0); i++) {
                double baldosa = baldosas.get(i);
                if (alto >= baldosa || ancho >= baldosa) {
                    int vecesLargo = (int) (ancho / baldosa * areaOriginal / baldosa);
                    int vecesCorto = (int) (alto / baldosa * (areaOriginal - area) / baldosa);
                    int veces = vecesLargo + vecesCorto;
                    baldosasH.put(baldosa, veces);
                    alto = areaOriginal % baldosa * vecesLargo;
                    System.out.println("area " + area + " area original " + areaOriginal);
                    area = area % baldosa;
                    ancho = area;
                }
            }
            System.out.println("alto " + alto + "ancho " + ancho);
        }

        baldosasH.forEach((key, value) -> System.out.println(key + " " + value));
        if (area > 0)
            System.out.println("no se puede");
    }

    public static void resolver(Integer lado, List<Integer> baldosas, Map<Integer, Integer> baldosasH,
            PresentacionResultados pantalla) {
        Suelo suelo = new Suelo(lado, baldosas, 1);
        try {
            suelo.procesarSuperficie(baldosasH, pantalla);
        } catch (StackOverflowError e) {
            System.out.println("no che va a poder");
        }

    }

    public static void resolver(Integer ancho, Integer alto, List<Integer> baldosas, Map<Integer, Integer> baldosasH,
            PresentacionResultados pantalla) {
                pantalla.añadirFigura(1,1,ancho,alto);
        Suelo suelo = new Suelo(ancho, alto, 1, 1, baldosas, 0);
        suelo.procesarSuperficie(baldosasH, pantalla);
    }
}

class Suelo {
    private Integer ancho;
    private Integer alto;
    private Suelo sueloBajo, sueloLado;
    private List<Integer> baldosas;
    private int nivel;
    public int x;
    private int y;

    public Suelo(Integer lado, List<Integer> baldosas, int nivel) {
        alto = lado;
        ancho = lado;
        this.baldosas = baldosas;
        this.nivel = nivel;
        x = 1;
        y = 1;
    }

    public Suelo(Integer ancho, Integer alto, Integer x, Integer y, List<Integer> baldosas, int nivel) {
        this.alto = alto;
        this.ancho = ancho;
        this.x = x;
        this.y = y;
        this.baldosas = baldosas;
        this.nivel = nivel;
    }

    public void procesarSuperficie(Map<Integer, Integer> baldosasH, PresentacionResultados pantalla)
            throws StackOverflowError {
        if (nivel < baldosas.size()) {
            int baldosa = baldosas.get(nivel++);
            if (baldosa > ancho || baldosa > alto)
                procesarSuperficie(baldosasH, pantalla);
            else {
                int resultado = (ancho / baldosa) * (alto / baldosa);
                int anchoAux = ancho % baldosa;
                int altoAux = alto % baldosa;
                if (baldosasH.get(baldosa) != null)
                    baldosasH.put(baldosa, (baldosasH.get(baldosa) + resultado));
                else
                    baldosasH.put(baldosa, resultado);
                int xAux = x;
                int yAux = y;
                int veces = 1;
                for (int i = 0; i < resultado; i++) {
                    pantalla.añadirFigura(xAux, yAux, baldosa, baldosa);
                    if ((ancho + 1) >= (++veces) * baldosa)
                        xAux += baldosa;
                    else if (i < (resultado-1)) {
                        veces = 1;
                        xAux = x;
                        yAux += baldosa;
                    }
                }
                int ybajo = 1 + (alto / baldosa)*baldosa;
                int xlado = 1 + (ancho / baldosa) * baldosa;
                if (anchoAux > 0) {
                    sueloLado = new Suelo(anchoAux, alto, xlado, y, baldosas, nivel);
                    sueloLado.procesarSuperficie(baldosasH, pantalla);
                }
                if (altoAux > 0) {
                    sueloBajo = new Suelo((ancho - anchoAux), altoAux, x, ybajo, baldosas, nivel);
                    sueloBajo.procesarSuperficie(baldosasH, pantalla);
                }
                alto = altoAux;
                ancho = anchoAux;
            }
        }
    }
}