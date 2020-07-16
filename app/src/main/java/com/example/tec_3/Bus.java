package com.example.tec_3;
//AUTOR : CHURA PABEL JOEL,CCUNO CARLOS PAUL ARNALDO, LIPA OCHOA JOSE,  //

public class Bus {
    String matricula;
    Ruta ruta;
    String imagen;
    String Empresa;

    public Bus(String matricula, Ruta ruta, String imagen, String empresa) {
        this.matricula = matricula;
        this.ruta = ruta;
        this.imagen = imagen;
        Empresa = empresa;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }
}
