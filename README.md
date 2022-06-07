# Technical Test

Se requiere verificar el ADN de las personas y validar si tiene mal formaciones genéticas, eres
contratado por un laboratorio para que desarrolles un proyecto que detecte si un humano tiene
mal formaciones basada en una secuencia de ADN.  
En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de
(NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales
representa cada base nitrogenada del ADN  

![cases](https://github.com/pantera2580/dnaVerifier/blob/main/caseDna.png)

Sabrás si el ADN tiene mal formaciones, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.  
Ejemplo (Caso ADN mal formado):  
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};  
En este caso el llamado a la función devuelve “true”.  
Desarrolla el algoritmo de la manera más eficiente posible.

**Aspectos para tener en cuenta:**  
* La prueba debe ser realizada utilizando SpringBoot y Java 11.  
* Se debe considerar los escenarios de erros y códigos http correctos.  
* Se debe implementar un Front, en Angular 10, 11 o versiones superiores.  
* Es un plus guarde los ADN’s verificados con la API.  
* Es un plus exponer un servicio extra que devuelva un Json con las estadísticas de las verificaciones de ADN: {“count_correct_dna”:40, “count_defect_dna”:100: “ratio”:0.4}.  
* Es un plus agregar autenticación mediante username token al proyecto.  
* Es un plus manejar la arquitectura del proyecto basado en microservicios.  
* Es un plus test automáticos de fluctuaciones agresivas de trafico.  

Para ejecutar el proyecto es necesario añadir las variables de entorno
MYSQL_DB_USER = mi_usuario
export MYSQL_DB_PASSWORD= mi_password
export JWT_KEY= mi_jwt_key
