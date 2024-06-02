# Informe del Proyecto: Sistema de Monitorización de Consumo Eléctrico   

## Portada
**Título del Proyecto**: Sistema de Monitorización de Consumo Eléctrico   
**Nombre del Proyecto**: monitorizacion-electrica  
**Integrantes del Equipo de Trabajo**: Ángela Hernández Valverde , Nicklas Stæhr Pérez, Briceida Fernández Aguirre, Jaime Moral Millán
**Fecha**: 05/06/2024

## Índice
1. [Resumen Ejecutivo](#resumen-ejecutivo)
2. [Descripción del Proyecto](#descripción-del-proyecto)
3. [Estructura de Desglose del Trabajo (EDT)](#estructura-de-desglose-del-trabajo-edt)
4. [Cronograma del Proyecto](#cronograma-del-proyecto)
5. [Organización del Proyecto](#organización-del-proyecto)
6. [Plan de Implementación y Cierre](#plan-de-implementación-y-cierre)
7. [Apéndices](#apéndices)

## Resumen Ejecutivo

**Descripción breve del proyecto:** 

El proyecto "Sistema de Monitorización de Consumo Eléctrico" tiene como objetivo desarrollar una aplicación de escritorio que permita a los usuarios monitorear y gestionar el consumo eléctrico de su vivienda de manera eficiente.

**Objetivos principales:** 

  - Monitorizar el consumo eléctrico en la vivienda.
  - Mostrar de manera accesible el gasto económico del uso de los dispositivos conectados a la red eléctrica.
  - Proporcionar cálculos diarios, semanales y mensuales de dicho consumo, y mostrarlos gráficamente.
  - Proporcionar información sobre cuáles son los dispositivos gastan más, y cuáles son las franjas horarias recomendadas para cada uno.

**Beneficios obtenidos:** 

- Mejora en la comprensión del consumo eléctrico por parte del usuario.
- Posibilidad de ahorro económico gracias a la optimización del uso de energía.

**Impacto del proyecto:**

  **- Dimensión económica:**

  El proyecto tiene un impacto económico significativo al permitir a los usuarios reducir su factura de consumo eléctrico. Al ofrecer información detallada sobre el uso de energía, los usuarios pueden identificar los dispositivos que consumen más electricidad y ajustar su uso para maximizar el ahorro. Esto no solo ayuda a las familias a gestionar mejor sus finanzas domésticas, sino que también puede tener un efecto positivo en la economía al reducir la demanda de energía.

  **- Dimensión social:**
     
  Desde una perspectiva social, el proyecto educa a los usuarios sobre la importancia de un consumo eléctrico responsable. Al proporcionar datos claros y recomendaciones sobre las mejores franjas horarias para utilizar ciertos dispositivos, el sistema fomenta hábitos de consumo más eficientes. Este tipo de educación puede tener un efecto multiplicador, ya que los usuarios pueden compartir sus conocimientos y prácticas con otros, amplificando el impacto positivo en la comunidad.

  **- Dimensión ambiental:**

  El impacto ambiental del proyecto es notable. Al ayudar a los usuarios a optimizar su consumo de energía, se contribuye a la reducción de la huella de carbono. Un menor consumo de energía en los hogares implica una menor demanda de electricidad, lo que puede resultar en una reducción de la producción de energía en plantas generadoras que utilizan combustibles fósiles. Esto, a su vez, disminuye las emisiones de gases de efecto invernadero y otros contaminantes. Además, el proyecto puede promover el uso de fuentes de energía más sostenibles y la adopción de tecnologías más eficientes, contribuyendo a un futuro más verde y sostenible.

  **- Futuro emprendimiento:**
    
  El proyecto tiene un potencial considerable para convertirse en un emprendimiento comercial viable. La combinación de la aplicación de monitorización con sensores específicos para medir el consumo eléctrico abre oportunidades para la comercialización del sistema completo. Además, la creciente conciencia sobre la sostenibilidad y el ahorro energético puede aumentar la demanda de este tipo de soluciones, permitiendo a la empresa expandir sus operaciones y posiblemente diversificar sus productos y servicios en el futuro.

**Resumen del cronograma y presupuesto:** 
El proyecto se llevó a cabo en los meses de abril y mayo de 2024. No se realizaron gastos directos de recursos, puesto que ha sido desarrollado por alumnado del ciclo de DAM en los módulos de Programación y Entornos de Desarrollo.

## Descripción del Proyecto

### Antecedentes
**Contexto y justificación del proyecto:** 
El aumento de los costos de la electricidad, la creciente preocupación por el impacto ambiental del consumo de energía y la necesidad de optimizar el uso de recursos en el hogar, fueron el princial motor para la realización de este proyecto. Las viviendas modernas están equipadas con una variedad de dispositivos electrónicos y electrodomésticos que, si bien aportan comodidad y eficiencia, también contribuyen significativamente al consumo energético total. En este contexto, la monitorización eléctrica se presenta como una herramienta esencial para gestionar de manera eficiente el uso de la electricidad.


### Objetivos

- **Objetivos generales:** 

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
**Definición del alcance del proyecto:** 
El proyecto de monitorización eléctrica en la vivienda implementó un sistema que permite registrar, analizar y optimizar el consumo energético. Sin embargo, no fue posible la instalación de dispositivos de monitorización, por lo que los datos de consumo eléctrico y precio de la electricidad fueron implementados mediante la lectura y análisis de archivos JSON, generados mediante IA, y basados en datos reales obtenidos mediante una API pública que registra y muestra el precio de la luz en España en tiempo real.

### Entregables
**Productos, servicios o resultados entregados:** 
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

### Desglose Jerárquico
**Desglose del trabajo en tareas y sub-tareas:**

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

### Descripción de Tareas
**Descripción detallada de cada tarea:**

1. Identificación y planificación de la estructura del proyecto: Briceida, Nicklas, Jaime y Ángela.
2. Planificación y desarrollo de la Base de Datos del proyecto: Briceida, Nicklas, Jaime y Ángela.
3. Pruebas e implementación final de la BDD del proyecto: Briceida, Nicklas, Jaime y Ángela.
4. Implementación de la conexión entre la aplicación y la BDD mediante el protocolo JDBC: Briceida, Nicklas, Jaime y Ángela.
5. Primer contacto con interfaz gráfica mediante Swing, y creación de las primeras funciones: Briceida, Nicklas, Jaime y Ángela.
6. Realización de las funciones DAO necesarias: Briceida, Nicklas, Jaime y Ángela.
7. Lectura de archivos JSON y creación de funciones para tratar sus datos: Briceida, Nicklas, Jaime y Ángela.
8. Realización de funciones de cálculo finales y representación mediante gráficas: Briceida, Nicklas, Jaime y Ángela.
 

## Cronograma del Proyecto

### Diagrama de Gantt
**Representación gráfica del cronograma:** 

![Diagrama de Gantt](/monitorizacion_electrica/docs/gestion_proyecto/diagramaDeGantt.png)


## Organización del Proyecto

### Equipo del Proyecto
**Miembros del equipo y sus roles y responsabilidades:**

- **Jaime:** Líder de proyecto y desarrollador.
- **Briceida:** Desarrolladora.
- **Nicklas:** Desarrollador.
- **Ángela:** Desarrolladora.

### Recursos
**Recursos humanos, materiales y tecnológicos utilizados:**

- **Humanos:** 4 desarrolladores.
- **Materiales:** Computadoras, software de diseño UML.
- **Tecnológicos:** Herramientas de desarrollo (IDE, sistemas de gestión de bases de datos).

## Plan de Implementación y Cierre

### Implementación
**Descripción de cómo se implementó el proyecto:** 
El proyecto se implementó siguiendo una metodología ágil, con sprints semanales y reuniones de seguimiento. El sistema se instaló en los dispositivos de los usuarios y se capacitó a los mismos en su uso.

### Cierre
**Proceso de cierre del proyecto:** 
El cierre del proyecto incluyó la revisión final del sistema, la corrección de errores detectados durante las pruebas y la entrega de toda la documentación requerida. Se realizó una evaluación del proyecto con el equipo y se obtuvieron retroalimentaciones para futuros proyectos.

## Apéndices

### Documentación Adicional
**Documentos adicionales relevantes:**

- Diagramas UML:
    - [Diagrama de Base de Datos](/monitorizacion_electrica/docs/diagramas/base_de_datos/DiagramaEntidadRelacion.puml)
    - [Diagrama de Casos de Uso](/monitorizacion_electrica/docs/diagramas/casos_de_uso/DiagramaCasos.puml)
    - [Diagrama de Clases y Paquetes A](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClaseDTO.puml)
    - [Diagrama de Clases y Paquetes B](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClasesDAO.puml)
    - [Diagrama de Clases y Paquetes C](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClasesNegocio.puml)
    - [Diagrama de Clases y Paquetes D](/monitorizacion_electrica/docs/diagramas/clases_paquetes/diagramaPaquetesyClasesUI.puml)
    - [Diagrama de Secuencia: Calculo por Dia](/monitorizacion_electrica/docs/diagramas/secuencia/diagramaSecuenciaCalculoPorDia.puml)
    - [Diagrama de Secuencia: Insertar Dispositivo desde JSON](/monitorizacion_electrica/docs/diagramas/secuencia/diagramaSecuenciaInsertarDispositivosDesdeJson.puml)
    
---

**Nota:** Este informe debe ser detallado y reflejar fielmente cómo se llevó a cabo cada aspecto del plan de proyecto. Se espera que se incluyan evidencias de los trabajos realizados, como diagramas, capturas de pantalla, y cualquier otro documento relevante que respalde la ejecución del proyecto.
 
