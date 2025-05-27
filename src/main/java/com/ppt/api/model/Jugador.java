package com.ppt.api.model;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int puntaje;
    private List<Ronda> historial;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.historial = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void aumentarPuntaje() {
        this.puntaje++;
    }

    public List<Ronda> getHistorial() {
        return historial;
    }

    public void agregarRonda(Ronda ronda) {
        this.historial.add(ronda);
    }
}
