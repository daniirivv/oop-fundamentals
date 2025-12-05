package relacionesEntreClases.polimorfismo;

public class Mujer extends Persona{

    public Mujer() {
    }

    // Sin @Override; es equivalente
    public void identificarse(){
        System.out.println("Soy una mujer");
    }
}
