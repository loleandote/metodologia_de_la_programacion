package hitoAlt;

/**
 * La clase ClaseNegocioV2 contiene métodos para contar inversiones en una matriz utilizando el
 * algoritmo de ordenación por fusión.
 */
public class ClaseNegocioV2 {

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
	 * La función realiza una ordenación por combinación en una matriz determinada y cuenta el número de
	 * veces que aparece un valor de 1 o 2 en la mitad derecha de la matriz.
	 * 
	 * @param a una matriz de valores dobles que debe ordenarse y contarse
	 * @param left El índice del elemento más a la izquierda en el subarreglo que se está ordenando.
	 * @param mid El índice del elemento central en la matriz que se está ordenando.
	 * @param right El índice del elemento más a la derecha en el subarreglo que se está ordenando.
	 * @return El método devuelve un valor entero, que representa la cantidad de veces que los valores 1 o
	 * 2 aparecen en la matriz combinada y ordenada.
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
                if (a[k] == 1 || a[k] == 2)
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
