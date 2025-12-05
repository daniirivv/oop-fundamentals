# ¿Qué es?
---
La **Ley de Demeter** (A.K.A Principio del Menor Conocimiento, y desde ahora **LoD**) es una ley/principio de diseño que, a pesar de tener un nombre bastante guapo, **muchas veces se olvida**. Y es que me juego lo que queráis a que ya os la habéis saltado más de una vez. Pero para averiguarlo, primero necesitamos entenderla ¿no?

# Definición
---
La **LoD** establece lo siguiente (abrimos comillas dramáticas):

>    "Un método de un objeto (o el objeto en si) solo debe interactuar con objetos que estén   directamente relacionados con él, y no con los que lo están de forma indirecta a través de las relaciones intermedias que los unen".

Esto quizás suena muy opaco al principio, pero tiene todo el sentido del mundo. Vamos a verlo en detalle.
# ¿Qué nos dice?
---
Para que nos entendamos, la LoD es la ley de diseño orientado a objetos favorita de ese familiar que, cuando eras pequeño, siempre te decía la típica frase de "no hables con extraños".
¿Que por qué digo esto? Pues porque, en esencia, lo que nos pide la LoD es eso mismo; que nuestros objetos no se comuniquen con extraños, y solo lo hagan con aquellos con los que están directamente relacionados.

Por ejemplo, supongamos que tenemos una clase Persona relacionada con una clase Mochila, que a su vez está relacionada con otra clase Estuche, por ejemplo, a través de relaciones de agregación simple. Si todavía no recuerdas del todo estos conceptos, te recomiendo que vayas a echarle un repaso rápido antes de seguir: [[97 - Agregación]]

![[diagrama-clases-demeter.png]]

**Implementación**

```java
class Persona {
	
	private final String name;
	private Mochila mochila;
	
	public Persona(String parametroNombre){
		/* Sigo escribiendo this. por buena práctica al referirme al atributo,
		aunque no hay conflicto */
		this.name = parametroNombre; 
		this.mochila = new Mochila({new Estuche()});
	}
	
	public getMochila() {return this.mochila}
	
}

class Mochila {
	// Mejor usar constantes que "números mágicos"
	private static final MAX_ESTUCHES = 5
	
	private Estuche[] estuches;
	
	public Mochila(){
		this.estuches = new Estuche[MAX_ESTUCHES];
		this.estuches[0] = new Estuche()
	}
	
	public getEstuches(int index){return this.estuches[index]}
}

class Estuche {
	
	private void usar(){
		System.out.println("Usando estuche...");
	}
}
```

En este caso, desde nuestra clase Persona podríamos sentirnos tentados a hacer lo siguiente, si quisiéramos "usar" nuestro estuche:

```java
Estuche miEstuche = persona.getMochila().getEstuches()[50].usar()
```

Lo importante de esto es que, ahora mismo, la clase Persona está accediendo directamente a un método de la clase Estuche **usando las clases que los conectan, pero saltándose en el proceso las capas de abstracción que estas podrían ofrecer**. Y aquí es donde está el problema.
Podríamos pensarlo como el juego del teléfono escacharrado: una persona inicial manda un mensaje a otra a través de muchos intermediarios, lo que hace que éste se vaya deteriorando poco a poco por su paso entre cada persona que forma la cadena, hasta que llega al receptor un mensaje completamente diferente al original.

El paralelismo con la LoD reside en que nuestros objetos solo deben conocerse entre aquellos que están directamente relacionados, a fin de **reducir el acoplamiento con el resto**. Esto es deseable en cuanto al diseño, porque si modificamos el comportamiento de algún componente intermedio, el resto de componentes no se enterarán. Por ejemplo, si quisiera cambiar la estructura de datos que gestiona los estuches en la clase Mochila por un `List<Mochila>`, ahora mismo tendría que cambiar todo el código que estuviese hecho como el primer ejemplo.
Por tanto, la forma correcta de comunicarnos sería la de **crear métodos** que **deleguen** la comunicación a un objeto con el que están **relacionados directamente**.

Es decir, en lugar de la cadena anterior, donde Persona se comunica con estuche:

```java
persona.getMochila().getEstuches()[50].usar()
```

Haríamos lo siguiente:

```java
class Persona {
	//...
	
	public usarEstuchePrincipalDeLaMochila(){
		this.mochila.usarEstuche(0);
	}
}

class Mochila {
	//...
	
	public usarEstuche(int index){
		this.estuches[index].usar()
	}
}

class Estuche {
	//...
}

class App{
	void main(){
		Estuche estuche = new Estuche();
		Mochila mochila = new Mochila(estuche)
		Persona persona = new Persona("Dani", mochila);
		
		persona.usarEstuchePrincipalDeLaMochila();
	}
}


```

Haciéndolo así, estamos asegurándonos de que no se exponen las estructuras de datos internas de las clases relacionadas, ni tomamos decisiones usando datos de terceros que le corresponden tomar a clases que están directamente relacionadas con dichos datos.

// Revisar con COPILOT cuando funcione

// Profundizar sobre relacion Clase A recursiva hacia clase B (Persona1 -> Persona2 -> Puntuación, por ejemplo)