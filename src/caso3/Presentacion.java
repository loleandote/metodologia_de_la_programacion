package caso3;

import java.util.ArrayList;
import java.util.List;

public class Presentacion {
	public static void main(String[] args) {
		List<Double>baldosas= new ArrayList<Double>();
		baldosas.add(2.0);
		baldosas.add(1.0);
		ClaseNegocio.devolverBaldosas(3.0, baldosas);
	}
}
