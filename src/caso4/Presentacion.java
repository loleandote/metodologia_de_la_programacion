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
            int []becasSelecionadas= new int[becas.length];
            int  resultado=ClaseDominio.hacerTodo(becas, 0, becasSelecionadas);
            System.out.println("El máximo que puedes recibir es "+resultado);
            for (int i=0; i<becasSelecionadas.length;i++) {
                if(becasSelecionadas[i]>0)
                    System.out.println("Debes seleccionar la "+(i+1)+"ª beca, la cual empieza el mes "+becas[i].getMesInicio()
                    +" y termina el "+becas[i].getMesFin()+", con una cuantia total de "+becas[i].getSalarioTotal()+" y una cuantia menusal de "+becas[i].getSalarioMensual()+".");
            }
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
