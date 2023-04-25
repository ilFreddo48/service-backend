# service-backend
Tres servicios uno gateway que juega como un reverse proxy y comprueba la api key como forma de seguridad ligera, luego un service discovery un anuario de los microservicios y finalmente el servicio back donde hay el microservicio que comunica con la bd.

![arquitectura del sistema](https://github.com/ilFreddo48/prueba/blob/main/arq.png)

- gateway https://github.com/ilFreddo48/gateway
- backend https://github.com/ilFreddo48/service-backend
- discovery https://github.com/ilFreddo48/discovery-service

Para el arranque, un tomcat embedido que se puede arrancar mediante el terminal con mvn springboot:run o con el IDE.
En el repositorio de la gateway he adjuntado el proyecto postman para el test.

Instalacion de dependencias

```sh
mvn clean install
```

El siguiente paso arrancar cada servicio por separado 
```sh
mvn springboot:run
```

Como juego de datos tenemos 5 pricios a aplicar, una brand y un producto.

```sh
INSERT INTO "BRAND"(ID, NAME) VALUES(1, 'ZARA');

INSERT INTO "PRODUCTS"(ID, NAME) VALUES(1, 'SAC A MAIN');

INSERT INTO "PRICES" ( PRICE_LIST, CURR, START_DATE, PRICE, PRIORITY, END_DATE, BRAND_ID, PRODUCT_ID) VALUES( 1, 'EUR', '2020-06-14-23.59.59', 45, 3, '2020-12-31-23.59.59', 1, 1);
INSERT INTO "PRICES" ( PRICE_LIST, CURR, START_DATE, PRICE, PRIORITY, END_DATE, BRAND_ID, PRODUCT_ID) VALUES( 2, 'EUR', '2020-06-14-23.59.59', 30, 1, '2020-12-31-23.59.59', 1, 1);
INSERT INTO "PRICES" ( PRICE_LIST, CURR, START_DATE, PRICE, PRIORITY, END_DATE, BRAND_ID, PRODUCT_ID) VALUES( 3, 'EUR', '2020-06-14-23.59.59', 25, 2, '2020-12-31-23.59.59', 1, 1);
INSERT INTO "PRICES" ( PRICE_LIST, CURR, START_DATE, PRICE, PRIORITY, END_DATE, BRAND_ID, PRODUCT_ID) VALUES( 4, 'EUR', '2020-07-14-23.59.59', 45, 1, '2020-12-31-23.59.59', 1, 1);
INSERT INTO "PRICES" ( PRICE_LIST, CURR, START_DATE, PRICE, PRIORITY, END_DATE, BRAND_ID, PRODUCT_ID) VALUES( 5, 'EUR', '2020-08-14-23.59.59', 45, 1, '2020-12-31-23.59.59', 1, 1);
```

Consultamos la url **http://localhost:8888/api/v1/price** para obtener el precio que hay que aplicar al producto **1** cuya brand **ZARA** y la fecha de aplicacion es **2020-06-14-23.59.59** por ejemplo.
Obtenemos la siguiente respuesta :
```sh
Test 1: petición a las 6: 53 del día 10 del producto 1 para la brand 1 (ZARA) 
```


