package caso1;

import java.util.Scanner;

public class Presentacion {
	public static void main(String[] args) {
		long t0,t1,deltaT;
		
		Scanner leer= new Scanner(System.in);
		System.out.println("Introduce un numero\n");
		int numero=leer.nextInt();
		
		t0=System.currentTimeMillis();
		System.out.println("El resultado obtenido resulto a traves de la formula cerrada es: " + clase_negocio.formula_cerrada(numero));
		t1=System.currentTimeMillis();
		deltaT=t1-t0;
		System.out.println("El tiempoo usado para la formula cerrada es");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(deltaT);
		
		t0=System.currentTimeMillis();
		System.out.println(t0);
		System.out.println("El resultado obtenido resulto a traves de la formula iterativa es: "+clase_negocio.iterativo(numero));
		t1=System.currentTimeMillis();
		System.out.println(t1);
		
		deltaT=t1-t0;
		System.out.println("El tiempoo usado para la formula iterativa es");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(deltaT);
		
		t0=System.currentTimeMillis();
		System.out.println("El resultado obtenido resulto a traves de la formula recursiva es: "+clase_negocio.recursivo(numero));
		t1=System.currentTimeMillis();
		deltaT=t1-t0;
		System.out.println("El tiempoo usado para la formula recursiva es");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(deltaT);
		
		
		
	}
}
