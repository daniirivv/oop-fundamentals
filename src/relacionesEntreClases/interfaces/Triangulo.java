package relacionesEntreClases.interfaces;

public class Triangulo implements Forma{

    private final double lado1;
    private final double lado2;
    private final double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public double calcularArea() { // Fórmula de Herón: https://es.wikipedia.org/wiki/F%C3%B3rmula_de_Her%C3%B3n
        double semiPerim = calcularPerimetro()/2;
        return Math.sqrt(semiPerim *(semiPerim - lado1)*(semiPerim - lado2)*(semiPerim - lado3));
    }
}
