package relacionesEntreClases.polimorfismo;

public class Hombre extends Persona{

    public Hombre() {
    }

    @Override // No hace falta ponerlo
    public void identificarse(){
        System.out.println("Soy un hombre");
    }
}
