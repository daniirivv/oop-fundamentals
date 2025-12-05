package relacionesEntreClases.abstraccion;

public class Perro extends AnimalAbstracto{

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() { // Implementación concreta de hacerSonido para Perro
        System.out.println("Guau");
    }

    public void morderMuebles(){
        System.out.println("El perro muerde los muebles.");
    }
}
