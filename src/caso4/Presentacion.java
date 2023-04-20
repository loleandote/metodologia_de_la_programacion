package caso4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Presentacion {
    public static void main(String[] args) {
        Beca[]becas;
        try {
            becas= leerBecas("DatosCaso4.csv");
            Beca[]becasSelecionadas= new Beca[becas.length];
            int []becasSelecionadasAlt= new int[becas.length];
            ClaseDominio.hacerTodoAlt(becasSelecionadas, 0, becasSelecionadasAlt);
            System.out.println("Hola");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Beca[] leerBecas(String nombre)throws IOException{
        Scanner read = new Scanner(new File(nombre));
		int nCases = Integer.valueOf(read.nextLine());
		Beca[] becas = new Beca[nCases];
		for (int i = 0; i < nCases; i++) {
            String linea= read.nextLine();
            StringTokenizer st= new StringTokenizer(linea);
            while(st.hasMoreTokens()){
                st.nextToken();
                Beca beca= new Beca(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
                becas[i]=beca;
            }
		}
		read.close();
        return becas;
    }
}
