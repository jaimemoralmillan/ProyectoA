# Plan de Proyecto

## Portada
**Título del Proyecto**: Sistema de Monitorización de Consumo Eléctrico   
**Nombre del Proyecto**: monitorizacion-electrica 
**Integrantes del Equipo de Trabajo**: Ángela Hernández Valverde , Nicklas Stæhr Pérez, Briceida Fernández Aguirre,Jaime Moral Millán
**Fecha**: 05/06/2024

## Índice
1. [Resumen Ejecutivo](#resumen-ejecutivo)
2. [Descripción del Proyecto](#descripcion-del-proyecto)
3. [Estructura de Desglose del Trabajo (EDT)](#estructura-de-desglose-del-trabajo-edt)
4. [Cronograma del Proyecto](#cronograma-del-proyecto)
5. [Organización del Proyecto](#organizacion-del-proyecto)
11. [Plan de Implementación y Cierre](#plan-de-implementacion-y-cierre)
12. [Apéndices](#apendices)

## Resumen Ejecutivo

**Descripción breve del proyecto:**

    Aplicación de escritorio para la monitorización de consumo eléctrico en la vivienda.

**Objetivos principales:**

    - Monitorizar el consumo eléctrico en la vivienda.
    - Mostrar de manera accesible el gasto económico del uso de los dispositivos conectados a la red eléctrica.
    - Proporcionar cálculos diarios, semanales y mensuales de dicho consumo, y mostrarlos gráficamente.
    - Proporcionar información sobre cuáles son los dispositivos gastan más, y cuáles son las franjas horarias recomendadas para cada uno.
    
**Beneficios esperados:**

    Ayudar al usuario final a mejorar el entendimiento de su consumo eléctrico, de manera que le permita ahorrar económicamente en el proceso.

**Impacto esperado del proyecto**

    **- Dimensión económica:**
     
    El proyecto tiene un impacto económico significativo al permitir a los usuarios reducir su factura de consumo eléctrico. Al ofrecer información detallada sobre el uso de energía, los usuarios pueden identificar los dispositivos que consumen más electricidad y ajustar su uso para maximizar el ahorro. Esto no solo ayuda a las familias a gestionar mejor sus finanzas domésticas, sino que también puede tener un efecto positivo en la economía al reducir la demanda de energía.

    **- Dimensión social:**
     
    Desde una perspectiva social, el proyecto educa a los usuarios sobre la importancia de un consumo eléctrico responsable. Al proporcionar datos claros y recomendaciones sobre las mejores franjas horarias para utilizar ciertos dispositivos, el sistema fomenta hábitos de consumo más eficientes. Este tipo de educación puede tener un efecto multiplicador, ya que los usuarios pueden compartir sus conocimientos y prácticas con otros, amplificando el impacto positivo en la comunidad.

    **- Dimensión ambiental:**

    El impacto ambiental del proyecto es notable. Al ayudar a los usuarios a optimizar su consumo de energía, se contribuye a la reducción de la huella de carbono. Un menor consumo de energía en los hogares implica una menor demanda de electricidad, lo que puede resultar en una reducción de la producción de energía en plantas generadoras que utilizan combustibles fósiles. Esto, a su vez, disminuye las emisiones de gases de efecto invernadero y otros contaminantes. Además, el proyecto puede promover el uso de fuentes de energía más sostenibles y la adopción de tecnologías más eficientes, contribuyendo a un futuro más verde y sostenible.

    **- Futuro emprendimiento:**
    
    El proyecto tiene un potencial considerable para convertirse en un emprendimiento comercial viable. La combinación de la aplicación de monitorización con sensores específicos para medir el consumo eléctrico abre oportunidades para la comercialización del sistema completo. Además, la creciente conciencia sobre la sostenibilidad y el ahorro energético puede aumentar la demanda de este tipo de soluciones, permitiendo a la empresa expandir sus operaciones y posiblemente diversificar sus productos y servicios en el futuro.

**Resumen del cronograma y presupuesto**

    - Semana 1: Identificación y planificación de la estructura del proyecto.
    - Semana 2 y 3: Planificación y desarrollo de la Base de Datos del proyecto.
    - Semana 4: Pruebas e implementación final de la BDD del proyecto.
    - Semana 5: Implementación de la conexión entre la aplicación y la BDD mediante el protocolo JDBC. 
                Primer contacto con interfaz gráfica mediante Swing, y creación de las primeras funciones.     
    - Semana 6: Realización de las funciones DAO necesarias para la inserción,borrado, actualización y retorno de datos de la Base de Datos. 
    - Semana 7: Lectura de archivos JSON y creación de funciones para tratar sus datos.
    - Semana 8: Realización de funciones de cálculo finales y representación mediante gráficas.

    En definitiva, el proyecto se llevó a cabo en los meses de abril y mayo de 2024. No consta de presupuesto, puesto que ha sido elaborado por alumnado del ciclo de DAM en los módulos de Programación y Entornos de Desarrollo.

## Descripción del Proyecto

### Antecedentes

**Contexto y justificación del proyecto:** 

    En la actualidad, el consumo energético en las viviendas ha cobrado una gran relevancia debido a diversos factores. Entre ellos, destacan el aumento de los costos de la electricidad, la creciente preocupación por el impacto ambiental del consumo de energía y la necesidad de optimizar el uso de recursos en el hogar. Las viviendas modernas están equipadas con una variedad de dispositivos electrónicos y electrodomésticos que, si bien aportan comodidad y eficiencia, también contribuyen significativamente al consumo energético total. En este contexto, la monitorización eléctrica se presenta como una herramienta esencial para gestionar de manera eficiente el uso de la electricidad.

### Objetivos

**Objetivos generales:**

    - Reducir el uso innecesario de energía eléctrica en la vivienda mediante la identificación de patrones de consumo y oportunidades para mejoras en la eficiencia energética.

    - Disminuir el monto de la factura eléctrica a través de la implementación de medidas correctivas basadas en los datos obtenidos del sistema de monitorización.

    - Contribuir a la reducción de la huella de carbono de la vivienda mediante el uso más eficiente de la electricidad.

**Objetivos específicos:**

    - Monitorizar y analizar el consumo eléctrico de cada dispositivo o electrodoméstico para identificar aquellos que utilizan más energía de lo necesario.
    
    - Ayudar a llevar a cabo acciones específicas para reducir el consumo energético, como el ajuste de hábitos de uso.

    - Proveer información a los usuarios sobre prácticas de consumo energético eficientes.

    - Proporcionar datos precisos y en tiempo real que permitan a los usuarios tomar decisiones informadas sobre el uso de la energía.

    - Proveer un entorno más seguro para los habitantes de la vivienda mediante el control y la optimización del uso de la electricidad, reduciendo riesgos como sobrecargas y fallos eléctricos.

### Alcance

El proyecto de monitorización eléctrica en la vivienda tiene como objetivo principal implementar un sistema integral que permita registrar, analizar y optimizar el consumo energético en tiempo real. Esto se logrará mediante la instalación de dispositivos de monitorización, software de análisis y la capacitación de los residentes en el uso de las herramientas proporcionadas. 

Sin embargo, en este proyecto inicial, no ha sido posible la instalación de dispositivos de monitorización, por lo que los datos de consumo eléctrico y precio de la electricidad han sido implementados mediante la lectura y analisis de archivos JSON , generados mediante IA, y basados en datos reales obtenidos mediante una API pública que registra y muestra el precio de la luz en España en tiempo real.

### Entregables

    - Base de datos de la aplicación.
    - Funcionalidades CRUD.
    - Interfaz de usuario.
    - Diagrama de clases.
    - Diagrama de secuencia.
    - Casos de uso.
    - Informe de progreso.
    - Informe final.
    - Plan de proyecto.
    - Cronograma.
    - Aplicación.
    - Capturas de las interfaces principales

## Estructura de Desglose del Trabajo (EDT)
### Desglose Jerárquico y Descripción de Tareas

1. Identificación y planificación de la estructura del proyecto

    - Identificación de la idea inicial del proyecto.
    - Creación del proyecto con Maven.
    - Estructura básica de carpetas (Modelo vista-controlador)
    - Realización de esquema de clases.
    
2. Planificación y desarrollo de la Base de Datos del proyecto.
     
    - Realización de esquema UML.
    - Realización de los scripts de creación de BDD.
    
3. Pruebas e implementación final de la BDD del proyecto.

    - Instalación de entorno phpmyadmin y MySQL server mediante docker.
    - Pruebas de inserción.
    - Pruebas de obtención de datos.
    - Pruebas de borrado de datos.
    
4. Implementación de la conexión entre la aplicación y la BDD mediante el protocolo JDBC. 

    - Creación de clases DAO
    - Creación de clases DTO
    - Primer contacto y aprendizaje de clases por defecto de JDBC (DriverManager, Conection, etc).
         
5. Primer contacto con interfaz gráfica mediante Swing, y creación de las primeras funciones. 

    - Elaboración de el panel principal de la interfaz gráfica
    - Implementación de algunas funciones básicas con su correspondiente pestaña en Swing (Agregar Dispositivo, Eliminar Dispositivo y Modificar Dispositivo)

6. Realización de las funciones DAO necesarias 

    - Funciónes de insertado.
    - Funciones de eliminación.
    - Funciones de actualización.
    - Funciones de obtención de datos (Obtener todos los dispositivos, obtener dispositivo por id, etc)

7. Lectura de archivos JSON y creación de funciones para tratar sus datos.

    - Función para leer y tratar datos del archivo JSON con los precios de la electricidad.
    - Funcion para leer y tratar datos del archivo JSON con la información de los Eventos de Consumo simulados.
    - Funciones para insertar los datos extraidos de los archivos JSON en sus respectivas tablas de la BD.

8. Realización de funciones de cálculo finales y representación mediante gráficas.

    - Función de inserción en tabla relacional de Eventos de Consumo y Precio electricidad.
    - Funciones de cálculo de precio final por días, semanas o mes.
    - Funciones de cálculo de precio por dispositivo único
    - Otras funciones varias de cálculo.

Todos los miembros del equipo hemos participado en todas las tareas del proyecto.

## Cronograma del Proyecto
### Diagrama de Gantt

![Diagrama de Gantt](/monitorizacion_electrica/docs/gestion_proyecto/diagramaDeGantt.png)

### Hitos del Proyecto

- Inicio del Proyecto:
    - Fecha: 01-04-24
    - Descripción: Elección del tema y lluvia de ideas sobre las funcionalidades de la aplicación.

- Planificación inicial de la Base de Datos:
    - Fecha: 08-04-24
    - Descripcion: Identificación de puntos claves y recopilación de datos iniciales.

- Conexión del proyecto con la base de datos con el protocolo JDBC:
    - Fecha: 01-05-24
    - Descripción: Conexión del proyecto con la base de datos y pruebas para comprobar su correcto funcionamiento.

- Elaboración de las primeras funciones DAO.
    - Fecha: 06-05-24
    - Descripción: Creación de funciones CRUD.

- Elaboración de los JSON para la simulación de la recolección de Datos, lectura y tratamiento de datos:
    - Fecha: 15-05-24
    - Descripción: Generación de los archivos JSON teniendo en cuenta los datos de los precios de la electricidad en tiempo real en España y los eventos de consumo para su posterior lectura y tratamiento de los datos obtenidos

- Elaboración de las funciones de cálculo para controlar el consumo diario, semanal y mensual por dispositivo.
    - Fecha: 27-05-24
    - Descripción: Elaboración de las funciones para los cálculos necesarios y la posterior ejecución de los gráficos correspondientes.

- Informe final y presentación del proyecto:
    - Fecha: 05-06-24
    - Descripción: Entrega del informe y presentación del proyecto en clase.

### Dependencias

- Identificación y planificación de la estructura del proyecto.
    - Dependencias: Ninguna.
    - Tareas dependientes: Planificación y desarrollo de la Base de Datos.
    
- Planificación y desarrollo de la Base de Datos del proyecto.
    - Dependencias: Identificación y planificación de la estructura del proyecto.
    - Tareas dependientes: Pruebas e implementación de la BD del proyecto.
    
- Pruebas e implementación final de la BD del proyecto.
    - Dependencias: Planificiación y desarrollo de la BD del proyecto.
    - Tareas dependientes: Implementación de la conexión entre la aplicación y la BD mediante el protocolo JDBC.
    
- Implementación de la conexión entre la aplicación y la BD mediante el protocolo JDBC. 
    - Dependencias: Pruebas e implementación final de la BD del proyecto.
    - Tareas dependientes: Realización de las funciones DAO.
         
- Primer contacto con interfaz gráfica mediante Swing, y creación de las primeras funciones. 
    - Dependencias: Implementación de la conexión entre la aplicación y la BD mediante el protocolo JDBC. 
    - Tareas dependientes: Realización de las funciones DAO necesarias. 

 - Realización de las funciones DAO necesarias. 
    - Dependencias: Primer contacto con interfaz gráfica mediante Swing, y creación de las primeras funciones. 
    - Tareas dependientes: Realización de funciones de cálculo finales y representación mediante gráficas.

 - Lectura de archivos JSON y creación de funciones para tratar sus datos.
    - Dependencias: Realización de las funciones DAO necesarias.
    - Tareas dependientes: Realización de funciones de cálculo finales y representación mediante gráficas.

- Realización de funciones de cálculo finales y representación mediante gráficas.
    - Dependencias: Lectura de archivos JSON y creación de funciones para tratar sus datos.
    - Tareas dependientes: Ninguna.


## Organización del Proyecto
### Equipo del Proyecto
Todos los miembros del equipo han contribuido de manera equitativa a todas las tareas del proyecto.

### Estructura Organizativa
- Líder del proyecto: Jaime.
- Equipo Técnico: Nicklas, Briceida, Jaime y Ángela.

### Recursos

- Recursos humanos: equipo técnico (4 programadores).
- Recursos materiales: espacio de trabajo como el aula, presentación. 
- Recursos tecnológicos: conexión a internet, orenadores, ratones, teclados, microsoft teams, discord, github, canva.

### Calendario de Reuniones

Reuniones presenciales en horario lectivo y online a través de Discord según necesidades puntuales del proyecto.

## Plan de Implementación y Cierre

- Fase 1: Preparación y Planificación
    - Inicio del proyecto:
        - Tareas:
            - Reunión inicial con todos los participantes.
            - Establecimiento del cronograma del proyecto.
        - Entregables:
            - Cronograma detallado.

- Fase 2: Análisis y Diseño. Creación de Diagramas
    - Diagrama de Clases:
        - Tareas:
            - Identificación de las clases necesarias para el proyecto.
            - Definición de atributos y métodos de cada clase.
        - Entregables:
            - Diagrama de clases.        

    - Diagrama de Secuencia:
        - Tareas:
            - Definición de interacciones entre objetos.
            - Especificación del orden de mensajes entre objetos.
        - Entregables:
            - Diagrama de secuencia. 
    
    - Diagrama de Casos de Uso:
        - Tareas:
            - Identificación de actores y casos de uso del sistema.
            - Descripción de interacciones entre actores y el sistema.
        - Entregables:
            - Diagrama de casos de uso.

- Fase 3: Desarrollo e Implementación
    - Desarrollo:
        - Tareas:
            - Codificación de las clases y funcionalidades.
        - Entregables: 
            - Código funcional del sistema de monitorización eléctrica. 

- Fase 4: Documentación 
    - Informe de Progreso:
        - Tareas:
            - Recolección de datos sobre el progreso del proyecto.
            - Redacción del informe de progreso detallando las actividades realizadas.
        - Entregables:
            - Informe de proreso. 

    - Informe Final:
        - Tareas:
            - Redacción del informe de final.
        - Entregables:
            - Informe final del proyecto.

### Estrategia de Implementación

- Planificación Inicial:
    - Establecer metas y objetivos claros.
    - Definir un cronograma con fechas específicas.

- Desarrollo de Diagramas:
    - Diagrama de Clases:
        - Reuniones de brainstorming para identificar las clases y sus relaciones.
        - Utilizar PlantUml para crear el diagrama.
    - Diagrama de Secuencia:
        - Definir los escenarios principales y documentar las interacciones entre objetos.
        - Crear el diagrama utilizando PlantUml.
    - Diagrama de Casos de Uso:
        - Identificar actores y casos de uso relevantes.
        - Crear el diagrama y validarlo con el equipo.

- Informes:
    - Informe de Progreso:
        - Recolectar información sobre el estado actual del proyecto.
        - Redactar el informe.
    - Informe Final:
        - Redactar un informe completo que incluya todos los aspectos del proyecto.

- Gestión del Proyecto:
    - Plan del Proyecto:
        - Definir el alcance, objetivos, cronograma y recursos necesarios.
        - Documentar el plan y revisarlo con el equipo.
    - Cronograma:
        - Crear un cronograma.

### Cierre del Proyecto

El cierre del proyecto incluyó la revisión final del sistema, la corrección de errores detectados durante las pruebas y la entrega de toda la documentación requerida. Se realizó una evaluación del proyecto con el equipo y se obtuvieron retroalimentaciones para futuros proyectos.

## Apéndices
### Documentación Adicional

- Diagramas UML:
    - [Diagrama de Base de Datos](/monitorizacion_electrica/docs/diagramas/base_de_datos/DiagramaEntidadRelacion.puml)
    - [Diagrama de Casos de Uso](/monitorizacion_electrica/docs/diagramas/casos_de_uso/DiagramaCasos.puml)
    - [Diagrama de Clases y Paquetes A](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClaseDTO.puml)
    - [Diagrama de Clases y Paquetes B](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClasesDAO.puml)
    - [Diagrama de Clases y Paquetes C](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClasesNegocio.puml)
    - [Diagrama de Clases y Paquetes D](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClasesUI.puml)
    - [Diagrama de Secuencia: Calculo por Dia](/monitorizacion_electrica/docs/diagramas/secuencia/diagramaSecuenciaCalculoPorDia.puml)
    - [Diagrama de Secuencia: Insertar Dispositivo desde JSON](/monitorizacion_electrica/docs/diagramas/secuencia/diagramaSecuenciaInsertarDispositivosDesdeJson.puml)
    