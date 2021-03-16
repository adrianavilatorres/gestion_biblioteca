package com.iesvdc.acceso.simplecrud.dao;

import java.util.List;

import com.iesvdc.acceso.simplecrud.model.Resenna;


/**
 * LibroDao
 */
public interface ResennaDao {
    public boolean create(Resenna libro);
    public Resenna findById(Integer id);
    public List<Resenna> findAll();
    public List<Resenna> findByTitle(String title);
    public boolean update(Resenna oldLibro, Resenna newLibro);
    public boolean update(Integer oldLibro, Resenna newLibro);
    public boolean delete(Resenna libro);
    public boolean delete(Integer libro);
    
}