package com.iesvdc.acceso.simplecrud.dao;

import java.util.List;

import com.iesvdc.acceso.simplecrud.model.Libro;

/**
 * LibroDao
 */
public interface LibroDao {
    public boolean create(Libro libro);
    public Libro findById(Integer id);
    public List<Libro> findAll();
    public List<Libro> findByTitle(String title);
    public boolean update(Libro oldLibro, Libro newLibro);
    public boolean update(Integer oldLibro, Libro newLibro);
    public boolean delete(Libro libro);
    public boolean delete(Integer libro);
    
}