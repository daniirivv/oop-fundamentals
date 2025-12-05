package relacionesEntreClases.interfaces;

public interface Forma {

    /*
    Las interfaces permiten un tipo de herencia especial: la implementación.
    A diferencia de otras herencias, una clase puede implementar varias interfaces a la vez (con extend no se puede)
        - Las interfaces definen métodos que deben ser implementados por las clases que implementen la interfaz.
        - NO PUEDEN DEFINIR ATRIBUTOS COMUNES, a no ser que sean estáticos.
        - Permiten implementar comportamientos polimórficos, definiendo objetos con el tipo de la Interfaz (ver Main)
    */
    public double calcularPerimetro();
    public double calcularArea();

}
