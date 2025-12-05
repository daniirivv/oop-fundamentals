package relacionesEntreClases.abstraccion;

public class Gato extends AnimalAbstracto{

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() { // Implementación concreta de hacerSonido para Gato
        System.out.println("Miau");
    }

    public void usarCajaDeArena(){
        System.out.println("El gato hace sus necesidades en una caja de arena recién limpia.");
    }
}
