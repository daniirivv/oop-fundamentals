package relacionesEntreClases.polimorfismo;

public class Persona {

    public Persona() {
    }

    public void identificarse(){
        System.out.println("Soy una persona");
    }
    /*
     El punto del polimorfismo es que, a pesar de que Persona tenga su método identificarse, cuando se declaran
     como Persona objetos de clases que extienden de ésta, se SOBREESCRIBIRÁ la implementación en favor de la
     extensión más concreta; esto significa que no se ejecutará el método de la clase madre, con la que se han
     declarado los objetos, sino con el de la clase hija.
    */
}
