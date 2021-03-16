package com.iesvdc.acceso.simplecrud.model;

/**
 * Prestamo
 */
public class Resenna {

    int id;
    int estrellas;
    String comentario;
    int usuario_id;
    String fecha;
    int libro_id;

    public Resenna(int id, int estrellas, String comentario, int usuario_id, String fecha, int libro_id) {
        this.id = id;
        this.estrellas = estrellas;
        this.comentario = comentario;
        this.usuario_id = usuario_id;
        this.fecha = fecha;
        this.libro_id = libro_id;
    }

    public Resenna() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(int libro_id) {
        this.libro_id = libro_id;
    }

    @Override
    public String toString() {
        return "Prestamo [comentario=" + comentario + ", estrellas=" + estrellas + ", fecha=" + fecha + ", id=" + id
                + ", libro_id=" + libro_id + ", usuario_id=" + usuario_id + "]";
    }

    


    


}