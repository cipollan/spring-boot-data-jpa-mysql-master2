<<<<<<< HEAD
# Comment
FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/*.jar
# Crea una directory per l'applicazione
RUN mkdir /app
# Imposta la directory di lavoro corrente
WORKDIR /app
COPY ${JAR_FILE} ${WORKDIR} 
COPY ${JAR_FILE} /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/spring-boot-data-jpa-0.0.1-SNAPSHOT.jar"]
RUN echo 'we are running some # of cool things'



# Usa una immagine di base con Java
##FROM openjdk:11-jre-slim


# Avvia l'applicazione Spring Boot quando il contenitore Docker viene eseguito
##CMD ["java", "-jar", "app.jar"]
=======

# Use an official MySQL image as the base image
FROM mysql:8.0

# Set environment variables
ENV MYSQL_ROOT_PASSWORD andrea
ENV MYSQL_DATABASE testdb
ENV MYSQL_USER andrea
ENV MYSQL_PASSWORD andrea

# Copy the schema file to the container
#COPY schema.sql /docker-entrypoint-initdb.d/


EXPOSE 3306 33060
CMD ["mysqld"]


#docker build -t myjpa .
#docker build -t image_name .

#RUN docker-compose up
#docker build - < Dockerfile
>>>>>>> 5d3444820e9345f0729cf27f30499e40f2c1a6e0
