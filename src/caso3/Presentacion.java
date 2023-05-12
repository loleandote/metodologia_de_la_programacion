package caso3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Presentacion {
	public static void main(String[] args) {
		List<Integer> baldosas = new ArrayList<Integer>();

		int tamanioBaldosa = 0, tamanioSuelo = 0;
		Scanner sc = new Scanner(System.in);

		try {
			while (tamanioSuelo <= 0) {
				System.out.println("Dime el tamanyo del suelo mayor que 0");
				tamanioSuelo = sc.nextInt();
			}
		} catch (InputMismatchException e) {
			System.out.println("El tamanyo del suelo tiene que ser un numero");
			sc.close();
			return;
		}
		do {
			System.out.println(
					"Introduce el tamano de una baldosa mayor que 0 para anyadilo a la lista, 0 para terminar");
			try {
				tamanioBaldosa = sc.nextInt();
				if (tamanioBaldosa > 0 && !baldosas.contains(tamanioBaldosa))
					baldosas.add(tamanioBaldosa);
			} catch (InputMismatchException e) {
				System.out.println("El tamanyo de baldosa tiene que ser un numero");
				sc.close();
				return;
			}
		} while (tamanioBaldosa != 0);
		sc.close();

		System.out.println("------------------------------------------------");
		System.out.println("---------------Creacion del suelo---------------");
		System.out.println("------------------------------------------------");
		Collections.sort(baldosas, Comparator.reverseOrder());
		int[][] suelo = new int[tamanioSuelo][tamanioSuelo];
		ClaseNegocio.rellenarSuelo(suelo, baldosas);
		// Imprimiendo el contenido de la matriz 2D `suelo` en la consola. El ciclo externo itera sobre las
		// filas de la matriz y el ciclo interno itera sobre las columnas de la matriz. Para cada elemento de
		// la matriz, imprime el valor en la consola usando `System.out.print()`, y luego pasa a la siguiente
		// columna. Después de imprimir todas las columnas en una fila, pasa a la siguiente fila imprimiendo
		// un carácter de nueva línea usando `System.out.println("")`.
		for (int i = 0; i < suelo.length; i++) {
			for (int j = 0; j < suelo.length; j++)
				System.out.print(suelo[i][j]);
			System.out.println("");
		}
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Color;



public class Presentacion {
	public static void main(String[] args) {
		List<Integer>baldosas= new ArrayList<Integer>();
		baldosas.add(5);
		baldosas.add(3);
		baldosas.add(2);
		baldosas.add(1);
		int ancho=10;
		int alto=10;
		Map <Integer, Integer> baldosasH= new HashMap<Integer,Integer>();
		JFrame pantalla = new JFrame();
		pantalla.setBounds(10,10, 450, 450);
		pantalla.setTitle("El suelo");
		pantalla.setLayout(null);
		pantalla.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pantalla.setSize(600, 600);
		pantalla.getContentPane().setBackground(Color.red);
		//pantalla.getContentPane().add(new Square(10,10,100,100));
		//ClaseNegocio.resolver(ancho,alto, baldosas,baldosasH, pantalla);
		ArrayList<Integer> keys = new ArrayList<Integer>(baldosasH.keySet());
		int areaTotal= ancho*alto;

		for(int i=keys.size()-1; i>=0;i--){
			System.out.println(keys.get(i)+" = "+baldosasH.get(keys.get(i)));
			areaTotal-=(keys.get(i)*keys.get(i)*baldosasH.get(keys.get(i)));
		}
		System.out.println(areaTotal);
		
		
	}
}
