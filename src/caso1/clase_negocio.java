package caso1;

/**
 * La clase contiene tres metodos que calculan el n-esimo numero hexagonal
 */
public class clase_negocio {
	
	/**
	 * La funcion toma un entero como argumento y devuelve el numero hexagonal de ese entero
	 * Presenta una complejidad de O(1)
	 * 
	 * @param x El numero del numero hexagonal que desea encontrar.
	 * @return El n-esimo numero hexagonal.
	 */
	public static int formula_cerrada(int x) {
		int nHexagonal;
		nHexagonal = x * (2 * x - 1);
		return nHexagonal;
	}

	/**
	 * La funcion iterativo() toma un entero x como parametro y devuelve el numero
	 * hexagonal de x
	 * Relacion de recurrencia de la formula 
	 * T(n) = T(n-1) +1 con T(1) = 1
	 * T(n) = (T(n-2) +1) + 1 = T(n-2) + 2 = ... = T(n-(n-1)) + (n-1) = T(1) + n -1 = n
	 * Con una complejidad de O(n)
	 * 
	 * @param x El numero de hexagonos que se agregaron.
	 * @return El numero de mosaicos hexagonales en un hexagono con un lado de
	 *         longitud x.
	 */
	public static int iterativo(int x) {
		int nHexagonal = 0;
		for (int i = 0; i < x; i++)
			nHexagonal = nHexagonal + 4 * i + 1;
		return nHexagonal;
	}

	/**
	 * La funcion se llama recursivamente a si misma hasta que el valor de x es 1, luego devuelve el valor
	 * de nHexagonal
	 * Con una complejidad de O(n)
	 * 
	 * @param x El numero del termino hexagonal que desea encontrar.
	 * @return El n-esimo numero hexagonal.
	 */
	public static int recursivo(int x) {
		int nHexagonal=1;
		if(x>1) 
			nHexagonal=recursivo(x-1)+4*x-3;
		return nHexagonal;
	}

}
