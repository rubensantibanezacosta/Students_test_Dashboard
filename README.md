# CRUD de calificaciones de estudiantes

Un panel de gestión de calificaciones por estudiante, año y asignatura. Implementado con Angular en el Frontend, @Spring en el Backend, y MySQL para la base de datos.
## Comenzando 🚀

Clona el repositorio `git clone https://github.com/rubensantibanezacosta/Students_test_Dashboard.git`


## Pre-requisitos 📋

- Sistema Operativo **Windows** o **Linux**

- **Node.js** y **NPM**  ***https://nodejs.org/es/***

- **Maven** (*En Windows, recuerda configurar tu variable __"MAVEN_HOME"__ en el path*) ***https://maven.apache.org/download.cgi***

- **MySQL** o **MariaDB** ***https://www.mysql.com/downloads/***

- **JDK 11** ***https://www.oracle.com/es/java/technologies/javase/jdk11-archive-downloads.html***


## Instalación 🔧 *2 minutos aproximadamente*

- Importa el archivo **Estudiantes.sql** a tu servidor MySQL. Ruta `backend/Estudiantes.sql` 

- Modifica las credenciales de acceso a MySQL del archivo aplication.properties en la ruta `backend/src/main/resources/application.properties`

### WINDOWS

- En la raiz del proyecto, abre una terminal y ejecuta los scripts:

    ###### *Para instalar paquetes*
      
    - `npm run w:install` 
    
    ###### *Para lanzar el proyecto teniendo los paquetes instalados*
    
    - `npm run w:launch` para lanzar la aplicación si ya tienes los paquetes instalados


    ***Abrir el navegador en  http://localhost:4200/*** tras la espera.


### LINUX

- En la raiz del proyecto, abre una terminal y ejecuta los scripts:

    ***Para nstalar paquetes y lanzar el proyecto***
      
    - `npm update`
    - `npm install`
    - `npm run update-launch` 
    
    ***Para lanzar el proyecto teniendo los paquetes instalados***
    
    - `npm run start` para lanzar la aplicación si ya tienes los paquetes instalados


    ***Abrir el navegador en  http://localhost:4200/*** tras la espera.

## Uso 📦

La interfaz es bastante intuitiva y sencilla:


![Captura de pantalla de 2021-10-20 09-40-09](https://user-images.githubusercontent.com/44450566/138066609-26a160ea-c22d-45bf-bd01-2546a43e6fdb.png)
![Captura de pantalla de 2021-10-20 09-40-00](https://user-images.githubusercontent.com/44450566/138066600-995e0495-2242-4108-ad85-72d66f34c1e4.png)






## Construido con 🛠️


* [Angular 12](https://angular.io) - *El framework JS usado*



* [Bootstrap v5.0](https://getbootstrap.com/docs/5.0/getting-started/introduction) - *El framework CSS usado*



* [Maven 3.6.3](https://maven.apache.org) - *Manejador de dependencias*
* [Spring boot 2.5.5](https://spring.io/projects/spring-boot) - *Framework usado para el Backend*
* [Hibernate](https://hibernate.org) - *Framework integrado en Spring boot*
     - *Comentarios*
        - > Mapeado autómatico de base de datos apoyado en el IDE
        - > CrudRepository Dao, con metodos Dao personalizados



* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea) - *IDE utilizado*
* [Visual Studio Code](https://code.visualstudio.com) - *Editor utilizado*


## Autores ✒️


* **Ruben Santibañez Acosta** - *Desarrollo y documentación* -  [rubensantibanezacosta](https://github.com/rubensantibanezacosta)


## Agradecimientos ✒️


* **Tiburcio Cruz Ravelo** - *Asesoría técnica* -  [tcurav](https://github.com/tcrurav)
* **Gemma Alemán Santana** - *Asesoría técnica* 


---
⌨️ con ❤️ por [rubensantibanezacosta](https://github.com/rubensantibanezacosta) 😊
