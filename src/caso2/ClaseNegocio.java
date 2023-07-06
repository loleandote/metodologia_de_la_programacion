package caso2;

/**
 * Toma una matriz de dobles la ordena de menor a mayor y devuelve el numero de inversiones en la matriz
 */
public class ClaseNegocio {
	/**
	 * La función cuenta el número de inversiones en una matriz utilizando el algoritmo de clasificación
	 * por combinación.
	 * 
	 * @param a una matriz de dobles para las que queremos contar inversiones
	 * @param left El índice del elemento más a la izquierda en el arreglo o subarreglo que se está
	 * considerando.
	 * @param right El índice del elemento más a la derecha en el subarreglo que se está considerando.
	 * @return El método devuelve un valor entero, que representa el número de inversiones en la matriz
	 * dada.
	 */
	public static int countInversions(double a[], int left, int right) {
		int veces = 0;
		if (left < right) {
			int mid = (left + right) / 2;
			veces = countInversions(a, left, mid);
			veces += countInversions(a, mid + 1, right);
			veces += MergeAndCounts(a, left, mid, right);

		}
		return veces;
	}

	
	/**
	 * La función fusiona dos subarreglos ordenados y cuenta el número de inversiones.
	 * 
	 * @param a Una matriz de valores dobles.
	 * @param left El parámetro "izquierda" representa el índice inicial del subarreglo que debe
	 * fusionarse y contarse.
	 * @param mid El parámetro "mid" representa el índice del elemento central en la matriz "a".
	 * @param right El parámetro "right" representa el índice del elemento más a la derecha en el arreglo
	 * o subarreglo que se está considerando.
	 * @return El método devuelve el número de inversiones en la matriz.
	 */
	public static int MergeAndCounts(double a[], int left, int mid, int right) {
		int i = left, j = mid + 1, k = left, veces = 0;
		double[] temp = new double[right - left + 1];
		for (int l = left; l <= right; l++)
			temp[l - left] = a[l];

		while (i <= mid && j <= right) {
			if (temp[i - left] <= temp[j - left]) 
				a[k] = temp[i++ - left];
			else {
				a[k] = temp[j++ - left];
				veces+= (mid+1 - i);
			}
			k++;
		}
		if (j - 1 == right) {
			while (i <= mid) {
				a[k] = temp[i - left];
				k++;
				i++;
			}
		}
		return veces;
	}

}
