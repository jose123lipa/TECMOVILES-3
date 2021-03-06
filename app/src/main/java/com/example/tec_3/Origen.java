package com.example.tec_3;
//AUTOR : CHURA PABEL JOEL,CCUNO CARLOS PAUL ARNALDO, LIPA OCHOA JOSE,  //

public class Origen {
    String id;
    String nombre;
    Double latitud;
    Double longitud;

    public Origen(String id, String nombre, Double latitud, Double longitud) {
        this.id = id;
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
