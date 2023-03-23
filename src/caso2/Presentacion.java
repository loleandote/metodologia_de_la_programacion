package caso2;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Presentacion {
	public static void main(String[] args) throws Exception {

		double a[] = lectorDat("InversionsTest_6.dat");
		//double a[]={3,2,1};
		System.out.println("Inversiones: "+ ClaseNegocio.countInversions(a, 0, a.length - 1)+"\nArray:");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	/**
	 * Lee un archivo y devuelve una matriz de dobles.
	 * 
	 * @param nombre el nombre del archivo que desea leer
	 * @return El método devuelve una matriz de dobles.
	 */
	public static double[] lectorDat(String nombre) throws Exception {
		Scanner read = new Scanner(new File(nombre));
		int nCases = read.nextInt();
		double[] a = new double[nCases];
		for (int i = 0; i < nCases; i++) {
			a[i] = read.nextDouble();
		}
		return a;
	}

}