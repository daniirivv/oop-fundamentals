package relacionesEntreClases.herencia;

import java.util.Scanner;

public class SuperUsuario extends Usuario{

    // No ponemos el atributo "nombre" de la clase madre "Usuario"; al heredar de ella, ya lo tiene.
    private String password; // Ampliamos la funcionalidad de la clase madre añadiendo atributos específicos


    public SuperUsuario(String nombre, String password) {
        super(nombre); // Llama al constructor de la clase madre para inicializar los atributos heredados
        this.password = password;
    }

    // Getter y Setter del nuevo atributo
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Ampliamos la funcionalidad de la clase madre mediante nuevos métodos en la clase hija
    public void iniciarNProgramas(int n){
        if(comprobarPassword()){
            for(int i=0; i<n; i++){
                super.iniciarPrograma(); // La clase hija también hereda los métodos de la clase madre; puede usarlos
            }
        }
    }

    private boolean comprobarPassword(){ // ENCAPSULACIÓN
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la contraseña: ");
        String password = sc.nextLine();
        if(password.equals(this.password)){
            return true;
        }
        else{
            System.out.println("Contraseña incorrecta");
            return false;
        }
    }

}
