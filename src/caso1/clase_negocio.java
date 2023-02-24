package caso1;

public class clase_negocio {

	public static int formula_cerrada(int x) {
		int n;
		n=x*(2*x-1);
		return n;
	}
	public static int iterativo(int x) {
		int r=0;
		for(int i=0;i<x;i++) {
		r=r+4*i+1;	
		}
		return r;
	}
	public static int recursivo(int x) {
		int r=1;
		if(x>1) {
			r=recursivo(x-1)+4*x-3;
		}
		return r;
	}

}
