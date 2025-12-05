Si bien ya hemos visto la parte conceptual de lo que es un objeto en programación, hay algunas cosas a nivel de código que todavía se nos escapan, por lo que vamos a verlas, como no puede ser de otra forma, con ejemplos.
## Estructura de una clase en Java
---
Vamos a empezar con un pequeño esquema de cómo se ve una clase en Java. A pesar de utilizar este lenguaje en concreto, los conceptos son los mismos y por ende extrapolables a cualquier otro lenguaje que soporte el mismo paradigma, con mínimas diferencias.

Primero, comenzaremos declarando la clase. Viene a ser como decir "ey, este archivo es una clase de Java" (extensión .java, no es muy difícil de recordar). En código, se utiliza la palabra reservada *class*. Queda algo así:

```Java
class MiClase{
	// Atributos
	
	// Métodos: Constructor
	// Métodos: Getter/Setter
	// Métodos: Otros métodos
}
```

En Java, se suele utilizar **por convención** (A.K.A porque los que saben se han puesto de acuerdo en que así sea) el *casing* tipo PascalCase. Veremos más sobre [*casing*](/Programación/Reglas de estilo/Casing) en un punto aparte.

Ahora, vamos a ir agregando poco a poco a este esquema general el código de nuestra clase.
## Atributos de una clase en Java
---
Como hemos hablado antes, las clases tienen atributos. Esos atributos deben escribirse al inicio de la clase. Existen estándares y reglas de estilo que nos indican en qué orden debemos declarar los atributos, pero ya veremos eso más tarde. De momento, podemos empezar simplemente por declarar primero los atributos inmutables (marcados con la palabra reservada *final*), en caso de que los hubiera.

La sintaxis para declarar un atributo es la misma que para declarar una variable al programar de forma imperativa. Podemos darle un valor al atributo al momento de declararlo en caso de que esté declarado como *final*, aunque hay que tener cuidado con esto; en ese caso, hay que tener en cuenta que **cualquier objeto que creemos tendrá dicho valor en este atributo**.

```Java
// [] quiere decir "opcional"
[final] <tipoDato> miAtributo;

// Ejemplos:
String color;
final int capacidadTotal = 100;

```

Nuestra clase con los atributos declarados se ve tal que así:
```Java
class NombreClase{
	// Atributos (final en primer lugar)
	final int capacidadTotal;
	final String color;
	final String material;
	
	int volumenLlenado;
	boolean abierta;
}
```

Existen más modificadores para los atributos, como la palabra reservada *static*, que indica que un atributo es estático; propio de la clase y no del objeto, pero ya profundizaremos en ello en otro momento.
## Métodos de una clase en Java: Constructor
---
A continuación de la declaración de todos los atributos, se debe añadir el **constructor** de la clase. El constructor es un método especial que se encarga de **inicializar** los atributos del objeto. "Inicializar" quiere decir darle a algo, en nuestro caso, a los atributos, un valores iniciales.
Este método es al que llamamos para crear objetos de una clase, utilizando la palabra reservada *new*. Para el caso de la botella:

```Java
Botella(int capacidadTotal, String color, String material){
	this.capacidadTotal = capacidadTotal;
	this.color = color;
	this.material = material;
	this.volumenLlenado = 0;
	this.abierta = false;
}
```

Al ser un método (función), puede recibir parámetros de entrada y salida. La implementación de este constructor inicializa la capacidad total, el color y el material con los valores que nosotros indiquemos. Además, inicializa la botella como vacía (llenado = 0) y cerrada (abierta = false).

Una vez definido el constructor, podemos entender cómo se crean objetos en Java. Primero, debemos declararlos como cualquier otra variable, donde el tipo de objeto será el nombre de la clase. A continuación, le damos una referencia y la asignamos a la creación del nuevo objeto producto de la llamada al constructor con el uso del *new*.

```java
// Ejemplo general de la creación de un objeto
MiClase miObjeto = new MiClase();

// Ejemplo concreto en el caso de la botella
Botella botella = new Botella (100, "Azul", "Plastico");
```

En el ejemplo general no hemos puesto parámetros de entrada porque no hemos definido ningún constructor. Todas las clases tienen, por defecto, un constructor "básico" que inicializa todos los atributos a su valor por defecto. Los tipos de datos primitivos se inicializan a un valor en concreto, mientras que el resto se inicializan como nulos (no hay valor, se representa como *null*).

