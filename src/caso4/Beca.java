package caso4;

public class Beca {
    private int mesInicio;
    private int mesFin;
    private int salarioMensual;
    public Beca(int mesInicio, int mesFin, int salarioMensual){
        this.mesInicio=mesInicio;
        this.mesFin=mesFin;
        this.salarioMensual=salarioMensual;
    }
    public int getMesInicio(){
        return mesInicio;
    }
    public int getMesFin(){
        return mesFin;
    }
    //hola
    public int getSalarioMensual(){
        return salarioMensual;
    }
    public int getSalarioTotal(){
        return (mesFin-mesInicio+1)*salarioMensual;
    }
}
