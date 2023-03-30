package caso2;

import java.io.File;
import java.util.Scanner;

public class Presentacion {
	public static void main(String[] args) throws Exception {
//
		double a[] = lectorDat("InversionsHito1.dat");
		System.out.println("Array:");
		int inversiones = ClaseNegocio.countInversions(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("Inversiones: "+ inversiones);
	}

	/**
	 * Lee un archivo y devuelve una matriz de dobles.
	 * 
	 * @param nombre el nombre del archivo que desea leer
	 * @return El metodo devuelve una matriz de dobles.
	 */
	public static double[] lectorDat(String nombre) throws Exception {
		Scanner read = new Scanner(new File(nombre));
		int nCases = read.nextInt();
		double[] a = new double[nCases];
		for (int i = 0; i < nCases; i++) {
			a[i] = read.nextDouble();
		}
		read.close();
		return a;
	}

}