Esto es sensible al lenguaje utilizado; en Java, por ejemplo:
```java
int numero;        // -> 0
boolean booleano;  // -> false
String texto;      // -> "" (texto vacío)
MiClase objeto;    // -> null
```

Ahora veamos cómo queda nuestra clase una vez agregado el constructor:
```java
class NombreClase{
	final int capacidadTotal;
	final String color;
	final String material;
	
	int volumenLlenado;
	boolean abierta;
	
	// Métodos: Constructor
	Botella(int capacidadTotal, String color, String material){
		this.capacidadTotal = capacidadTotal;
		this.color = color;
		this.material = material;
		this.volumenLlenado = 0;
		this.abierta = false;
	}
}
```

## Métodos de una clase en Java: Getters/Setters
---
Quizás sea demasiado pronto para ver esto, pero cuanto antes nos habituemos a ello, mejor.
En POO es muy importante que se respete a los objetos; con ello quiero decir que no se les puede modificar de forma brusca, si no que debemos ser delicados al obtener y modificar sus atributos. Para ello, declararemos en nuestras clases unos métodos especiales cuya única funcionalidad serán darnos el valor de un atributo o modificarlo si procede; para esto sirven, respectivamente, los *getter* y *setter*.

El motivo de esto lo trataremos más adelante, pero fundamentalmente lo que buscamos con estos métodos es controlar el acceso y modificación de los atributos para asegurar que se respeta la lógica que deben de seguir. Esto implica impedir que los objetos sean modificados directamente por llamadas de otros métodos, y que los atributos tomen siempre valores coherentes.

Por ejemplo, no tiene sentido que la capacidad total de nuestra botella o la cantidad llenada en ella sea un entero negativo. Esta **lógica de validación**, siempre que sea intrínseca a la lógica de la clase y no sea demasiado extensa en cuanto a código, puede realizarse en estos métodos o en el constructor.

Estos métodos se deben implementar así:

```Java
int getCapacidadTotal(){return this.capacidadTotal}
// Los atributos inmutables NO PUEDEN TENER SET, pues su valor no cambia.

int getVolumenLlenado(){return this.volumenLlenado}
void setVolumenLlenado(int valor){
	if(valor > 0) this.volumenLlenado = valor
}
```

Ahora vamos a añadir getter y setter para nuestros atributos, además de realizar alguna modificación a nuestro constructor para comprobar la inicialización de los atributos inmutables, que no tienen setter. Concretamente, si no se cumple la condición de que la capacidad total de la botella a crear sea mayor que 0, crearemos un objeto de la clase IllegalArgumentException y lanzaremos dicho objeto a través de la palabra reservada *throw*, lo que provocará un error que parará el programa. Veremos cómo hacer esto más en detalle también; por el momento, con entenderlo basta.

```java
class NombreClase{
	final int capacidadTotal;
	final String color;
	final String material;
	
	int volumenLlenado;
	boolean abierta;
	
	// Constructor modificado
	Botella(int capacidadTotal, String color, String material){
		if(capacidadTotal > 0){
			this.capacidadTotal = capacidadTotal;
		} else throw new IllegalArgumentException();
		this.color = color;
		this.material = material;
		this.volumenLlenado = 0;
		this.abierta = false;
	}
	
	// Métodos: getter y setter
	int getCapacidadTotal() {return this.capacidadTotal}
	
	String getColor() {return this.color}
	
	String getMaterial() {return this.material}
	
	int getVolumenLlenado() {return this.volumenLlenado}
	void setVolumenLlenado(int volumen) {
		if(volumen < capacidadTotal && volumen > 0) this.volumenLlenado = volumen;
		else{
			System.out.println("El volumen debe estar entre 0 y " + capacidadTotal)
		}
	}
	
	boolean isAbierta() {return this.abierta}
	void setAbierta(boolean abierta) {this.abierta = abierta}
}
```

Como pequeño apunte, cuando tratamos con tipos de datos booleanos, la declaración del getter se escribe como isAtributo() y no como getAtributo().
## Métodos: Comportamiento de nuestro objeto
---
Una vez definidos los atributos, el constructor y los getter/setter correspondientes, vamos a pasar a definir los métodos que nuestro objeto utilizará para cumplir su tarea. Nos hemos dejado bastantes cosas, pero esto solo es el principio; iremos aproximando cosas más complejas poco a poco.

