# Piedra, Papel o Tijera - API REST en Java Spring Boot

Este es un proyecto desarrollado en Java usando el framework Spring Boot, basado en el juego **Piedra, Papel o Tijera**. Se implementa el patrón de diseño **MVC**, y se expone como una API REST probada mediante Postman. Todo se maneja en memoria (no usa base de datos).

---

## Estructura del Proyecto

- `model` → Clases `Jugador`, `Movimiento`, `Ronda`, `Resultado`
- `service` → Lógica de negocio con `GameService`
- `controller` → 3 controladores REST:
  - `JugadorController.java`
  - `JuegoController.java`
  - `RankingController.java`

---

## Endpoints REST

### Jugadores

- `POST /jugadores?nombre=Juan` → Crear jugador
- `GET /jugadores/{nombre}` → Obtener información del jugador
- `PUT /jugadores/{nombre}` → Reiniciar jugador
- `DELETE /jugadores/{nombre}` → Eliminar jugador

### Juego

- `POST /jugar/contra-pc?nombre=Juan&movimiento=PIEDRA` → Jugar contra la PC
- `POST /jugar/contra-jugador?jugador1=Juan&mov1=PIEDRA&jugador2=Ana&mov2=TIJERA` → Jugar entre jugadores

### Ranking e Historial

- `GET /ranking` → Ranking por puntaje
- `GET /ranking/historial/{nombre}` → Historial de rondas por jugador

---

## Requisitos Técnicos

- Implementación de MVC y API REST con Spring Boot
- Juego funcional desde Postman
- Tres controladores independientes
- Proyecto 100% en memoria
- Código subido a un repositorio público (GitHub)
- Commits visibles de todos los integrantes

---

## Instrucciones para Ejecutar

1. Clona el repositorio en NetBeans o tu editor Java preferido.
2. Asegúrate de tener Java 17+ y Spring Boot configurado.
3. Ejecuta `PiedraPapelTijeraApiApplication.java`.
4. Usa Postman con los endpoints descritos arriba.
5.para ejecutar la interfaz ejecuta juegoGUI1.java

---

## Integrantes del Equipo

- Estudiante José Daniel Medina García [102202413222] : Controlador Jugadores
- Estudiante María Camila González [82202411913] : Controlador Juego
- Estudiante Jarrizon Ramos Guzman [82202412403] : Controlador Ranking





