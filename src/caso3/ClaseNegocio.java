package caso3;
import java.util.Collections;
import java.util.List;

public class ClaseNegocio {
	public static int[][] tileFloor(List<Integer> baldosas,int n) {
		Collections.sort(baldosas);
		int suelo[][]=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j< n;j++){
				if(suelo[i][j]==0){
					int posicion=baldosas.size()-1;
					int tamano=baldosas.get(posicion);
					while(posicion>=0&&!(i+(i-(int)(i/tamano))<=n &&j+(j-(int)(j/tamano))<=n)){
					//while(posicion>=0&& !(i+tamano<=n &&j+tamano<=n)){
						tamano=baldosas.get(posicion);
						posicion--;
					}
					if(i+(i-(int)(i/tamano))<=n &&j+(j-(int)(j/tamano))<=n)
					suelo[i][j]=tamano;
				}
			}
		}
		
		
		
			
		return suelo;
	}
}