Vamos a implementar algo de funcionalidad a nuestro objeto a través de métodos que nos permitan llenar/vaciar nuestra botella en una cierta cantidad.
A la hora de implementar restricciones de lógica de nuestra aplicación, como lo que comentábamos antes de las capacidades negativas, podemos aprovechar la lógica de getter y setter para que manejen dichos casos, o manejarlas explícitamente según el contexto de cada método, en caso de que nuestros setter no incluyan lógica de validación.
Vamos a ver ambas formas:

```Java
	/* Manejando restricciones de forma explícita, no usamos setter dentro
	   de la implementación del mismo objeto. */
	void llenar(int cantidad){
	// No queremos que el método llenar se use para vaciar la botella
		if(cantidad > 0){
			int suma = this.volumenLlenado + cantidad;
			if(suma < capacidadMax){
				this.volumenLlenado += cantidad;
			} else throw new IllegalArgumentException("Suma sobrepasa el límite");
		}
		else throw new IllegalArgumentException("No se puede llenar en negativo");
	}
	
	// Manejando restricciones a través de la lógica de validación del setter
	void beber(int cantidad){
		// No queremos beber cantidades negativas de líquido
		if(cantidad > 0) setVolumenLlenado(this.volumenLlenado - cantidad)
		else throw new IllegalArgumentException
	}
	
	// Sin setter
	void abrir() {this.abierta = true}
	
	// Con setter
	void cerrar() {setAbierta(false)}
```

Como se puede ver en el código, las clases relacionadas con excepciones disponen de un constructor que nos permite añadir el mensaje de error que queremos mandar. De esta forma, podemos personalizar el error según lo que lo haya producido exactamente.

Vamos a agregarlo todo, y a añadir esta nueva funcionalidad que hemos aprendido también para la excepción lanzada en el constructor. Con esto, tendríamos una clase bien construida, completa y funcional.

```Java
	class NombreClase{
	final int capacidadTotal;
	final String color;
	final String material;
	
	int volumenLlenado;
	boolean abierta;
	
	// Constructor modificado
	Botella(int capacidadTotal, String color, String material){
		if(capacidadTotal > 0){
			this.capacidadTotal = capacidadTotal;
		} else throw new IllegalArgumentException("La capacidad debe ser > 0");
		this.color = color;
		this.material = material;
		this.volumenLlenado = 0;
		this.abierta = false;
	}
	
	int getCapacidadTotal() {return this.capacidadTotal}
	
	String getColor() {return this.color}
	
	String getMaterial() {return this.material}
	
	int getVolumenLlenado() {return this.volumenLlenado}
	void setVolumenLlenado(int volumen) {
		if(volumen < capacidadTotal && volumen > 0) this.volumenLlenado = volumen;
		else{
			System.out.println("El volumen debe estar entre 0 y " + capacidadTotal)
		}
	}
	
	boolean isAbierta() {return this.abierta}
	void setAbierta(boolean abierta) {this.abierta = abierta}
	
	// Métodos: comportamiento
	void llenar(int cantidad){
		if(cantidad > 0){
			int suma = this.volumenLlenado + cantidad;
			if(suma < capacidadMax){
				this.volumenLlenado += cantidad;
			} else throw new IllegalArgumentException("Suma sobrepasa el límite");
		}
		else throw new IllegalArgumentException("No se puede llenar en negativo");
	}
	
	void beber(int cantidad){
		if(cantidad > 0) setVolumenLlenado(this.volumenLlenado - cantidad)
		else throw new IllegalArgumentException
	}
	
	void abrir() {this.abierta = true}
	
	void cerrar() {setAbierta(false)}
}
```
## Ejemplo final
---
Una vez completada nuestra clase Botella, creamos una clase que incluya el método main() ejecutable, para comprobar los resultados:

```Java
// Clase principal: aquí ejecutaremos nuestro programa
	class App{
	
	void main(){ // Método a ejecutar
		Botella miBotella = new Botella(100, azul, plastico);
		System.out.print("Material de mi botella: ");
		System.out.println(miBotella.getMaterial());
		
		Botella otraBotella = new Botella(50, verde, metal);
		System.out.print("Material de otra botella: ");
		System.out.println(otraBotella.getMaterial());
		
		Botella botellaIrreal = new Botella(-3, rojo, plastico) // ERROR
	}
}
```