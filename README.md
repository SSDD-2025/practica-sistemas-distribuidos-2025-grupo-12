[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/D1C1HU9V)
# Nombre de la aplicación: PixelTrade
## Integrantes del grupo
| Nombre  | Apellido  | Correo                     | GitHub  |
|---------|-----------|----------------------------|---------|
| Tayson  | Pérez Bernaerts  | ti.perez.2022@alumnos.urjc.com    | [GitHub1](https://github.com/Taysonpb) |
| Daniel  | Muñoz Martínez   | d.munozm.2022@alumnos.urjc.es     | [GitHub2](https://github.com/danielmunmar) |
| Martín  | Gutiérrez Parada | m.gutierrezp.2022@alumnos.urjc.es | [GitHub3](https://github.com/martingutpar) |

## Aspectos Principales
### Entidades: 
Usuario, producto, mensaje y review. Todas las entidades tienen dos relaciones 1 a N con la entidad usuario. Esto se debe a que un usuario compra y vende N productos, al igual que envía y recibe N mensajes y reseñas.

### Permisos de los usuarios:  
- Anónimo: puede consultar información de los productos.
- Usuario registrado: puede consultar información de los produuctos, puede comprar y vender productos, enviar y recibir mensajes y poner y recibir reviews. También pueden acceder a su perfil donde tienen su información de cuenta, un listado de productos a la venta y comprados y pueden ver las reviews recibidas.
- Administrador: tiene permisos para borrar productos, mensajes y reviews. Además puede borrar usuarios con lo cuál se eliminan todas las entidades asociadas a esa cuenta.

### Imágenes
La entidad producto tiene una imagen asociada.

## Navegación
- Inicio: página inicial desde la que se puede acceder a todo el resto de funciones.
![Inicio](Images/inicio.png)

- Productos: página con todos los productos incluyendo un buscador.
![Productos](Images/productos.png)

- Página producto: página específica de cada producto para comprarlo o enviar mensajes a su vendedor.
![Producto_individual](Images/producto_individual.png)

- Subir un producto: página para subir un producto seleccionando una imagen.
![Subir_producto](Images/subir_producto.png)

- Poner review: págian que aparece tras comprar un producto para poner una review a su vendedor.
![Poner_review](Images/producto_comprado.png)

- Chat: página de chat con un contacto específico para enviar mensajes.
![Chat](Images/chat_individual.png)

- Perfil: página para acceder a las funciones de mi perfil.
![Perfil](Images/perfil.png)

- Información personal: página con la información del usuario.
![Info](Images/info_personal.png)

- Compras realizadas: página con el historial de compras.
![Compras](Images/compras.png)

- Productos a la venta: página con listado de mis productos.
![Ventas](Images/ventas.png)

- Ver Reviews: página con las reviews que he recibido.
![Ver_review](Images/resenas.png)

- Menú admin: menú con todas las opciones del administrador.
![Administracion](Images/administracion.png)

- Gestión usuarios: página para la gestión de usuarios.
![GestionUsuarios](Images/gestion_usuarios.png)

- Gestión productos: página para la gestión de productos.
![GestionProductos](Images/gestion_productos.png)

- Moderar reseñas: página para la moderación de reseñas.
![ModerarResenas](Images/moderar_resenas.png)

- Moderar mensajes: página para la moderación de mensajes.
![ModerarMensajes](Images/moderar_mensajes.png)


## Diagrama de navegación
![DiagramaNavegacion](Images/DiagramaNavegacion.png)


## Diagrama de entidades
![DiagramaEntidades](Images/DiagramaEntidades.png)


## Diagrama de clases y templates
![DiagramaClasesTemplates](Images/DiagramaClasesTemplates.jpg)

## Participación de miembros
Cabe destacar que hemos trabajado generalmente en grupo todos en un mismo ordenador por lo que muchos de los commits asociados a una cuenta específica son desarrollados por todos, al igual que los ficheros creados.
### Martín Gutiérrez Parada

- **Tareas 1:**  Gestión de la sesión de los usuarios, subir imágenes en un producto, todas las funciones relacionadas con los mensajes, creación de htmls y css, header y footer, diseños de páginas, codificación de métodos de los controladores, diagramas de entidades y navegación, desarrollo de la documentación.

- **Tareas 2:** Configuración de seguridad, desarrollo de controladores API Rest, paginación con AJAX y en la API Rest, tareas de refactorización y solución de errores.

- **5 commits más significativos:**  
    - [Commit 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/24b955c4ecb21f694ed85e6669a3ef802a64ff4e)
    - [Commit 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/ce0a39a30d7ab4caa5fbe67f2277e48ac81d08c7)
    - [Commit 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/a5ae870387073b9abaf45c69dc265b236a0bec5f)
    - [Commit 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/5f9985cd6f69574831add4332c665d7c1eb01f3b)
    - [Commit 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/cf39df9788521109389c68506b3f7f8ae2301993)
 

- **5 ficheros en los que se ha participado:**  
    - [Fichero 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/controller/MessageWebController.java)
    - [Fichero 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/controller/UserWebController.java)
    - [Fichero 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/model/Message.java)
    - [Fichero 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/resources/static/style1.css)
    - [Fichero 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/resources/templates/chat.html)
 
  **PRÁCTICA 2**
  - **5 commits más significativos:**
    - [Commit 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/13a4181780159460c9c78d65c0f4731b24a83181)
    - [Commit 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/ff908ac7d7b3b4cf9a13dd033d507df6f24d745d)
    - [Commit 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/32fee98b7f3c8ed6731b1e2b208acf9d5f4a84be)
    - [Commit 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/ffeb363ed6c06b5a10922990feeef4226212d760)
    - [Commit 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/568918e2b70db20068071631276a7838dc26394a)
   
  - **5 ficheros en los que se ha participado:**
    - [Fichero 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/security/SecurityConfig.java)
    - [Fichero 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/controller/rest/ReviewRestController.java)
    - [Fichero 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blame/main/pixeltrade/src/main/java/es/grupo12/security/jwt/JwtRequestFilter.java)
    - [Fichero 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blame/main/pixeltrade/src/main/java/es/grupo12/controller/rest/ProductRestController.java)
    - [Fichero 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blame/main/pixeltrade/src/main/java/es/grupo12/security/jwt/JwtTokenProvider.java)

 ### Tayson Pérez Bernaerts

- **Tareas 1:**  Gestión de productos, todo lo relacionado con subir productos, ver la página del producto, compra, edición, recomendados, búsqueda... Código del controlador de productos, repositorio y servicio. Conexión de la aplicación con la base de datos e instalación de dependencias necesarias. Creación de administrador con funciones iniciales. Creación del diagrama de clases y templates.

- **Tareas 2:** Conexión HTTPS con la página, añadido CSFR, roles de usuarios (USER, ADMIN), encriptado de contraseñas, todo lo relacionado con el apartado de seguridad de la aplicación. Colaborado con la creación de varios controladores REST. Creación de la colección postman con operaciones de consulta GET, POST, DELETE, PUT. Actualización del diagrama de clases y templates.


- **5 commits más significativos:**
    - [Commit 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/d11f2e0d2da1f6e5f4afd061074d6958e315ec75)
    - [Commit 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/71bbe4883f1fb20f13570287470afd8df4e1f99c)
    - [Commit 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/59ae9075618b2ceaf1d47da49156ab7f67d392e6)
    - [Commit 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/ae33245c6f9c8cc89022d2c1f13788e54adc8e55)
    - [Commit 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/93884f8346838bd4b9546ea55d939cd848ab13db)
 

- **5 ficheros en los que se ha participado:**  
    - [Fichero 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/controller/ProductWebController.java)
    - [Fichero 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/model/Product.java)
    - [Fichero 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/repository/ProductRepository.java)
    - [Fichero 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/service/ProductService.java)
    - [Fichero 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/resources/static/style1.css)
 
  **PRÁCTICA 2**
  - **5 commits más significativos:**
    - [Commit 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/db2593a6ab14d564ce9b8ccca6a9b968128cdd71)
    - [Commit 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/069a1c772f4a9f6d215c92ad3f58a4b67c5f7ac0)
    - [Commit 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/219ba8d2a789f314d96e9b20dc088ffccd793d90)
    - [Commit 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/e2e823d91f7ce27c471d582aee4a3babe7b3188a)
    - [Commit 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/9fe2d938c2bbfaefcfc6ca62f9793b9b19661c0e)
   
  - **5 ficheros en los que se ha participado:**
    - [Fichero 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/security/SecurityConfig.java)
    - [Fichero 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/Postman%20collection.postman_collection.json)
    - [Fichero 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/controller/rest/MessageRestController.java)
    - [Fichero 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/src/main/java/es/grupo12/controller/rest/ProductRestController.java)
    - [Fichero 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/main/pixeltrade/pom.xml)

### Daniel Muñoz Martínez

- **Tareas 1:**  Gestión de la sesión de los usuarios, persistencia de las imágenes en BD mySQL, todas las funciones relacionadas con las reseñas, creación de htmls de (inicio sesión, registro, relacionados con el perfil y admin...), gestión del usuario admin (consulta y borrado entidades), codificación de métodos de los controladores (principalmente en las clases User, Review y Product) y desarrollo de documentación.
- **Tareas 2:**  Desarrollo y mejora de los controladores de la API REST, con un enfoque en seguridad con JWT, manejo de errores y documentación. Tareas de depuración, optimización de controladores, y ajustes en las estructuras de datos (DTOs). Además de la actualización de la herramienta de prueba de APIs usada Postman para facilitar la validación de endpoints.

- **5 commits más significativos:**  
    - [Commit 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/229421cc84c8e7ceff19d5ae5f6826873dd83aa8)
    - [Commit 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/8cf6750b328f035874879b7509aa84120d8d5c40)
    - [Commit 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/660e5c56496d3a2e60ec6657b01fdfb802adce0f)
    - [Commit 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/1c67a0f6d5a276908591a20fdee530e85127732f)
    - [Commit 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/commit/3d743c44fabbba2999627850d1915dcc127beea9)
 

- **5 ficheros en los que se ha participado:**  
    - [Fichero 1](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/daa834a55a1a745f47e54afd606d9c2e7fd034c6/pixeltrade/src/main/java/es/grupo12/controller/rest/ProductRestController.java)
    - [Fichero 2](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/daa834a55a1a745f47e54afd606d9c2e7fd034c6/pixeltrade/src/main/java/es/grupo12/controller/rest/MessageRestController.java)
    - [Fichero 3](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/daa834a55a1a745f47e54afd606d9c2e7fd034c6/pixeltrade/src/main/java/es/grupo12/controller/rest/UserRestController.java)
    - [Fichero 4](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/daa834a55a1a745f47e54afd606d9c2e7fd034c6/Postman%20collection.postman_collection.json)
    - [Fichero 5](https://github.com/SSDD-2025/practica-sistemas-distribuidos-2025-grupo-12/blob/daa834a55a1a745f47e54afd606d9c2e7fd034c6/pixeltrade/src/main/java/es/grupo12/controller/rest/ReviewRestController.java)


---

## Instrucciones de ejecución:

1. Descargar este repositorio
2. Abrir XAMPP e iniciar servers de Apache y MySQL
3. Crear una base de datos en MySQL llamada prueba_distribuidos
4. Ejecutar desde vscode
5. Entrar a la página desde https://localhost:8443
6. Usar el software Postman para importar el archivo de la colección

### Instalaciones
- Java 21
- Visual Studio Code
- Maven 4.0
- XAMPP 8.2.4
- Spring Boot 3.4.2
- Postman

## Instrucciones de ejecución con ficheros Docker-Compose

### Docker-compose.prod.yml

Este fichero permite ejecutar dos contenedores: 
- Uno con la aplicación, usando una imagen ya publicada
- Otro con la base de datos a usar, usando la imagen pública de MySql. Aclarar que se creará un volumen dentro de este contenedor para que la información de la base de datos no pierda sus cambios.
  
Para poder ejecutar los ficheros docker compose, simplemente es necesario ejecutar el siguiente comando en la ruta /pixeltrade/docker
````sh
docker compose -f docker-compose.prod.yml up
````
Esto activará los contenedores de la aplicación pixeltrade y mysql, los cuales se contectarán automáticamente.
Para acceder a la página web, sólo es necesario acceder a la URL: https://localhost:8443


### Docker-compose.local.yml

Este fichero ejecutará dos contenedores
- Uno con la aplicación. Esta vez, este se dockeriza automáticamente en caso de que no esté instalado en el equipo, usando el dockerfile ya incluido en los archivos
- Otro con la base de datos a usar, usando la imagen pública de MySql. Esta vez, el volumen se creará en una propia ruta local del host, para preservar los cambios de la base de datos.

Para poder ejecutar los ficheros docker compose, simplemente es necesario ejecutar el siguiente comando en la ruta /pixeltrade/docker
````sh
docker compose -f docker-compose.local.yml up
````
Esto activará los contenedores de la aplicación pixeltrade (dockerizará antes si es necesario) y mysql, los cuales se contectarán automáticamente.
Para acceder a la página web, sólo es necesario acceder a la URL: https://localhost:8443

## Instrucciones de construcción de imagen

### Construcción con Dockerfile

Para crear la imagen con dockerfile, sólo es necesario ejecutar el siguiente comando en la ruta /pixeltrade/docker:
````sh
docker build -f ./Dockerfile -t dmunozm5/pixeltrade:1.0.0 ..
````
Sustituyendo dmunozm5 por tu cuenta de docker y pixeltrade:1.0.0 por el nombre y version que se desee.


### Construcción con buildpacks

Para construir la imagen con buildpacks, sólo es necesario ejecutar el siguiente comando:
````sh
$ mvn spring-boot:build-image
````
Este comando usará el nombre y versión especificados en el archivo pom.xml.


En el caso de que queramos especificar nuestro propio nombre, podemos ejectuar el siguiente comando:
````sh
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=username/appname:version
````

## Despliege en máquinas virtuales

Para el despliegue de la aplicación en máquinas virtuales, necesitaremos acceder a ambas y ejecutar el siguiente comando para instalar docker:
````sh
curl -fsSL https://get.docker.com -o get-docker.sh
````

Para acceder a la máquina 1, se usará el comando:
````sh
ssh -i ssh-keys/sidi12.key vmuser@193.147.60.52

````
Para acceder a la máquina 2, se usará el comando:
````sh
ssh -t -i ssh-keys/sidi12.key vmuser@193.147.60.52 ssh sidi12-2
````

Una vez Docker está instalado en ambas, se puede ejecutar el contenedor de MySql para la base de datos en la máquina 2 con el comando:
````sh
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=pixeltrade -e MYSQL_PASSWORD=password -p 3306:3306 -d mysql:8
````

Después, en la máquina 1, se puede ejecutar el siguiente comando para lanzar el contenedor de la aplicación y conectarlo a través del puerto compartido en la máquina 2 al contenedor de la base de datos:
````sh
docker run -p 8443:8443 -e SPRING_DATASOURCE_URL=jdbc:mysql://192.168.110.7/pixeltrade dmunozm5/pixeltrade:1.0.0

````

Al terminar estos pasos, se podrá acceder a la aplicación a traves del siguiente enlace, donde se debe usar la ip de la máquina 1:
`https://193.147.60.52:8443`
