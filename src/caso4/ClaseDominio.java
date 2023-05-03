package caso4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClaseDominio {
    private List<Beca> becas;

    public ClaseDominio(List<Beca> becas) {
        this.becas = new ArrayList<>(becas);
    }

    public List<Beca> getBecas() {
        return becas;
    }

    public List<Beca> getBecasOrdenadas() {
        List<Beca> becasOrdenadas = new ArrayList<>(becas);
        Collections.sort(becasOrdenadas, new Comparator<Beca>() {
            public int compare(Beca beca1, Beca beca2) {
                return Double.compare(beca2.getImporteTotal(), beca1.getImporteTotal());
            }
        });
        return becasOrdenadas;
    }

    public List<Beca> calcularCombinacionOptima(double presupuesto) {
        List<Beca> becasOrdenadas = getBecasOrdenadas();
        List<Beca> combinacionOptima = new ArrayList<>();
        double importeTotal = 0;

        for (Beca beca : becasOrdenadas) {
            if (importeTotal + beca.getImporteTotal() <= presupuesto) {
                combinacionOptima.add(beca);
                importeTotal += beca.getImporteTotal();
            }
        }

        return combinacionOptima;
    }
}
