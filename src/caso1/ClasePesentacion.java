package caso1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClasePesentacion {
    public static void main(String[] args) {
        long t0, t1, deltaT;
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("Introduce el numero que deseas calcular");
        int numero = leerNumero(leer);
        do {
            System.out.print(
                    "Opciones disponibles:\n0. Salir\n1. Calcular hexagono con ecuación matemática\n"
                            + "2. Calcular el hexagono con iteraciones\n3. Calcular el hexagono con recursión\n4. Introducir otro numero\nIntroduce una opción: ");
            switch (opcion = leerNumero(leer)) {
                case 1:
                    t0 = System.nanoTime();
                    System.out.println("El resultado obtenido resulto a traves de la formula cerrada es: "
                            + ClaseNegocio.formula_cerrada(numero));
                    t1 = System.nanoTime();
                    deltaT = t1 - t0;
                    System.out.println("El tiempo usado para la formula cerrada es " + deltaT + " nanosegundos");
                    break;
                case 2:
                    t0 = System.nanoTime();
                    System.out.println("El resultado obtenido resulto a traves de la formula iterativa es: "
                            + ClaseNegocio.iterativo(numero));
                    t1 = System.nanoTime();
                    deltaT = t1 - t0;
                    System.out.println("El tiempo usado para la formula iterativa es " + deltaT + " nanosegundos");
                    break;
                case 3:
                    t0 = System.nanoTime();
                    try {
                        System.out.println("El resultado obtenido resulto a traves de la formula recursiva es: "
                                + ClaseNegocio.recursivo(numero));
                        t1 = System.nanoTime();
                        deltaT = t1 - t0;
                        System.out.println("El tiempo usado para la formula recursiva es " + deltaT + " nanosegundos");
                    } catch (StackOverflowError e) {
                        System.err.println(
                                "No hay memoria suficiente para calcularlo el número introducido es demasiado grande crack");
                    }
                    break;
                case 4:
                    System.out.println("Introduce el numero que deseas calcular");
                    numero = leerNumero(leer);

                    break;
                case 0:
                    leer.close();
                    System.out.println("Adios");
                    break;
            }
        } while (opcion != 0);

    }

    private static int leerNumero(Scanner sc) {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Introduce un número crack.");
            sc.next();
            return leerNumero(sc);
        }
    }
}
