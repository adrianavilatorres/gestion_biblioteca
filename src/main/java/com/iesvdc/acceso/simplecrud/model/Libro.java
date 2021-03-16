package com.iesvdc.acceso.simplecrud.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Libro
 */
public class Libro {

    int id;
    String editorial;
    String titulo;
    String anno_publicacion;
    String isbn;

    public Libro(final int id, final String editorial, final String titulo, final String anno_publicacion, final String isbn) {
        this.id = id;
        this.editorial = editorial;
        this.titulo = titulo;
        this.anno_publicacion = anno_publicacion;
        this.isbn = isbn;
    }

    

    public Libro() {
	}




	public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(final String editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getAnno_publicacion() {
        return anno_publicacion;
    }
   

    public void setAnno_publicacion(final String anno_publicacion) {
        this.anno_publicacion = anno_publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro [anno_publicacion=" + anno_publicacion + ", editorial=" + editorial + ", id=" + id + ", isbn="
                + isbn + ", titulo=" + titulo + "]";
    }

    
    

    
}