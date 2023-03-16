package caso2;

public class ClaseNegocio {

	public static int countInversions(double a[], int p, int r) {
		int veces = 0;
		if (p < r) {
			veces++;
			int mid = (p + r) / 2;
			veces = countInversions(a, p, mid);
			veces += countInversions(a, mid + 1, r);
			veces += MergeAndCounts(a, p, mid, r);

		}
		return veces;
	}

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
