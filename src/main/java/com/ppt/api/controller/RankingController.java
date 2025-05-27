package com.ppt.api.controller;

import com.ppt.api.model.Jugador;
import com.ppt.api.model.Ronda;
import com.ppt.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Jugador> obtenerRanking() {
        return gameService.obtenerRanking();
    }

    @GetMapping("/historial/{nombre}")
    public List<Ronda> obtenerHistorial(@PathVariable String nombre) {
        return gameService.obtenerHistorial(nombre);
    }
}
