package caso3;

import java.util.Scanner;

public class Presentacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longitud, tamBaldosa;

        System.out.print("Introduce la longitud del lado de la superficie cuadrada a soladar: ");
        longitud = scanner.nextInt();

        System.out.print("Introduce el tamaño de la baldosa cuadrada a utilizar: ");
        tamBaldosa = scanner.nextInt();

        int cantBaldosas = longitud / tamBaldosa;
        String[][] cuadriculaBaldosas = new String[cantBaldosas * tamBaldosa][cantBaldosas * tamBaldosa];

        // Llenar la cuadrícula de baldosas con el número correspondiente
        for (int i = 0; i < cantBaldosas; i++) {
            for (int j = 0; j < cantBaldosas; j++) {
                for (int k = i * tamBaldosa; k < (i + 1) * tamBaldosa; k++) {
                    for (int l = j * tamBaldosa; l < (j + 1) * tamBaldosa; l++) {
                        cuadriculaBaldosas[k][l] = Integer.toString(i + 1) + "x" + Integer.toString(j + 1);
                    }
                }
            }
        }

        // Mostrar la cuadrícula de baldosas por pantalla
        System.out.println("Cuadrícula de baldosas:");
        for (int i = 0; i < cantBaldosas * tamBaldosa; i++) {
            for (int j = 0; j < cantBaldosas * tamBaldosa; j++) {
                int numChars = Integer.toString(cantBaldosas).length();
                String tamBaldosaStr = Integer.toString(tamBaldosa) + "x" + Integer.toString(tamBaldosa);
                String baldosa = cuadriculaBaldosas[i][j];
                if (baldosa.equals(tamBaldosaStr)) {
                    System.out.printf("| %-" + numChars + "s ", baldosa);
                } else {
                    System.out.printf("| %-" + numChars + "s ", tamBaldosaStr);
                }
            }
            System.out.print("|\n");
        }

        scanner.close();
    }
}
