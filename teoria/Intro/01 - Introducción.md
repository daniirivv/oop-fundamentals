Como dijo un gran sabio una vez, empecemos por el principio.
## ¿Qué es la Programación Orientada a Objetos?
---
La **Programación Orientada a Objetos** (del inglés, Object Oriented Programming) es un #paradigma_de_programación. Su nombre ya nos sugiere muchas cosas: "orientado a objetos" quiere decir que su enfoque se centra en el objeto como unidad mínima en la construcción de software. Esta forma de programar permite acercar las entidades programadas a una concepción mucho más cercana a la realidad, lo que nos permite mejorar la legibilidad y mantenibilidad del código.
### Hasta ahí todo bien, pero ¿qué es un objeto?
---
Si habéis aprendido a programar en un lenguaje orientado a objetos, que son aquellos que se basan en este paradigma, habréis tenido que utilizarlos sin entenderlos realmente.
Un #objeto es la **unidad básica** de la programación orientada a objetos. Los objetos pueden tener **propiedades** y **comportamientos**. Vamos a verlo con un ejemplo en el mundo real.

Imagina una botella. Podríamos programar un objeto botella usando POO de una forma bastante descriptiva con lo que representa una botella en la vida real. Usaremos este ejemplo para hablar de los dos campos fundamentales que constituyen un objeto.
## Atributos de un objeto
---
Al referirnos a la botella, podríamos hablar de su color, su capacidad, los materiales con los que está fabricada, si está vacía o está llena, si tiene el tapón abierto o cerrado... Todas ellas son características de la botella; son sus propiedades, o como se les conoce en este paradigma, sus **atributos**.
Un #atributo es una **característica** de un **objeto**, que tiene asociado un **valor**. Vendría a ser las "propiedades" que mencionamos antes. Un objeto puede tener tantos atributos como se quiera.
El valor de un atributo podrá cambiar a lo largo de la vida del objeto en el programa, siempre y cuando no esté definido como inmutable (*final* en Java); en este caso, una vez que se le de un valor a un atributo, éste no podrá cambiar.
En el caso de [lenguajes tipados](Lenguajes tipados y no tipados), los atributos van acompañados del tipo de valor que puede tomar.

Al hablar de los atributos surge el concepto de #estado. El estado es el conjunto formado por todos atributos y sus valores. Así, si tenemos dos botellas que tienen el mismo color, los mismos materiales, la misma capacidad, y ambas están vacías, podríamos afirmar que están en el mismo estado; los valores de sus atributos son iguales. Sin embargo, si una estuviese llena y la otra no, el estado ya no sería igual. Lo mismo pasaría si fuesen de colores distintos, o si tuviesen capacidades distintas, o todo ello a la vez. El estado de un objeto nos habla de qué valores tienen sus atributos en un instante concreto de la ejecución de un programa.
Una forma sencilla de representar un estado es a través de una tabla que muestre los atributos de un objeto junto a su valor. Este ejemplo quedaría así:

### **BOTELLA**

| Atributo  | Valor    |
| --------- | -------- |
| Capacidad | 100 (ml) |
| Material  | Plástico |
| Llena     | No       |
## Métodos de un objeto
---
Muy seguramente ahora te estarás preguntando por la parte del comportamiento ¿verdad
Todos los objetos en programación tienen su función; desde almacenar datos, crear otros objetos o modificar su estado... Piénsalo, si no tuviesen una función, no los programaríamos ¿verdad?
En fin, el caso es que el comportamiento de un objeto se define mediante métodos. Un #método es una [función](Funciones) que define las acciones que un objeto puede tomar. Los métodos deberían, por lo general, interactuar con los atributos del objeto. Por ejemplo, siguiendo con la botella, podríamos definir un método que cambie su estado para indicar que se ha rellenado/vaciado en una cierta cantidad. Este método debería modificar los atributos relacionados con la cantidad de líquido en la botella, y modificarlos acorde a la cantidad que hayamos introducido.

Al ser funciones, los métodos pueden recibir parámetros de entrada y devolver valores de forma opcional. En el método que acabamos de exponer como ejemplo, no sería necesario devolver ningún valor, pero sí se requeriría introducir como entrada la cantidad con la que queremos llenar o vaciar nuestra botella. Habría muchísimas formas de implementar esta funcionalidad, unas mejores y otras peores, pero ahora no es el tema. Te lo dejo a ti por el momento ;).
## Concepto de "clase"
---
Bien, parece que ya lo hemos visto todo sobre los objetos, pero aún falta lo más importante. ¿Imagináis que para crear varios objetos que actúen como botellas tuviese que definir los mismos atributos y métodos tantas veces como objetos que representen botellas quisiera crear? Esto, obviamente no se hace así. En POO, para ello nos servimos del concepto de clase.
Una #clase es una porción de código que agrupa los atributos y métodos que van a poseer todos los objetos que formen parte de ella. De esta forma, cada vez que queramos crear un objeto que deba comportarse como una botella, utilizaremos la clase Botella como plantilla, para crear tantas botellas como queramos.
Cada objeto creado a partir de la clase Botella podrá tener estados diferentes (colores o capacidades distintas, por ejemplo). Sin embargo todos ellos son objetos de la misma clase Botella.

Para reforzar este concepto, que es clave para todo lo que se nos viene encima, me gustaría servirme de la [Filosofía de las Formas de Platón](httpsyoutu.be8LkIn9ARJiwsi=uMsR22RYnHnLKmK0)(es un vídeo que lo explica con Minecraft, dale un *try* que merece la pena).
Relacionando las clases con el concepto de idea de Platón, una clase sería esa idea o esencia abstracta y perfecta, sin expresión física, de la cual nosotros creamos instancias concretas (objetos del mundo sensible) que contienen dicha esencia que nos hace poder clasificarlos como tal.
Podríamos, incluso, hacer ingeniería inversa desde los objetos concretos que hemos ido creando hasta ahora para extraer el comportamiento común y así reconstruir lo que para nosotros será la idea de botella. Esta información es la que deberá estar en la clase. 
### Ejemplo final
---
Volviendo al ejemplo clásico, sabemos que para considerar un objeto como botella, debe al menos servir para almacenar un líquido y tener un tapón (si no, podría ser un vaso normal y corriente). Pues esta información es la que constituiría la "idea" de botella según Platón.
Llevada a la programación, podríamos fijar también que los objetos de la clase Botella deberán tener un color y una capacidad determinadas, así como una forma del tapón y unos materiales (son, en resumen, los atributos que hemos estado definiendo). Vamos a ver cómo quedaría el proceso de creación de objetos a través de la abstracción de la clase.

| Clase (idea)    | objeto1 (botella de plástico) | objeto2 (botella tipo cantimplora) |
| --------------- | ----------------------------- | ---------------------------------- |
| Forma del tapón | Redondo                       | Alargado                           |
| Capacidad (cl)  | 100                           | 33                                 |
| Color           | Azul                          | Verde                              |
| Material        | Plástico                      | Metal                              |
