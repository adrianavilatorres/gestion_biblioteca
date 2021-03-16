package com.iesvdc.acceso.simplecrud.dao;

import com.iesvdc.acceso.simplecrud.model.Prestamos;

public interface PrestamosDao {
    public boolean create(Prestamos prestamo);
    public boolean update(Prestamos oldPrestamo, Prestamos newPrestamo);
    public boolean update(Integer oldPrestamo, Prestamos newPrestamo);
    public boolean delete(Prestamos prestamo);
    public boolean delete(Integer prestamo);
    public Prestamos findById(Integer id);
}
