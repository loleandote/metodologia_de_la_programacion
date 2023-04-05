package hitoAlt;

public class ClaseNegocioAlt {
    /**
     * La función fusiona dos subarray ordenados de un array dado y cuenta el número de
     * inversiones.
     * 
     * @param arr una matriz de valores dobles que debe ordenarse
     * @param left El índice inicial del subarreglo que se fusionará.
     * @param mid El índice que representa el elemento central de la matriz que se está ordenando.
     * @param right El índice del elemento más a la derecha en el subarreglo que se ordena/combina.
     * @return El método devuelve un valor entero que representa el número de inversiones en la matriz
     * dada.
     */
    private static int merge(double arr[], int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        int invCount = 0;
        double temp[] = new double[(right - left + 1)];
 
        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k] = arr[i++];
            else {
                temp[k] = arr[j++];
                if(temp[k]==1||temp[k]==2)
                invCount += (mid - i);
            }
            ++k;
        }
 
        while (i < mid) {
            temp[k++] = arr[i++];
        }
 
        while (j <= right) {
            temp[k++] = arr[j++];
        }
 
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
 
        return invCount;
    }
   /**
    * La función cuenta el número de inversiones en una matriz determinada utilizando el algoritmo de
    * clasificación por combinación.
    * 
    * @param arr una matriz de valores dobles para los que queremos contar las inversiones.
    * @param left El índice del elemento más a la izquierda en el arreglo o subarreglo que se está
    * considerando.
    * @param right El índice del elemento más a la derecha en el subarreglo que se está considerando.
    * @return El método devuelve un valor entero que representa el número total de inversiones en la
    * matriz dada.
    */
    public static int countInversions(double arr[], int left, int right) {
        int invCount = 0;
 
        if (right > left) {
            int mid = (right + left) / 2;
 
            invCount = countInversions(arr, left, mid);
            invCount += countInversions(arr, mid + 1, right);
            invCount += merge(arr, left, mid+1 , right);
        }
        return invCount;
    }
}
