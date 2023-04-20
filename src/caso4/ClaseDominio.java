package caso4;

public class ClaseDominio {
    
    public static void hacerTodo(Beca[]becas, int nivel, int[]becasSelecionadas){
        if(nivel<becas.length-1){
            //hacer cositas
            becasSelecionadas[nivel]=1;
            hacerTodo(becas,++nivel,becasSelecionadas); 
        }else{  
            //hacer otras cositas
            becasSelecionadas[nivel]=1;
        }
    }
}
