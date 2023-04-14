package ejerciciobaldosas;
import java.util.Scanner;
public class ejerciciobaldosas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {

            // Preguntar al usuario la longitud de un lado de la superficie cuadrada
            System.out.println("Introduce la longitud de un lado de la superficie cuadrada: ");
            int superficie = sc.nextInt();

            // Preguntar al usuario el tamaño de las baldosas
            System.out.println("Introduce el tamanio de las baldosas: ");
            int tamBaldosa1 = sc.nextInt();
            int tamBaldosa2 = sc.nextInt();


            //Crear la matriz para representar el solado
            int[][] solado = new int[superficie][superficie];

            //Contadores para llevar el numero de baldosas utilizadas de cada tipo
            int numBaldosas1 = 0;
            int numBaldosas2 = 0;

            // Recorrer la superficie para colocar baldosas del primer tipo
            for (int i = 0; i < superficie; i += tamBaldosa1) {
                for (int j = 0; j < superficie; j += tamBaldosa1) {
                    if (i + tamBaldosa1 <= superficie && j + tamBaldosa1 <= superficie) {
                        numBaldosas1++;
                        for (int k = i; k < i + tamBaldosa1; k++) {
                            for (int l = j; l < j + tamBaldosa1; l++) {
                                solado[k][l] = tamBaldosa1;
                            }
                        }
                    } else {
                        // Sino queda suficiente superficie, salir del bucle
                        break;
                    }
                }
            }

            // Recorrer la superficie para colocar baldosas del segundo tipo
            for (int i = 0; i < superficie; i += tamBaldosa2) {
                for (int j = 0; j < superficie; j += tamBaldosa2) {
                    if (i + tamBaldosa2 <= superficie && j + tamBaldosa2 <= superficie) {
                        numBaldosas2++;
                        for (int k = i; k < i + tamBaldosa2; k++) {
                            for (int l = j; l < j + tamBaldosa2; l++) {
                                if (solado[k][l] == 0) {
                                    solado[k][l] = tamBaldosa2;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            }


            //Calcular el numero total de balsosas utilizadas
            int numTotalBaldosas = numBaldosas1 + numBaldosas2;
            System.out.println("Número de baldosas necesarias: " + numTotalBaldosas);

            System.out.println("Cuadrícula de baldosas:");
            for (int i = 0; i < superficie; i++) {
                for (int j = 0; j < superficie; j++) {
                    System.out.print("| " + solado[i][j] + " ");
                }
                System.out.println("|");
            }
            
            System.out.println("¿Desea calcular otra superficie y baldosas? (s/n)");
            char respuesta = sc.next().charAt(0);
            if (respuesta == 'n' || respuesta == 'N') {
                continuar = false;
            }
        }
        
        // Cerrar el scanner
        sc.close();
    }
}
