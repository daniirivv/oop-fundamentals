package relacionesEntreClases.interfaces;

public class Cuadrado implements Forma{

    private final double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4*lado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(lado, 2); // Math.pow(a,b) devuelve a^b --> lado^2
    }

}
