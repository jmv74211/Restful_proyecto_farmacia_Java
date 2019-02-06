# Restful Farmacia en Java
## Autor: Jonathan Martín Valera
### Repositorio creado para la asignatura de *Desarrollo de software basado en componentes y servicios* en el máster de ingeniería informática en Granada
#### Fecha de realización: Enero 2019

---

# Tabla de contenidos

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [Descripción](#descripci%C3%B3n)
  - [Modelo entidad relación](#modelo-entidad-relaci%C3%B3n)
  - [Paquetes](#paquetes)
  - [Modelo conceptual](#modelo-conceptual)
  - [Modelo DAO](#modelo-dao)
  - [Recursos del servicio](#recursos-del-servicio)
- [Herramientas utilizadas](#herramientas-utilizadas)
- [Desarrollo e implementación](#desarrollo-e-implementaci%C3%B3n)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

---

# Descripción

Creación de un sistema para poder gestionar un sistema de farmacias y compras de medicamentos. La aplicación creará un modelo persistente, utilizando **hibernate**
como implementación de JPA para la persistencia de datos, y utilizando como sistema de gestor de base de datos mariaDB. Una vez creado dicho esquema (modificando el archivo persistence.xml), se proporcionará una capa de datos DAO que conectarán los datos almacenados en la base de datos con la aplicación. Posteriormente, se utilizará dicha capa DAO para construir el conjunto de recursos que gestionará el servicio restful.

## Modelo entidad relación

![img](https://raw.githubusercontent.com/jmv74211/Restful_proyecto_farmacia_Java/master/images/modelo_e-r.png)

## Paquetes

![img](https://raw.githubusercontent.com/jmv74211/Restful_proyecto_farmacia_Java/master/images/paquetes.png)

## Modelo conceptual

![img](https://raw.githubusercontent.com/jmv74211/Restful_proyecto_farmacia_Java/master/images/modelo_conceptual.png)

## Modelo DAO

![img](https://raw.githubusercontent.com/jmv74211/Restful_proyecto_farmacia_Java/master/images/modelo_dao.png)

## Recursos del servicio

![img](https://raw.githubusercontent.com/jmv74211/Restful_proyecto_farmacia_Java/master/images/modelo_recursos.png)


---

# Herramientas utilizadas

- IDE: Eclipse Java EE IDE for Web Developers. Version: Neon.3 Release (4.6.3)
- Java: 1.8.
- Server: Apache Tomcat 9.0
- Servidores ubicados en Azure
- Base de datos: MariaDB
- Cliente base de datos: HeidiSQL

---

# Desarrollo e implementación

Para documentar esta práctica, he decidido grabar un vídeo y subirlo a youtube donde
muestro como he diseñado la práctica y cuál es el resultado de su implementación.
Enlace a vídeo donde se explica el desarrollo de la práctica 4: https://youtu.be/XXgQT4l3oVI
Para ejecutar las aplicaciones, es necesario utilizar el servicio restful desplegado en la máquina
http://104.45.16.127:8080, ya que dicha máquina también contiene la base de datos que
utiliza la aplicación.
Se puede ejecutar la aplicación web en el servidor tomcat local de eclipse, el cual utiliza
predeterminadamente el servicio restful ubicado en la nube.
Para más información se puede consultar el vídeo, donde se explica todo.
