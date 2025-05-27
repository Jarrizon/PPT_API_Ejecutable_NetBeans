package com.ppt.api.service;

import com.ppt.api.model.*;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final Map<String, Jugador> jugadores = new HashMap<>();

    public Jugador crearJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.put(nombre, jugador);
        return jugador;
    }

    public Jugador obtenerJugador(String nombre) {
        return jugadores.get(nombre);
    }

    public boolean eliminarJugador(String nombre) {
        return jugadores.remove(nombre) != null;
    }

    public List<Jugador> obtenerRanking() {
        List<Jugador> ranking = new ArrayList<>(jugadores.values());
        ranking.sort(Comparator.comparingInt(Jugador::getPuntaje).reversed());
        return ranking;
    }

    public List<Ronda> obtenerHistorial(String nombre) {
        Jugador jugador = jugadores.get(nombre);
        if (jugador != null) {
            return jugador.getHistorial();
        }
        return Collections.emptyList();
    }

    public Ronda jugarContraPC(String nombreJugador, Movimiento movimientoJugador) {
        Movimiento movimientoPC = Movimiento.values()[new Random().nextInt(3)];
        Resultado resultado = movimientoJugador.jugarContra(movimientoPC);

        Jugador jugador = jugadores.get(nombreJugador);
        if (jugador == null) return null;

        if (resultado == Resultado.GANA) {
            jugador.aumentarPuntaje();
        }

        Ronda ronda = new Ronda(nombreJugador, movimientoJugador, "PC", movimientoPC, resultado);
        jugador.agregarRonda(ronda);
        return ronda;
    }

    public Ronda jugarContraJugador(String jugador1, Movimiento mov1, String jugador2, Movimiento mov2) {
        Resultado resultado = mov1.jugarContra(mov2);

        Jugador j1 = jugadores.get(jugador1);
        Jugador j2 = jugadores.get(jugador2);
        if (j1 == null || j2 == null) return null;

        if (resultado == Resultado.GANA) {
            j1.aumentarPuntaje();
        } else if (resultado == Resultado.PIERDE) {
            j2.aumentarPuntaje();
        }

        Ronda ronda = new Ronda(jugador1, mov1, jugador2, mov2, resultado);
        j1.agregarRonda(ronda);
        j2.agregarRonda(ronda);
        return ronda;
    }
}
