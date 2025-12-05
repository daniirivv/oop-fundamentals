package relacionesEntreClases.herencia;

public class Main {
    void main(){
        // Creamos un usuario base y arrancamos con él un programa
        Usuario darren = new Usuario("Darren LaChance");
        darren.iniciarPrograma();

        // Darren no tiene una funcionalidad expandida; es un usuario base. Vamos a crear un SuperUsuario:
        SuperUsuario willyGod = new SuperUsuario("William Glass", "DisparoSagrado");
        willyGod.iniciarNProgramas(3); // Extiende la funcionalidad del Usuario normal para abrir n programas.

        /*
         A pesar de ser un objeto de la clase SuperUsuario y estar declarado como tal, también se tiene
         acceso a los métodos de la clase madre (o súper).
        */
        willyGod.iniciarPrograma(); // Ejecución de usuario "normal" desde SuperUsuario

        /*
        Sin embargo, puesto que un SuperUsuario hereda de un Usuario normal, podemos declararlo también como Usuario
        en lugar de SuperUsuario; esto es como cuando tu profe se registra en Moodle como alumno para visualizar la
        misma pantalla que sus alumnos: simula tener sus MISMOS PERMISOS
         */

        Usuario willyNerfeado = willyGod; // Willy se declara como Usuario normal
        willyNerfeado.iniciarPrograma(); // Sigue teniendo acceso al método de Usuario; ya lo tenía siendo SuperUser.

        // willyNerfeado.iniciarNProgramas(); // DA ERROR (quitar comentarion para comprobar)
        // Ahora que Willy se ha declarado como usuario normal, ya no tiene acceso a sus métodos de SuperUsuario.
    }
}
