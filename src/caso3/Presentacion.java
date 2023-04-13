package caso3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Presentacion {
	public static void main(String[] args) {
		

		Scanner leer = new Scanner(System.in);
		System.out.println("Introduce cuanto mide el lado del suelo");
		int lado_suelo = leer.nextInt();
		List<Integer> baldosas = new ArrayList<Integer>();
		int baldosa=0;
		String texto="";
		
		/*do {
			System.out.println("Introduce el tamaño de una baldosa, \"FIN\" para salir");
			try {
				baldosa= Integer.parseInt(texto);
				baldosas.add(baldosa);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				if(texto.toUpperCase().equals("FIN"))
					System.out.println("Ya esta");
			}
		} while (!texto.toUpperCase().equals("FIN"));*/
		baldosas.add(1);
		baldosas.add(2);
		baldosas.add(4);
		baldosas.add(5);
		int solucion[][]=ClaseNegocio.tileFloor(baldosas,lado_suelo);
		for (int i = 0; i < lado_suelo; i++){
			System.out.print("\n");
			for (int j = 0; j < lado_suelo; j++){
				System.out.print(solucion[i][j]);
			}
		}
		leer.close();
	}
}
