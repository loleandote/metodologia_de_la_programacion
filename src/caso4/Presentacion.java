package caso4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Presentacion {

    public static void main(String[] args) {

        // Leer los datos de becas del archivo CSV
        List<Beca> becas = new ArrayList<>();
        String csvFile = "DatosCaso4.csv";
        String line = "";
        String cvsSplitBy = "\\s+";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            // Saltar la primera línea que contiene el encabezado
            br.readLine();

            // Leer el resto de líneas del archivo CSV
            while ((line = br.readLine()) != null) {

                // Separar los campos de cada línea utilizando como separador uno o más espacios
                String[] datosBeca = line.split(cvsSplitBy);

                // Crear una nueva instancia de Beca utilizando los datos de la línea actual del archivo CSV
                Beca beca = new Beca(Integer.parseInt(datosBeca[0]), Integer.parseInt(datosBeca[1]), Integer.parseInt(datosBeca[2]), Double.parseDouble(datosBeca[3].replace(",", ".")));


                // Agregar la nueva beca a la lista de becas
                becas.add(beca);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Calcular la combinación óptima de becas
        ClaseDominio dominio = new ClaseDominio(becas);
        List<Beca> becasOptimas = dominio.calcularCombinacionOptima(1500);

        // Imprimir la combinación óptima de becas
        System.out.println("La combinación óptima de becas es:");
        for (Beca beca : becasOptimas) {
            System.out.println(beca.toString());
        }

    }
}
