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
- Administrador: puede hacer todo lo que hace un usuario registrado y además puede borrar cuentas y editar y borrar productos.
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


## Diagrama de navegación
![DiagramaNavegacion](Images/DiagramaNavegacion.png)


## Diagrama de entidades
![DiagramaEntidades](Images/DiagramaEntidades.png)


## Diagrama de clases y templates
![DiagramaClasesTemplates](Images/DiagramaClasesTemplates.png)

## Participación de miembros
Cabe destacar que hemos trabajado generalmente en grupo todos en un mismo ordenador por lo que muchos de los commits asociados a una cuenta específica son desarrollados por todos, al igual que los ficheros creados.
### Martín Gutiérrez Parada

- **Tareas:**  Gestión de la sesión de los usuarios, subir imágenes en un producto, todas las funciones relaciondas con los mensajes, creación de htmls y css, header y footer, diseños de páginas, codificación de métodos de los controladores, diagrama de entidades y navegación, desarrollo de la documentación.

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

 ### Tayson Pérez Bernaerts

- **Tareas:**  Gestión de productos, todo lo relacionado con subir productos, ver la página del producto, compra, edición, recomendados, búsqueda... Código del controlador de productos, repositorio y servicio. Conexión de la aplicación con la base de datos e instalación de dependencias necesarias. Creación de administrador con funciones iniciales. Creación del diagrama de clases y templates.


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


---

## Instrucciones de ejecución:

1. Descargar este repositorio
2. Abrir XAMPP e iniciar servers de Apache y MySQL
3. Crear una base de datos en MySQL llamada prueba_distribuidos
4. Ejecutar desde vscode
5. Entrar a la página desde localhost:8080

### Instalaciones
- Java 21
- Visual Studio Code
- Maven 4.0
- XAMPP 8.2.4
- Spring Boot 3.4.2
