# ✈️ Flight Filter App — Java Console Application

Prueba-Tecnica__Curso-2

📌 Descripción del Proyecto

Este proyecto es una aplicación de consola en Java que permite filtrar una lista de vuelos según diferentes combinaciones de fechas.
El usuario puede seleccionar el tipo de filtro mediante un menú interactivo y visualizar los resultados ordenados por fecha de salida.


---


📂 Estructura del Proyecto

src/
├── entities/
│ └── Vuelo.java
├── utils/
│ └── FiltroVuelos.java
└── Main.java
- entities/ → Contiene la clase Vuelo.
- utils/ → Contiene la clase FiltroVuelos con la lógica principal de filtrado.
- Main.java → Ejecuta la aplicación, define las fechas de prueba, crea la lista de vuelos y muestra el menú interactivo.


---


🚀 Características del Programa
| Funcionalidad                 | Descripción                                        |
| ----------------------------- | -------------------------------------------------- |
| 🔍 Filtrar por rango completo | fechaInicio + fechaFin                             |
| ◀️ Filtrar hasta una fecha    | fechaFin sin fechaInicio                           |
| ▶️ Filtrar desde una fecha    | fechaInicio sin fechaFin                           |
| 📂 Mostrar todos los vuelos   | Sin filtros                                        |
| 📅 Orden automático           | Resultados siempre ordenados por fechaSalida       |
| 🛡 Entrada segura             | Validación para evitar fallos al ingresar opciones |

El sistema funciona incluso si el usuario escribe letras, símbolos o números inválidos.


---


🛫 Clase: Vuelo

Representa un vuelo con toda la información relevante:
id
nombreVuelo
empresa
lugarSalida
lugarLlegada
fechaSalida
fechaLlegada
Incluye un constructor, getters necesarios para el filtrado y un toString() con formato bonito para consola.


---


🖥️ Menú Principal

El usuario puede seleccionar entre los filtros disponibles:

===== MENÚ DE FILTROS =====
1. Filtro completo (fechaInicio y fechaFin)
2. Filtro hasta fechaFin (sin fechaInicio)
3. Filtro desde fechaInicio (sin fechaFin)
4. Sin filtros (todas las fechas)
5. Mostrar todos los vuelos disponibles
0. Salir
El sistema valida que el usuario ingrese un número correcto usando scanner.hasNextInt().


---


🔧 Lógica del Filtro (FiltroVuelos)

El comportamiento depende de qué fechas se envíen:

- Solo fechaFin → devuelve vuelos con fechaSalida ≤ fechaFin
- Solo fechaInicio → devuelve vuelos con fechaSalida ≥ fechaInicio
- Ambas fechas → vuelos dentro del rango
- Ambas null → devuelve todos
- Siempre ordenado por fechaSalida


---


📜 Ejemplo de Ejecución

======= RESULTADO =======
✈️ Vuelo #7
────────────────────────────
🆔 Código: AZ321
🏢 Empresa: ITA Airways
🌍 Origen: Roma
🎯 Destino: Atenas
📅 Fecha salida: 2025-11-30
📅 Fecha llegada: 2025-11-30

Si no hay resultados:

⚠️ No hay vuelos para los criterios seleccionados.


---


🧩 Requisitos para Ejecutar

- Java 17 o superior
- Consola o terminal compatible
- Compilar los archivos .java antes de ejecutar
