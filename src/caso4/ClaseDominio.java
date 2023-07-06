package caso4;

public class ClaseDominio {
    /**
     * La función selecciona recursivamente una combinación de becas que maximiza el
     * salario total, al
     * tiempo que garantiza que las becas seleccionadas no se superpongan en el
     * tiempo.
     * 
     * @param becas             una matriz de objetos Beca
     * @param nivel             El nivel o índice actual de la recurrencia, que
     *                          indica qué objeto Beca de la matriz
     *                          se está considerando.
     * @param becasSelecionadas Una matriz de números enteros que representan las
     *                          becas seleccionadas.
     *                          Un valor de 1 en el índice i indica que la beca en
     *                          el índice i del arreglo "becas" ha sido
     *                          seleccionada, mientras que un valor de 0 indica que
     *                          no ha sido seleccionada.
     * @return El método devuelve un valor entero, que representa el salario total
     *         máximo posible que
     *         se puede obtener al seleccionar una combinación de becas de la matriz
     *         de becas dada. También
     *         actualiza la matriz de becas seleccionadas con los índices de las
     *         becas seleccionadas.
     */
    public static int hacerTodo(Beca[] becas, int nivel, int[] becasSelecionadas) {
        int posibilidad1 = 0, posibilidad2 = 0;
        boolean valido = true;
        int[] becaSelecionadas = new int[becasSelecionadas.length];
        for (int i = 0; i < becaSelecionadas.length; i++) {
            becaSelecionadas[i] = becasSelecionadas[i];
        }
        if (nivel < becas.length) {
            posibilidad1 = hacerTodo(becas, (nivel + 1), becasSelecionadas);
            for (int i = 0; i < becaSelecionadas.length && valido; i++) {
                if (becaSelecionadas[i] == 1)
                    valido = comprobarValidez(becas[i], becas[nivel]);
            }
            if (valido) {
                becaSelecionadas[nivel] = 1;
                posibilidad2 = becas[nivel].getSalarioTotal() + hacerTodo(becas, (nivel + 1), becaSelecionadas);

            }
        }
        if (posibilidad1 < posibilidad2) {
            for (int i = 0; i < becaSelecionadas.length; i++)
                becasSelecionadas[i] = becaSelecionadas[i];
            return posibilidad2;
        } else {
            return posibilidad1;
        }
    }

    /**
     * La función verifica la validez de dos becas comparando sus meses de inicio y fin.
     * 
     * @param a Un objeto de tipo "Beca" que representa una beca o subvención.
     * @param b El parámetro "b" es un objeto de tipo "Beca".
     * @return El método devuelve un valor booleano.
     */
    private static boolean comprobarValidez(Beca a, Beca b){
        return !(!(a.getMesFin() < b.getMesInicio())
                            && !(b.getMesFin() < a.getMesInicio()));
    }
}
