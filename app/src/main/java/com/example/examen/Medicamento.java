package com.example.examen;

public class Medicamento {

    private String nombre;
    private String precio;
    private String presentacion;
    private String laboratorio;
    private String existencia;
    private int img;

    public Medicamento(){

    }

    public Medicamento(String nombre, String precio, String presentacion, String laboratorio, String existencia) {
        this.nombre = nombre;
        this.precio = precio;
        this.presentacion = presentacion;
        this.laboratorio = laboratorio;
        this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getExistencia() {
        return existencia;
    }

    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
