package com.example.tec_3;
//AUTOR : CHURA PABEL JOEL,CCUNO CARLOS PAUL ARNALDO, LIPA OCHOA JOSE,  //

import java.util.List;

public class Ruta {
    String id;
    Destino destino;
    Origen origen;
    List<Puntos> Puntos;

    public Ruta(String id, Destino destino, Origen origen, List<com.example.tec_3.Puntos> puntos) {
        this.id = id;
        this.destino = destino;
        this.origen = origen;
        Puntos = puntos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public List<com.example.tec_3.Puntos> getPuntos() {
        return Puntos;
    }

    public void setPuntos(List<com.example.tec_3.Puntos> puntos) {
        Puntos = puntos;
    }
}
