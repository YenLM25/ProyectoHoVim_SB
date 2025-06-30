1.Hacer pull en la rama master primero
2. Correr el programa
3. Descargar el frontend completo
4. Abrir index.html
5. Asegurarse de que el backend corra en http://localhost:8080
6. Activar Live Server si se usa y asegurar que corra en el puerto 5500



# HoVim – Historia de Visitas Médicas

Aplicación web para la gestión de usuarios, pacientes, áreas, visitas médicas y horarios dentro de un centro hospitalario. Desarrollado como proyecto académico con tecnologías web modernas y conexión a base de datos en la nube.

---

##  Tecnologías utilizadas

- **Frontend:** HTML, CSS, Bootstrap, JavaScript (ES6)
- **Backend:** Java con Spring Boot
- **Base de datos:** Neon Serverless PostgreSQL
- **Comunicación:** API REST utilizando `fetch()`

---

## Funcionalidades principales

El sistema permite gestionar de forma centralizada:

-  **Usuarios:** Registro, edición y eliminación de usuarios.
- **Pacientes:** Administración de pacientes hospitalizados.
-  **Áreas:** Gestión de áreas médicas (Pediatría, Emergencias, etc.).
-  **Visitas a pacientes:** Registro de visitas con estado y fecha.
- **Horarios:** Visualización de los horarios de visita por área con requisitos.

---

##  Estilo visual

- Paleta institucional basada en azul, rojo acento y fondo neutro.
- Diseño responsive, limpio y legible.
- Variables CSS globales para consistencia visual.
- Componentes reutilizables: tarjetas, formularios, tablas, badges.

---

## Estructura del frontend

- `index.html`: Página de inicio con navegación a todos los módulos.
- Módulos independientes:
  - `user.html` → Gestión de usuarios
  - `patient.html` → Pacientes
  - `area.html` → Áreas médicas
  - `visit.html` → Visitas a pacientes
  - `schedule.html` → Horarios
- Cada módulo incluye listado y formulario correspondiente.

---

## Conexión con el backend

- Comunicación mediante `fetch()` hacia `/api/hoVim/...`
- Backend desarrollado con Spring Boot conectado a Neon DB
- Conversión de fechas entre `yyyy-MM-dd` ↔ `dd/MM/yyyy` en el cliente
- Pruebas funcionales desde navegador y Postman.

  Uso de Inteligencia Artificial – Proyecto HoVim (Frontend)
Durante el desarrollo del frontend de HoVim, se utilizó IA como apoyo puntual para lo siguiente:
•	Diseño visual y CSS:
o	Sugerencias para estructurar tarjetas, formularios, y estilos limpios y consistentes.
o	Creación de la imagen usada con la paleta de colores utilizada en el proyecto.
Prompt: "Una ilustración que represente al personal médico con símbolos de salud. Incluye tres profesionales: dos con batas blancas (uno con estetoscopio y otro con portapapeles) y uno con uniforme de scrubs azul. En el fondo, aparecen íconos relacionados con la medicina: caduceo, corazón con línea de pulso, una pastilla y un frasco de medicamento con cruz. El estilo debe ser colorido, moderno, con tonos vibrantes como rojo, naranja, púrpura y azul. Composición amigable y profesional." (Copilot)
 Uso de herramientas externas:
o	Explicación de para qué sirve Bootstrap y cómo aplicar clases como: container, row, col-md-6, etc.
o	Guía para integrar y utilizar Font Awesome, recomendado uso como librería y ejemplos prácticos para icono
 JavaScript y conexión API:
o	Asistencia para escribir métodos fetch (), manipular el DOM, capturar eventos (addEventListener) y trabajar con fechas.
o	Apoyo para manejar formularios y cargar dinámicamente elementos como listas de selección (<select>).
 CORS (Cross-Origin Resource Sharing):
o	Asistencia para conectar el Frontend con el Backend
o	Explicación de por qué ocurría el error y cómo solucionarlo en el backend con @CrossOrigin.
También se utilizó páginas como:
W3Schools, para consulta de sintaxis, ejemplos de HTML, CSS, JavaScript, y estructura de formularios accesibles y componentes responsivos.


> Proyecto desarrollado con fines educativos – 2025 
