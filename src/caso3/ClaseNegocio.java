package caso3;
import java.util.Scanner;

/**
 * ClaseNegocio - Clase que implementa la lógica del negocio para solado de una superficie cuadrada
 */
public class ClaseNegocio {
    
    /**
     * Método que resuelve el problema de solado de una superficie cuadrada utilizando baldosas cuadradas de diferentes tamaños.
     * @param ladoSuperficie Longitud del lado de la superficie a soladar.
     * @param tamBaldosa Tamaño de la baldosa a utilizar.
     * @return Cuadrícula de baldosas generada.
     */
    public static String[][] generarSolado(int ladoSuperficie, int tamBaldosa) {
        // Calcular la cantidad de baldosas necesarias para cubrir la superficie
        int cantBaldosas = (int) Math.ceil((double) ladoSuperficie / tamBaldosa);
    
        // Crear una cuadrícula de baldosas con la cantidad necesaria de filas y columnas
        String[][] cuadriculaBaldosas = new String[cantBaldosas][cantBaldosas];
    
        // Generar un número único para cada baldosa en la cuadrícula
        int numBaldosa = 1;
        for (int i = 0; i < cantBaldosas; i++) {
            for (int j = 0; j < cantBaldosas; j++) {
                cuadriculaBaldosas[i][j] = String.valueOf(numBaldosa++);
            }
        }
    
        // Llenar la cuadrícula de baldosas con el tamaño de la baldosa correspondiente
        for (int i = 0; i < cantBaldosas; i++) {
            for (int j = 0; j < cantBaldosas; j++) {
                int tamActual = tamBaldosa;
                if (i == cantBaldosas - 1 && ladoSuperficie % tamBaldosa != 0) {
                    tamActual = ladoSuperficie % tamBaldosa;
                }
                if (j == cantBaldosas - 1 && ladoSuperficie % tamBaldosa != 0) {
                    tamActual = ladoSuperficie % tamBaldosa;
                }
                cuadriculaBaldosas[i][j] += "x" + tamActual;
            }
        }
    
        // Devolver la cuadrícula de baldosas generada
        return cuadriculaBaldosas;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedir el tamaño de la superficie a soladar
        System.out.print("Introduce la longitud del lado de la superficie cuadrada a soladar: ");
        
        
        // Pedir el tamaño de la superficie a soladar
        System.out.print("Introduce la longitud del lado de la superficie cuadrada a soladar: ");
        int ladoSuperficie = sc.nextInt();

        // Pedir el tamaño de la baldosa a utilizar
        System.out.print("Introduce el tamaño de la baldosa cuadrada a utilizar: ");
        int tamBaldosa = sc.nextInt();

        // Llamar al método generarSolado para obtener la cuadrícula de baldosas generada
        String[][] cuadriculaBaldosas = ClaseNegocio.generarSolado(ladoSuperficie, tamBaldosa);
        System.out.println("Cuadrícula de baldosas: " + ladoSuperficie + "x" + ladoSuperficie);
        for (int i = 0; i < cuadriculaBaldosas.length; i++) {
        for (int j = 0; j < cuadriculaBaldosas[i].length; j++) {
        System.out.print("| " + cuadriculaBaldosas[i][j] + " ");
        }
        System.out.println("|");
        }
        sc.close();
    }
}
