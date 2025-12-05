package relacionesEntreClases.herencia;

public class Usuario {

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void iniciarPrograma(){
        System.out.println("Iniciando programa...");
        System.out.println("...");
        System.out.println("...Haciendo cosas...");
        System.out.println("...");
        System.out.println("Programa finalizado.\n");
    }
}
