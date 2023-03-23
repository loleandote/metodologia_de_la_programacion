package caso2;

/**
 * Toma una matriz de dobles la ordena de menor a mayor y devuelve el número de inversiones en la matriz
 */
public class ClaseNegocio {

	/**
	 * Si la matriz es de tamaño 1, entonces no hay inversiones. De lo contrario, divide la matriz en dos
	 * mitades, cuenta la cantidad de inversiones en cada mitad y las suma. Luego, cuenta la cantidad de
	 * inversiones en las dos mitades y lo suma al total
	 * 
	 * @param a la matriz a ordenar
	 * @param p el comienzo de la matriz
	 * @param r el último índice de la matriz
	 * @return cantidad de inversiones en la matriz.
	 */
	public static int countInversions(double a[], int p, int r) {
		int veces = 0;
		if (p < r) {
			int mid = (p + r) / 2;
			veces = countInversions(a, p, mid);
			veces += countInversions(a, mid + 1, r);
			veces += MergeAndCounts(a, p, mid, r);

		}
		return veces;
	}

	/**
	 * Toma una matriz, un indice inicial, un indice medio y un indice final, combina las dos submatrices
	 * en una matriz ordenada y devuelve el número de inversiones en las submatrices.
	 * 
	 * @param a la matriz a ordenar
	 * @param p el primer índice de la matriz
	 * @param q el medio de la matriz
	 * @param r el último índice de la matriz
	 * @return El número de veces que se ordena la matriz.
	 */
	public static int MergeAndCounts(double a[], int p, int q, int r) {

		int i = p, j = q + 1, k = p, veces = 0;
		double[] temp = new double[r - p + 1];
		for (int l = p; l <= r; l++)
			temp[l - p] = a[l];

		while (i <= q && j <= r) {
			if (temp[i - p] <= temp[j - p]) {
				a[k] = temp[i - p];
				i++;
			} else {
				a[k] = temp[j - p];
				j++;
				veces++;
			}
			k++;
		}
		if (j - 1 == r) {
			while (i <= q) {
				a[k] = temp[i - p];
				k++;
				i++;
			}
		}
		return veces;
	}

}
