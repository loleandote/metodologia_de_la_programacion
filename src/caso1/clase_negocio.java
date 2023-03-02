package caso1;

/**
 * La clase contiene tres métodos que calculan el n-ésimo número hexagonal
 */
public class clase_negocio {
	
	/**
	 * La función toma un entero como argumento y devuelve el número hexagonal de ese entero
	 * Presenta una complejidad de O(1)
	 * 
	 * @param x El número del número hexagonal que desea encontrar.
	 * @return El enésimo número hexagonal.
	 */
	public static int formula_cerrada(int x) {
		int nHexagonal;
		nHexagonal = x * (2 * x - 1);
		return nHexagonal;
	}

	/**
	 * La función iterativo() toma un entero x como parámetro y devuelve el número
	 * hexagonal de x
	 * Relacion de recurrencia de la formula 
	 * T(n) = T(n-1) +1 con T(1) = 1
	 * T(n) = (T(n-2) +1) + 1 = T(n-2) + 2 = …= T(n-(n-1)) + (n-1) = T(1) + n -1 = n
	 * Con una complejidad de O(n)
	 * 
	 * @param x El número de hexágonos que se agregarán.
	 * @return El número de mosaicos hexagonales en un hexágono con un lado de
	 *         longitud x.
	 */
	public static int iterativo(int x) {
		int nHexagonal = 0;
		for (int i = 0; i < x; i++)
			nHexagonal = nHexagonal + 4 * i + 1;
		return nHexagonal;
	}

	/**
	 * La función se llama recursivamente a sí misma hasta que el valor de x es 1, luego devuelve el valor
	 * de nHexagonal
	 * Con una complejidad de O(n)
	 * 
	 * @param x El número del número hexagonal que desea encontrar.
	 * @return El enésimo número hexagonal.
	 */
	public static int recursivo(int x) {
		int nHexagonal=1;
		if(x>1) 
			nHexagonal=recursivo(x-1)+4*x-3;
		return nHexagonal;
	}

}
