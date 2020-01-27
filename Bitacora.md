# Bitacora

Code smells encontrados en el proyecto.
  - **Long methods**: La logica para actualizar "Quality" de todos los items esta en un solo metodo.
  - **Methods too complex**: Mismo punto que arriba, al tener tanto codigo vuelve muy compleja la clase.
  - **Magic numbers**: Muchos numeros en los Ifs que no indican su significado semantico.
  - **Duplicated code**: accediendo al mismo objecto y mismo metodo muchas veces.
  - **Excessive use of literals**: comparacaciones basadas en nombres muchas veces sin uso de constantes.
  - **Publicly Exposed Fields**: La clase item tenia los campos publicos.

Al mismo tiempo se violaron algunos principios SOLID
  - **Single responsability**: toda la responsabilidad de calcular el monto y actualizar el "quality" de todos los tipos de productos se encontraban en un solo punto.
  - **Open close principle**: las clases Item y el programa principal estaban abiertas a modificacines directas a pesar de tener mutadores.