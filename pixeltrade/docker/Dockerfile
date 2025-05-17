# Imagen base para el contenedor de compilación
FROM maven:3.9.9-eclipse-temurin-21-jammy AS builder

# Define el directorio de trabajo donde ejecutar comandos
WORKDIR /pixeltrade

# Copia las dependencias del proyecto
COPY pom.xml /pixeltrade/

# Descarga las dependencias del proyecto
RUN mvn dependency:go-offline

# Copia el código del proyecto
COPY /src /pixeltrade/src

# Compila proyecto
RUN mvn -B package -DskipTests

# Imagen base para el contenedor de la aplicación
FROM eclipse-temurin:21-jre

# Define el directorio de trabajo donde se encuentra el JAR
WORKDIR /usr/src/app/

# Copia el JAR del contenedor de compilación
COPY --from=builder /pixeltrade/target/*.jar /usr/src/app/app.jar

# Indica el puerto que expone el contenedor
EXPOSE 8443

# Comando que se ejecuta al hacer docker run
CMD [ "java", "-jar", "app.jar" ] 