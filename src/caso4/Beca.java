package caso4;
public class Beca {
    private int id;
    private int mesInicio;
    private int mesFin;
    private double salarioMensual;

    public Beca(int id, int mesInicio, int mesFin, double salarioMensual) {
        this.id = id;
        this.mesInicio = mesInicio;
        this.mesFin = mesFin;
        this.salarioMensual = salarioMensual;
    }

    public int getId() {
        return id;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public double getSalarioTotal() {
        return (mesFin - mesInicio + 1) * salarioMensual;
    }

    public int getDuracion() {
        return mesFin - mesInicio + 1;
    }

    public int getImporteTotal() {
        return (int) (getDuracion() * getSalarioMensual());
    }

    @Override
    public String toString() {
        return "Beca #" + id + "[" + mesInicio + "-" + mesFin + "]:  " + salarioMensual + "€/mes";
    }
}
