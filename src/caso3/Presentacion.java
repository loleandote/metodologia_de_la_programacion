package caso3;

import java.util.Scanner;

public class Presentacion {
	public static void main(String[] args) {

		int parcela;

		Scanner leer = new Scanner(System.in);
		System.out.println("Cuantos metro desea que tenga la parcela");
		parcela = leer.nextInt();
		System.out.println("¿Cual es el numero de balsosas que temdremos?");
		System.out.println("Inserte las dimensiones de las balsosas en m");

		leer.close();
		
	}
}
