Proyecto manejo de archivos xml
=========================================

Colocar los archivos que se encuentran en la carpeta Files según el archivo config.properties: 
 * Los archivos XML se deben poner en la ruta que indique la propiedad xmlincoming

El resultado del procesamiento se verá en las rutas configuradas en el archivo config.properties (outgoing)

Para correr el proyecto, desde consola ejecutar:

    mvn celan camel:run

Desde JBoss developer studio, crear un perfil de ejecución:

	clean camel:run