package relacionesEntreClases.abstraccion;

public class Main {
    void main(){
        /*
         Al ser una clase abstracta, no se pueden instanciar objetos de la clase AnimalAbstracto.
         Sin embargo, herencia de clases abstractas sigue siendo una herencia; podemos declarar las clases hijas
         como instancias de la clase madre como hacíamos en Usuario SuperUsuario
        */
        Perro perro = new Perro("Silver");
        Gato gato = new Gato("Rudy");

        // Perros y gatos comen igual; a misma implementación, se escribe una sola vez en la clase abstracta.
        perro.comer();
        gato.comer();
        System.out.println();

        /*
         Perros y gatos hacen sonidos, aunque de diferente forma; misma cabecera (heredada), diferente implementación:
         - La cabecera del método se define en la clase abstracta como método abstracto --> NO SE IMPLEMENTA
         - La implementación se hace en las clases que heredan de la clase abstracta, mediante la etiqueta @Override.
        */
        perro.hacerSonido();
        gato.hacerSonido();

        /*
        Perros y gatos tienen particularidades; cabecera e implementación del método únicas en sus respectivas clases:
        - Los perros salen a pasear y hacen sus necesidades en la calle
        - Los gatos no salen; hacen sus necesidades en una caja de arena.
         */
        perro.morderMuebles();
        gato.usarCajaDeArena();
    }
}
