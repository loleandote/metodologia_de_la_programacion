package caso1;

import java.util.Scanner;

/**
 * En esta clase estara contenida la parte visual del programa, en el cual el
 * "Usuario" podra obtener los resultados de las tres formulas, despues de 
 * seleccionar el numero de su preferencia.
 */
public class Presentacion {
	public static void main(String[] args) {
		long t0, t1, deltaT;

		Scanner leer = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int numero = leer.nextInt();

		t0 = System.nanoTime();
		System.out.println("El resultado obtenido resulto a traves de la formula cerrada es: "
				+ ClaseNegocio.formula_cerrada(numero));
		t1 = System.nanoTime();
		deltaT = t1 - t0;
		System.out.println("El tiempo usado para la formula cerrada es " + deltaT);

		t0 = System.nanoTime();
		System.out.println("El resultado obtenido resulto a traves de la formula iterativa es: "
				+ ClaseNegocio.iterativo(numero));
		t1 = System.nanoTime();
		deltaT = t1 - t0;
		System.out.println("El tiempo usado para la formula iterativa es " + deltaT);

		t0 = System.nanoTime();
		System.out.println("El resultado obtenido resulto a traves de la formula recursiva es: "
				+ ClaseNegocio.recursivo(numero));
		t1 = System.nanoTime();
		deltaT = t1 - t0;
		System.out.println("El tiempo usado para la formula recursiva es " + deltaT);
		leer.close();

	}
}
