package caso3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Color;



public class Presentacion {
	public static void main(String[] args) {
		List<Integer>baldosas= new ArrayList<Integer>();
		baldosas.add(5);
		baldosas.add(3);
		baldosas.add(2);
		baldosas.add(1);
		int ancho=10;
		int alto=10;
		Map <Integer, Integer> baldosasH= new HashMap<Integer,Integer>();
		JFrame pantalla = new JFrame();
		pantalla.setBounds(10,10, 450, 450);
		pantalla.setTitle("El suelo");
		pantalla.setLayout(null);
		pantalla.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pantalla.setSize(600, 600);
		pantalla.getContentPane().setBackground(Color.red);
		//pantalla.getContentPane().add(new Square(10,10,100,100));
		//ClaseNegocio.resolver(ancho,alto, baldosas,baldosasH, pantalla);
		ArrayList<Integer> keys = new ArrayList<Integer>(baldosasH.keySet());
		int areaTotal= ancho*alto;

		for(int i=keys.size()-1; i>=0;i--){
			System.out.println(keys.get(i)+" = "+baldosasH.get(keys.get(i)));
			areaTotal-=(keys.get(i)*keys.get(i)*baldosasH.get(keys.get(i)));
		}
		System.out.println(areaTotal);
		
		
	}
}
