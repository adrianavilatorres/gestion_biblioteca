package com.iesvdc.acceso.simplecrud.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.dao.LibroDao;
import com.iesvdc.acceso.simplecrud.model.Libro;

/**
 * LibroDaoImpl
 */
public class LibroDaoImpl implements LibroDao {

    @Override
    public boolean create(Libro libro) {
        boolean exito = true;
        try {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO libros (id,editorial,titulo,anno_publicacion,isbn) VALUES (NULL,?,?,?,?)";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setString(1, libro.getEditorial());
            pstmt.setString(2, libro.getTitulo());
            pstmt.setString(3, libro.getAnno_publicacion().toString());
            pstmt.setString(4, libro.getIsbn());
            
            pstmt.executeUpdate();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean delete(Libro libro) {
        return delete(libro.getId());
    }

    @Override
    public boolean delete(Integer libro) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "DELETE FROM libros WHERE id=?");
            ps.setInt(1, libro);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

    @Override
    public List<Libro> findAll() {
        List<Libro> libros = new ArrayList<Libro>();
        Libro libro;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM libros";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                libro = new Libro(
                    rs.getInt("id"), 
                    rs.getString("editorial"),
                    rs.getString("titulo"),
                    rs.getString("anno_publicacion"),
                    rs.getString("isbn")
                    );
                    
                libros.add(libro);
            } 
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
        return libros;
    }

    @Override
    public Libro findById(Integer id) {
        Libro libro;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM libros WHERE id=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                libro = new Libro(
                    rs.getInt("id"), 
                    rs.getString("editorial"),
                    rs.getString("titulo"),
                    rs.getString("anno_publicacion"),
                    rs.getString("isbn")
                    );
            } else {
                libro = new Libro();
            }
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            libro = new Libro(); // si error libro vacío
        }
        return libro;
    }

    @Override
    public List<Libro> findByTitle(String titulo) {
        List<Libro> libros = new ArrayList<Libro>();
        Libro libro;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM libros WHERE titulo=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setString(1, titulo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                libro = new Libro(
                    rs.getInt("id"), 
                    rs.getString("editorial"),
                    rs.getString("titulo"),
                    rs.getString("anno_publicacion"),
                    rs.getString("isbn")
                );
                libros.add(libro);
            } 
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
        return libros;
    }

    @Override
    public boolean update(Libro oldLibro, Libro newLibro) {
        return update(oldLibro.getId(), newLibro);
    }

    @Override
    public boolean update(Integer oldLibro, Libro newLibro) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "UPDATE FROM libros SET id=?, editorial=?, titulo=?, anno_publicacion=?, isbn=? WHERE id=?");
            ps.setInt(1, newLibro.getId());
            ps.setString(2, newLibro.getEditorial());
            ps.setString(3, newLibro.getTitulo());
            ps.setString(4, newLibro.getAnno_publicacion().toString());
            ps.setString(5, newLibro.getIsbn());
            ps.setInt(6, oldLibro);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

    
}