package caso3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class PresentacionAlt {
   public static void main(String[] args) {
      List<Integer> baldosas = new ArrayList<Integer>();
      //baldosas.add(500);
      baldosas.add(300);
      baldosas.add(200);
      baldosas.add(100);
      baldosas.sort(Comparator.reverseOrder());
      int ancho = 500;
      int alto = 500;
      Map<Integer, Integer> baldosasH = new HashMap<Integer, Integer>();
      PresentacionResultados presentacion = new PresentacionResultados(ancho, alto);
      ClaseNegocio.resolver(ancho, alto, baldosas, baldosasH, presentacion);
      presentacion.mostar();
      ArrayList<Integer> keys = new ArrayList<Integer>(baldosasH.keySet());
		int areaTotal= ancho*alto;
      String mensaje="";
		for(int i=keys.size()-1; i>=0;i--){
         mensaje+=keys.get(i)+" = "+baldosasH.get(keys.get(i))+"\n";
			System.out.println(keys.get(i)+" = "+baldosasH.get(keys.get(i)));
			areaTotal-=(keys.get(i)*keys.get(i)*baldosasH.get(keys.get(i)));
		}
      mensaje+="area restante "+(areaTotal/100);
		System.out.println("area restante "+areaTotal/100);
      JOptionPane.showMessageDialog(null,
                mensaje,
                "PopUp Dialog",
                JOptionPane.INFORMATION_MESSAGE);
   }
}

class PresentacionResultados extends JFrame {
   private Squares squares;
   
   public PresentacionResultados(int ancho, int alto) {
      super("El suelo crack XD");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      squares = new Squares(ancho, alto);
   }

   public void mostar() {
      getContentPane().add(squares);
      pack();
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public void añadirFigura(int x, int y, int weight, int height) {
      squares.addSquare(x, y, weight, height);
   }
}

class Squares extends JPanel {
   private int PREF_W;
   private int PREF_H;
   private List<Rectangle> squares = new ArrayList<Rectangle>();
   private final Color[] colores={Color.RED,Color.GREEN, Color.CYAN,Color.MAGENTA,Color.YELLOW,new Color(93,193,185),new Color(51,255,153)};
   private final Color[] coloresAlt={Color.RED,new Color(205,92, 92,80), Color.CYAN,Color.MAGENTA,Color.YELLOW,new Color(93,193,185),new Color(51,255,153)};
   public Squares(int ancho, int alto) {
      PREF_W = ancho;
      PREF_H = alto;
   }

   public void addSquare(int x, int y, int width, int height) {
      Rectangle rect = new Rectangle(x, y, width, height);
      squares.add(rect);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (Rectangle rect : squares) {
         //Color color = colores[(int)((rect.getWidth()/100)%colores.length)];
         Color color = coloresAlt[(int)((rect.getWidth()/100)%colores.length)];

         g2.setColor(color);
         g2.fill(rect);
         g2.setPaint(Color.GRAY);
         g2.draw(rect);
      }
   }
}