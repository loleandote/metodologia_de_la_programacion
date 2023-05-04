package caso4;

public class pruebas {
    public static int hacerTodoAlt2(Beca[] becas, int nivel, int[] becasSelecionadas) {
        int posibilidad1 = 0, posibilidad2 = 0;
        boolean valido = true;
        if (nivel < becas.length-1) {
            posibilidad1 = hacerTodoAlt2(becas, (nivel + 1), becasSelecionadas);
            for (int i = 0; i < becasSelecionadas.length && valido; i++) {
                if (becasSelecionadas[i] == 1)
                    valido = !(!(becas[i].getMesFin() < becas[nivel].getMesInicio())
                            && !(becas[nivel].getMesFin() < becas[i].getMesInicio()));
            }
            if (valido) {
                becasSelecionadas[nivel] = 1;
                posibilidad2 = becas[nivel].getSalarioTotal() + hacerTodoAlt2(becas, (nivel+1) , becasSelecionadas);
            }
        }

        if (posibilidad1 < posibilidad2) {
            becasSelecionadas[nivel]=1;
            return posibilidad2;
        } else {
            return posibilidad1;
        }
    }
}
