Ejercicio a desarrollar:
Necesitamos por favor crear un conjunto de funcionalidades encapsuladas en un microservicio bajo el framework
SpringBoot que cumplan las siguientes características:
1: implementar un servicio web que permita consumir el api de star wars (https://swapi.dev/documentation#films),
para dicho consumo solo necesitamos implementar la operación /films/:id/ la cual retorna una película por id.
para este punto necesitamos validar:
- si el cliente envía un id que no existe se retorne el código 204
- si el cliente envía algo diferente a un id o id demasiado largos retorne un Código 400 con el siguiente response "error en la solicitud"
- si el api de star wars responde de forma correcta, se pide persistir la siguiente información:
episode_id, title y release_date en una tabla en base de datos y devolver dicha información con código 200 en formato json al cliente
2: implementar un servicio web que permita actualizar la información de un registro almacenado en la tabla
3: implementar un servicio web que permita borrar la información de registro en la bd 4: validar la cobertura del Código sobre el 70% con pruebas unitarias (Junit - Mockito) 5: subir Código a un repo público de git hub