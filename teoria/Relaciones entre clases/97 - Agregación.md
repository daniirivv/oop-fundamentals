Cuando hablamos de relaciones de **agregación**, normalmente se distingue entre agregaciones débiles (**agregación**, a secas) y agregaciones fuertes, a veces llamadas **composición**.
## Agregación, la relación sana
---
En la relación de agregación, a nivel de código, las implicaciones son las mismas que las de una asociación unidireccional. Sin embargo, la agregación agrega un matiz semántico a la relación. Concretamente, las agregaciones suelen ser relaciones de pertenencia. Son relaciones que nacen cuando una clase (que se denomina "el todo") "tiene" instancias de otra, que forman parte de ella (normalmente denominada "la parte".

En este sentido, la agregación se distingue porque "la parte" y "el todo" no tienen dependencia de vida; ambos objetos tienen sentido por separado, y la destrucción del todo no implica la de las partes. Por seguir con la dinámica de analogías, la relación de agregación sería una relación sana y estable (eliminando los matices de pertenencia de los que hablaba antes, claro). Cada miembro de la pareja está vinculado con el otro, pero a su vez tiene sentido por sí mismo; no depende de su pareja para existir. 

Por ver un ejemplo, podríamos imaginar la relación entre una clase Equipo y una clase Jugador. 
Un equipo tiene una colección de jugadores, y se podrá tanto inscribir como sacar jugadores del equipo. Sin embargo, **eliminar el equipo** no supone eliminar también a los jugadores; dichos jugadores podrán ir a otros equipos, por ejemplo.




