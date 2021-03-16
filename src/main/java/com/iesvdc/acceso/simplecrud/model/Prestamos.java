package com.iesvdc.acceso.simplecrud.model;

public class Prestamos {
    int id;
    String fecha_inicio;
    String fecha_fin;
    int usuario_id;
    String prorroga;
    String estado;
    int libro_id;

    public Prestamos() {
    }

    public Prestamos(int id, String fecha_inicio, String fecha_fin, int usuario_id, String prorroga, String estado,
    int libro_id) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.usuario_id = usuario_id;
        this.prorroga = prorroga;
        this.estado = estado;
        this.libro_id = libro_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getProrroga() {
        return prorroga;
    }

    public void setProrroga(String prorroga) {
        this.prorroga = prorroga;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getlibro_id() {
        return libro_id;
    }

    public void setlibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    @Override
    public String toString() {
        return "Prestamos [estado=" + estado + ", fecha_fin=" + fecha_fin + ", fecha_inicio=" + fecha_inicio + ", id="
                + id + ", libro_id=" + libro_id + ", prorroga=" + prorroga + ", usuario_id=" + usuario_id + "]";
    }

    

   
}
