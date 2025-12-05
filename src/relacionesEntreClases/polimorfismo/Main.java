
package relacionesEntreClases.polimorfismo;

import relacionesEntreClases.abstraccion.AnimalAbstracto;
import relacionesEntreClases.abstraccion.Gato;
import relacionesEntreClases.interfaces.Forma;
import relacionesEntreClases.interfaces.Triangulo;

public class Main{
    void main() {
        // Creamos una persona genérica
        Persona persona = new Persona();
        persona.identificarse(); // Ejecutará Persona.identificarse

        // Creamos un hombre (declarado como persona)
        Persona hombre = new Hombre();
        hombre.identificarse(); // Ejecutará Hombre.identificarse A PESAR DE SER DECLARADO COMO PERSONA --> Polimorfismo

        // Creamos una mujer (declarado como persona)
        Persona mujer = new Mujer();
        mujer.identificarse(); // Ejecutará Mujer.identificarse A PESAR DE SER DECLARADO COMO PERSONA --> Polimorfismo

        /* Borrando el comentario inferior, comprobamos que, aunque todas las mujeres son personas, no todas las
           personas tienen por qué ser mujeres. */
        // Mujer intentoMujer = persona;


        /*
        OJO: También se le denominarán comportamientos polimórficos a lo visto en los paquetes .abstraccion y
        .interfaces; la diferencia entre esos polimorfismos y éste es que las clases abstractas y las interfaces NO SON
        INSTANCIABLES, lo que hace que no tengamos objetos de esas clases en el sistema y, por tanto, es inmediato
        pensar que el comportamiento de objetos declarados con el tipo de esas clases no instanciables venga dado por el
        tipo de instancia creada.
        */

        Forma forma = new Triangulo(4.0, 4.0, 4.0); // Forma es interfaz (no instanciable); no define comportamiento
        AnimalAbstracto animal = new Gato("Lia"); // AnimalAbstracto es clase abstracta; PUEDE DEFINIRLO o no
        Persona persona2 = new Hombre(); // Persona SI define un comportamiento para identificarse() --> Sobreescrito?
    }
}

