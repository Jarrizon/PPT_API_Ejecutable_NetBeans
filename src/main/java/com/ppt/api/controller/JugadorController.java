package com.ppt.api.controller;

import com.ppt.api.model.Jugador;
import com.ppt.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public Jugador crearJugador(@RequestParam String nombre) {
        return gameService.crearJugador(nombre);
    }

    @GetMapping("/{nombre}")
    public Jugador obtenerJugador(@PathVariable String nombre) {
        return gameService.obtenerJugador(nombre);
    }

    @PutMapping("/{nombre}")
    public Jugador reiniciarJugador(@PathVariable String nombre) {
        gameService.eliminarJugador(nombre);
        return gameService.crearJugador(nombre);
    }

    @DeleteMapping("/{nombre}")
    public String eliminarJugador(@PathVariable String nombre) {
        return gameService.eliminarJugador(nombre) ? "Jugador eliminado" : "Jugador no encontrado";
    }
}
