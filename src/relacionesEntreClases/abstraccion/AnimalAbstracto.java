package relacionesEntreClases.abstraccion;

public abstract class AnimalAbstracto {

    /*
    Las clases abstractas NO SON INSTANCIABLES, esto quiere decir que no podemos hacer un new AnimalAbstracto();
    Funcionan por extensión:
        - Una clase hija no puede heredar por extensión de más de una clase (concreta o abstracta) al mismo tiempo.
        - Al funcionar por extensión, las clases que las extienden heredan también sus atributos y métodos.
        - Pueden delegar la implementación de métodos a las clases que lo extienden mediante métodos abstractos
          (igual que las interfaces)
        - Permiten implementar comportamientos polimórficos, definiendo objetos con el tipo de la Interfaz.
    */
    private String nombre;

    public AnimalAbstracto(String nombre) {
        this.nombre = nombre;
    }

    public void comer(){
        System.out.println("Comiendo...");
    }

    public abstract void hacerSonido(); // Se define un método común para todos los animales, pero no su implementación
}
