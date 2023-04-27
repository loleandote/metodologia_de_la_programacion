package caso4;

public class ClaseDominio {
    //Sin becas seleccionadas
    public static int hacerTodo(Beca[] becas, int nivel, int[] becasSelecionadas) {
        int posibilidad1 = 0, posibilidad2 = 0;
        boolean valido = true;
        int[] becaSelecionadas = new int[becasSelecionadas.length];
        for (int i = 0; i < becaSelecionadas.length; i++) {
            becaSelecionadas[i] = becasSelecionadas[i];
        }

        if (nivel < becas.length) {
            posibilidad1 = hacerTodo(becas, (nivel + 1), becaSelecionadas);
            for (int i = 0; i < becaSelecionadas.length && valido; i++) {
                if (becaSelecionadas[i] == 1)
                    valido = !(!(becas[i].getMesFin() < becas[nivel].getMesInicio())
                            && !(becas[nivel].getMesFin() < becas[i].getMesInicio()));
            }
            if (valido) {
                becaSelecionadas[nivel] = 1;
                posibilidad2 = becas[nivel].getSalarioTotal() + hacerTodo(becas, (nivel + 1), becaSelecionadas);
            }
        }

        if (posibilidad1 < posibilidad2) {
            becasSelecionadas[nivel] = 1;
            return posibilidad2;
        } else {
            return posibilidad1;
        }
    }

    public static int hacerTodoAlt(Beca[] becas, int nivel, int[] becasSelecionadas) {
        int posibilidad1 = 0, posibilidad2 = 0;
        boolean valido = true;

        if (nivel < becas.length) {
            posibilidad1 = hacerTodo(becas, (nivel + 1), becasSelecionadas);
            for (int i = 0; i < becasSelecionadas.length && valido; i++) {
                if (becasSelecionadas[i] == 1)
                    valido = !(!(becas[i].getMesFin() < becas[nivel].getMesInicio())
                            && !(becas[nivel].getMesFin() < becas[i].getMesInicio()));
            }
            if (valido) {
                becasSelecionadas[nivel] = 1;
                posibilidad2 = becas[nivel].getSalarioTotal() + hacerTodo(becas, (nivel + 1), becasSelecionadas);
            }
        }

        if (posibilidad1 < posibilidad2) {
            return posibilidad2;
        } else {
            if (nivel < becas.length)
                becasSelecionadas[nivel] = 0;
            return posibilidad1;
        }
    }
}
