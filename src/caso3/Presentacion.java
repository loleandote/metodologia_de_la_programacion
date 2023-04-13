package caso3;

import java.util.Scanner;

public class Presentacion {
	public static void main(String[] args) {
		

		Scanner leer = new Scanner(System.in);
		System.out.println("Introduce cuanto mide el lado del suelo");
		int lado_suelo = leer.nextInt();
		int baldosas[] = {1,2,4,5};
		int solucion[][]=ClaseNegocio.tileFloor(baldosas,lado_suelo);
		for (int i = 0; i < lado_suelo; i++){
			System.out.print("\n");
			for (int j = 0; j < lado_suelo; j++){
				System.out.print(solucion[i][j]);
			}
		}
	}
}
