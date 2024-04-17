# microservices_LCA_test

1-	La carpeta conf_properties, contiene los archivos de configuración de los mircroservicios, 
el mismo posee un repo git para poder utilizarlo. El microservicio CloudConfigServer es quien 
hace uso de él, en su propertie debe ponerse la ruta donde se copie esta carpeta:

spring.cloud.config.server.git.uri=file:///D:/1PROGRAMACION/REPO_CODIGOS/LCA/conf_properties


Orden de inicio:

1-	Microservicio CloudConfigServer

2-	Microservicio EurekaService

3-	Microservicio WasterManagerAddressService y Microservicio WasterManagerService

4-	Microservicio GatewayService

## Swagger

http://localhost:8082/api/v1/waste-manager/swagger-ui/index.html# microservices_test_LCA
