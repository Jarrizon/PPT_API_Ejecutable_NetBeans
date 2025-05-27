package com.ppt.api.model;

public enum Movimiento {
    PIEDRA, PAPEL, TIJERA;

    public Resultado jugarContra(Movimiento otro) {
        if (this == otro) return Resultado.EMPATE;

        return switch (this) {
            case PIEDRA -> (otro == TIJERA ? Resultado.GANA : Resultado.PIERDE);
            case PAPEL -> (otro == PIEDRA ? Resultado.GANA : Resultado.PIERDE);
            case TIJERA -> (otro == PAPEL ? Resultado.GANA : Resultado.PIERDE);
        };
    }
}
