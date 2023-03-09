package caso2;

public class ClasseNegocio {
		
	public static int mergeAndCounts(int a[],int p,int q, int r) {
		int i = p, j = q+1, k = p;
		int [ ] temp = new int [r-p+1];
		int count=0;	
		for (int l = p; l <= r; l++)
			temp[l-p] = a[l];
			
		while (i <= q && j <= r) {
			if (temp[i-p] <= temp[j-p]) {
				a[k] = temp[i-p]; i++;
			} else {
				a[k] = temp[j-p]; j++;
				count++;
			}
			k++;
		}
		if (j-1 == r){
			while (i <= q) {
				a[k] = temp[i-p]; k++; i++;
			}
		}
		return count;
	}
			
	public static int countInversions(int a[],int p, int r) {
		int	middle=(p+r)/2;
		int count =0;
		if(p<r) {
			count=countInversions(a,p,middle);
			count=count+countInversions(a,middle+1,p);
			count=count+mergeAndCounts(a,p,middle,r);
		}
		return count;
		}
	
}
