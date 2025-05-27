package com.ppt.api.model;

public class Ronda {
    private String jugador1;
    private Movimiento movimiento1;
    private String jugador2;
    private Movimiento movimiento2;
    private Resultado resultado;

    public Ronda(String jugador1, Movimiento movimiento1, String jugador2, Movimiento movimiento2, Resultado resultado) {
        this.jugador1 = jugador1;
        this.movimiento1 = movimiento1;
        this.jugador2 = jugador2;
        this.movimiento2 = movimiento2;
        this.resultado = resultado;
    }

    public String getJugador1() {
        return jugador1;
    }

    public Movimiento getMovimiento1() {
        return movimiento1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public Movimiento getMovimiento2() {
        return movimiento2;
    }

    public Resultado getResultado() {
        return resultado;
    }
}
