EjercicioJSF_Libreria
=====================

1)Crear un formulario que le permita:

Ingresar todos los datos de la entidad asignada. 
En caso de que su entidad tenga un atributo del tipo de otra entidad, usar un combo. 

Por ejemplo:
Autor tiene un atributo de tipo Nacionalidad, por lo tanto para ingresar la nacionalidad se requiere un combo de nacionalidades.

2)Agregar al formulario un botón insertar:

El botón debe invocar al método insertar del controlador que ejecuta la siguiente lógica:
-Llama al método insertar del servicio correspondiente al cual le pasa como parámetro el objeto con los datos que tomo del formulario. Asegúrese de que el objeto tenga datos en todos sus atributos.
-Luego de insertado el objeto se debe limpiar todos los componentes de entrada.

3)Agregar una tabla en la cual se listen todos los objetos insertados. 
Esta tabla debe aparecer llena al momento de desplegar la página y debe actualizarse con los nuevos datos cada vez que se inserte un nuevo registro.

Nota:
La aplicación se debe ejecutar en un servidor web y además de debe modificar los archivos de la carpeta ant con los datos correspondientes al servidor y nombre del proyecto.
