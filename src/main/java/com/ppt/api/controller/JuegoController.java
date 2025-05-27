package com.ppt.api.controller;

import com.ppt.api.model.Movimiento;
import com.ppt.api.model.Ronda;
import com.ppt.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jugar")
public class JuegoController {

    @Autowired
    private GameService gameService;

    @PostMapping("/contra-pc")
    public Ronda jugarContraPC(@RequestParam String nombre, @RequestParam Movimiento movimiento) {
        return gameService.jugarContraPC(nombre, movimiento);
    }

    @PostMapping("/contra-jugador")
    public Ronda jugarContraJugador(@RequestParam String jugador1, @RequestParam Movimiento mov1,
                                     @RequestParam String jugador2, @RequestParam Movimiento mov2) {
        return gameService.jugarContraJugador(jugador1, mov1, jugador2, mov2);
    }
}
