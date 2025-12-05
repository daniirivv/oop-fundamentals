En POO, los objetos que creamos interactúan entre sí para realizar las tareas que implementan la funcionalidad de un programa. Vamos a ilustrarlo con un ejemplo.
Pongamos que existen dos Tipos Abstractos de Datos: el TAD Persona y el TAD Coche, los siguientes atributos y métodos:
## Ejemplo en código de una relación básica entre clases
---

NOTA: Un TAD es un modelo lógico que define un conjunto de datos y operaciones, sin especificar cómo se implementan internamente. Es el resultado de conocer los atributos y métodos de una clase, pero no cómo están implementados (Ver [Diferencias entre TAD, Interface y API]()).

```Java
public class Persona{
	
	private String nombre;
	private Collection<Coche> susCoches;
	
	public Persona(String nombre); // Constructor
	public Coche comprarCoche(Coche cocheAComprar); // Añade a la lista
	public void arrancarCoche(Coche coche);
	
}


public class Coche{
	
	private final String matrícula;
	private boolean arrancado;
	
	public Coche(String matrícula);
	public String getMatrícula();
	public void arrancar(); // pone "arrancado" a true.
	
}
```

En el TAD Persona observamos que tiene como atributo (está **relacionada** con) una colección de objetos de la clase Coche. Esto es, en definitiva, que una instancia de la clase Persona podrá estar relacionada con más de una instancia de la clase Coche.
Ahora, veremos nuestra clase principal, donde la objetos de la clase persona y coche interactúan para implementar una acción: una persona arranca uno de sus coches.

```Java
public class App{

	void main(){
		Persona jaimito = new Persona("Jaimito");
		Coche ferrari = new Coche("0777JJJ");
		nuevoCocheDeJaimito = jaimito.comprarCoche(ferrari);
		jaimito.arrancarCoche(nuevoCocheDeJaimito);
		// Realizará una llamada a nuevoCocheDeJaimito.arrancar();
		
	}
	
}
```
De esta manera surgen las **relaciones entre clases** (desde ahora, **dependencias**). Como hemos visto, objetos de distintas clases se relacionan unos con otros e invocan a sus métodos para implementar una funcionalidad.
## UML para representar diagramas de clases
---
Hay varios tipos de dependencias entre clases. Conviene servirse de UML (del inglés Unified Model Language) para verlas mejor. #UML, como su nombre indica, es un lenguaje de modelado unificado. No es un lenguaje de programación, ni mucho menos; es el estándar empleado en los diseños de software. Al igual que una casa, los programas también necesitan planos que soporten el concepto de lo que más tarde se va a construir. Pues bien, UML se encarga de establecer las reglas sobre cómo deben hacerse estos planos, asegurando que todo el mundo utilice la misma representación para las mismas cosas.

Con UML se pueden hacer infinidad de cosas; en POO solamente se utiliza para crear **diagramas de clases**; representaciones gráficas de las clases que existen en un programa y cómo se relacionan entre sí. Para empezar a ver las distintas relaciones entre clases, antes tenemos que saber cómo se representa una clase en UML.
### Representación de una clase con UML
Querido/a estudiante, te presento a una clase UML. Clase de UML, te presento a mi querido/a estudiante. No le des muchos dolores de cabeza ¿de acuerdo?

La verdad que representar una clase en UML no tiene pérdida; es un rectángulo con 3 secciones horizontales; en la primera va el nombre de la clase, en la segunda, sus atributos de tipo primitivo y, en la tercera y última, los métodos. Los símbolos +, # y - hacen referencia a la **visibilidad** de atributos y métodos; *public*, *protected* y *private*, respectivamente.

![[Clase UML.png]]
### Niveles de abstracción
Más adelante veréis que los diagramas de clases se pueden realizar en varios niveles de abstracción: análisis, diseño, implementación... Depende de si estáis en uno u otro, habrá algunas cosas que añadáis y otras que no, o lo haréis de forma un tanto diferente según el caso. Nosotros vamos a trabajar por el momento en el nivel de abstracción de **diseño**, lo que implica que:
* Solamente se escribirán los atributos que sean de tipos (clases) no definidas en nuestro diagrama UML (Tipos primitivos + otras clases como String, DateTime, wrappers de tipos primitivos, como Integer... etc).
  A continuación, veremos cómo se completa la clase con el resto de atributos.
* **Se indicarán los parámetros** que debe recibir cada método (si es que recibe alguno), a través de su tipo (clase), así como los tipos de los parámetros de los métodos y de los valores que retornan los métodos (void si no retorna ningún valor).