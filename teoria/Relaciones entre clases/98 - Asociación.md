## Relación de asociación == estar ¿de lío?
---
La primera relación de la que vamos a hablar es la asociación. Es la dependencia más básica. Por llevarlo al terreno de la Generación X, sería como si dos objetos estuvieran "de lío".
De hecho esta analogía es bastante acertada; **dos objetos relacionados con una asociación pueden estar relacionados con otros objetos de distintas clases a la vez**. Parece mentira que podamos explicar diseño de software en POO hablando de "líos" ¿verdad?

En UML, una relación de asociación se representa con una línea simple, uniendo las dos clases.

![[Asociación.png]]
### ¿Qué son esos números de ahi?
En la mayoría de relaciones entre clases, UML obliga a especificar la **cardinalidad**; esto es el rango de instancias de una clase que pueden relacionarse con la otra. Por ejemplo. UN coche --- puede NO relacionarse con ninguna persona (mínima de 0), y como máximo, con una (máxima de 1). Las cardinalidades de una clase con otra se escriben en el extremo de la segunda, como vemos en el ejemplo.
Definir estas cardinalidades implica que solamente una persona puede tener el coche a su nombre. Sin embargo, en el otro sentido, hemos definido que una persona puede tener desde ningún coche en su colección, hasta una cantidad indefinida (representada en UML con un asterisco).

### Vale ¿y dónde están los demás atributos?
Si os dais cuenta en nuestra representación de clase hemos "omitido" explícitamente los atributos que hacen referencia a objetos de clases que aparecen en nuestro diagrama. Esto es porque dichos atributos **se deducen** de las relaciones entre las clases. De hecho, las relaciones entre clases se traducen en su mayoría en atributos a nivel de código. Concretamente, el diagrama que acabamos de hacer se corresponde con una relación de asociación bidireccional, que a nivel de código se vería así en cuanto a sus atributos.

```Java
// Asociación bidireccional
public class Persona{
	
	private String nombre;
	private Collection<Coche> susCoches; // Persona se asocia con 0..* coches
	
	// Métodos...
}


public class Coche{
	
	private final String matrícula;
	private boolean arrancado;
	private Persona dueño; // Coche se asocia con 0..1 dueño (DUEÑO PUEDE SER NULL)
	
	// Métodos...
}
```

### Espera, espera... ¿Qué es eso de "bidireccional"?
A ver, no te me alteres tan deprisa y déjame que acabe. Una relación de asociación puede ser unidireccional o bidireccional, dependiendo de la visibilidad entre clases. A nivel conceptual y de código, esto tiene sus implicaciones:
* En una **relación bidireccional**, **ambas clases tendrán** uno o varios **atributos de la clase con la que se relacionan**, según se indique en la cardinalidad. Como veíamos en el ejemplo de arriba, Persona tendrá una colección de coches (su cardinalidad máxima es > 1). Por otra parte, la clase Coche tendrá un solo atributo de la clase Persona, representando al único dueño que puede tener. Pero ojo, este atributo podría ser nulo debido a la cardinalidad mínima de 0 que presenta esta relación; el coche no tiene por qué estar relacionado necesariamente con una persona.
* En una **relación unidireccional**, las cosas se simplifican un poco. Solamente es **una de las clases** quien **posee** uno o varios **atributos de la otra clase** con la que se relaciona. En UML esto tiene una apariencia distinta a la representación que acabamos de ver; se escribe una **flecha apuntando hacia la clase que será un atributo**. Esto quiere decir que la clase que apunta a la otra será la que contenga el atributo del tipo de la otra clase.

Esto suena casi a un trabalenguas, así que vamos a ver ejemplos.

La representación de una relación unidireccional es la siguiente:

![[Asociación unidireccional.png]]

Y en código:
```Java
// Asociación unidireccional
public class Persona{
	
	private String nombre;
	private Collection<Coche> susCoches; // Persona se asocia con 0..* coches
	
	// Métodos...
}


public class Coche{
	
	private final String matrícula;
	private boolean arrancado;
	// NO HAY REFERENCIA A LA PERSONA DESDE EL COCHE
	
	// Métodos...
}
```

### Implicaciones de asociaciones bidireccionales VS unidireccionales
Tener una relación bidireccional, por lo general, aumenta el **acoplamiento**, aunque a veces es algo necesario y beneficioso.

