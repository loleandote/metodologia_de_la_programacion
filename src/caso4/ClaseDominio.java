package caso4;

public class ClaseDominio {
    
    public static void hacerTodoAlt(Beca[]becas, int nivel, int[]becasSelecionadas){
        if(nivel<becas.length-1){
            becasSelecionadas[nivel]=1;
        }else{
                hacerTodoAlt(becas,nivel++,becasSelecionadas);
                
            becasSelecionadas[nivel]=1;
        }
    }
}
