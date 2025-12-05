package relacionesEntreClases.interfaces;

public class Main {

    void main(){
        /*
        Las interfaces se encuentran en un nivel de abstracción superior al de las clases abstractas; por lo que
        tampoco son instanciables. Ej: no puede hacerse un new Forma().

        Sin embargo, pueden declararse objetos del tipo de la interfaz, siempre y cuando sean instancias de clases
        que la implementen. Esto permite el tratamiento polimórfico de una forma más clara y directa, ya que la
        interfaz no tiene un comportamiento definido por sí misma; delega la implementación a sus clases concretas.
        */

        // Creamos las formas, declaradas como tal:
        Forma cuadrado = new Cuadrado(4.0);
        Forma triangulo = new Triangulo(4.0, 4.0, 4.0);
        Forma circulo = new Circulo (4.0);

        // Calculamos las medidas de nuestras formas:
        System.out.println("Perímetros (m): ");
        System.out.println(" - Triangulo: " + triangulo.calcularPerimetro());
        System.out.println(" - Cuadrado: " + cuadrado.calcularPerimetro());
        System.out.println(" - Circulo: " + circulo.calcularPerimetro());
        System.out.println();

        System.out.println("Áreas (m^2): ");
        System.out.println(" - Triangulo: " + triangulo.calcularArea());
        System.out.println(" - Cuadrado: " + cuadrado.calcularArea());
        System.out.println(" - Circulo: " + circulo.calcularArea());

        // Se comprueba que, a pesar de que se han declarado todos como Forma, cada área se calcula de forma
        // diferente, según la implementación de su clase.
    }

}