| Bidireccional                                               | Unidireccional                                                                                                          |
| ----------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------- |
| Existe doble navegabilidad (Podemos ir de A a B y de B a A) | Navegabilidad unidireccional (De A a B, pero no de B a A)                                                               |
| Requiere inicializar los atributos a través de setter       | Puede inicializar los atributos desde el constructor, creando primero B y luego A, con B como parámetro del constructor |
El tema de la inicialización de los atributos deducidos de las relaciones es un punto importante al distinguir entre la relación bidireccional y unidireccional. Vamos a tomar un ejemplo nuevo para entender esto: tendremos una clase Persona y una clase Pasaporte.

La peculiaridad aquí es que, en una asociación bidireccional, ambos objetos necesitan el otro para crearse. Es por ello que la solución más común es recurrir a inicializaciones parciales. El proceso se debe generalizar, pero vamos a verlo primero en un caso concreto:
* Creamos la instancia de Persona con el valor de Pasaporte como nulo (no inicializado).
* Creamos la instancia de Pasaporte, pasándole por parámetro al constructor la instancia de Persona que creamos al inicio. Entonces, usamos el parámetro para relacionar al pasaporte con la persona y, a través de un setter, relacionamos de vuelta a la persona que creamos al inicio con el pasaporte que estamos creando ahora.

**INICIALIZACIÓN DE ATRIBUTOS EN ASOCIACIÓN BIDIRECCIONAL**
```Java
public class Persona{
	
	private String nombre;
	private Pasaporte pasaportePersonal;
	
	public Persona(String nombre){
		this.nombre = nombre;
		this.pasaporte = null; // Para crear A necesitamos B y viceversa;
		// Creamos A sin B.
	}
	
	public Pasaporte getPasaporte() {return this.pasaporte;}
	public void setPasaporte(Pasaporte pasaporte) {this.pasaporte = pasaporte;}
}

public class Pasaporte{
	
	private int id;
	private Persona dueño;
	
	public Pasaporte(Persona dueño){
		// Creamos B
		this.id = generarIdUnico() // Pereza implementarlo; genera un entero único
		this.dueño = dueño; // Relacionamos B con A
		dueño.setPasaporte(this); // Reñacionamos A con B
	}
	
	public Dueño getDueño() {return this.dueño;}
	public void setDueño(Dueño dueño) {this.dueño = dueño}
}

public class App{
	
	void main(){
		Persona manolo = new Persona("Manolo");
		
		/* En el mismo constructor del pasaporte, relacionamos al pasaporte con la
		persona sin pasaporte que creamos antes y pasamos ahora por parámetro, y
		le asignamos a la persona dicho pasaporte. */
		Pasaporte pasaporteDeManolo = new Pasaporte(manolo)
		
		// En asociaciones bidireccionales, hay doble navegabilidad:
		System.out.println(pasaporteDeManolo.getDueño()); // De B a A
		System.out.println(manolo.getPasaporte()); // De A a B
	}
}
```

**INICIALIZACIÓN DE ATRIBUTOS EN ASOCIACIÓN UNIDIRECCIONAL**
```Java
public class Persona{
	
	private String nombre;
	private Pasaporte pasaportePersonal;
	
	public Persona(String nombre, Pasaporte pasaporte){
		// Para crear A necesito B
		this.nombre = nombre;
		this.pasaporte = pasaporte
	}
	
	public Pasaporte getPasaporte() {return this.pasaporte;}
}

public class Pasaporte{
	
	private int id;
	
	public Pasaporte(){
		// Para crear B NO necesito A -> creo B
		this.id = generarIdUnico()
	}
	
}

public class App{
	
	void main(){
		// Como el pasaporte no tiene un atributo Persona, creo el pasaporte
		Pasaporte pasaporteDeJuan = new Pasaporte()
		
		// Creo la Persona con el pasaporte que acabo de hacer, asignándoselo
		Persona juan = new Persona("Juan", pasaporteDeJuan);
		
		// En asociaciones unidireccionales, hay navegabilidad solo de A a B:
		System.out.println(juan.getPasaporte());
		// NO HAY pasaporteDeJuan.getDueño()
	}
}
```