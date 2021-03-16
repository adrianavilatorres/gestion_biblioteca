package com.iesvdc.acceso.simplecrud.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.dao.ResennaDao;
import com.iesvdc.acceso.simplecrud.model.Resenna;

/**
 * ReseñaDaoImpl
 */
public class ResennaDaoImpl implements ResennaDao {

    @Override
    public boolean create(Resenna libro) {
        System.out.println("dentro");
        boolean exito = true;
        try {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO reseñas (id,estrellas,comentario,usuario_id,fecha,libro_id) VALUES (NULL,?,?,?,?,?)";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, libro.getId());
            pstmt.setInt(2, libro.getEstrellas());
            pstmt.setString(3, libro.getComentario());
            pstmt.setInt(4, libro.getUsuario_id());
            pstmt.setString(5, libro.getFecha());
            pstmt.setInt(5, libro.getLibro_id());
            pstmt.executeUpdate();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean delete(Resenna libro) {
        return delete(libro.getId());
    }

    @Override
    public boolean delete(Integer libro) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "DELETE FROM reseñas WHERE id=?");
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
    public List<Resenna> findAll() {
        List<Resenna> resennas = new ArrayList<Resenna>();
        Resenna resenna;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reseñas";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resenna = new Resenna(
                    rs.getInt("id"), 
                    rs.getInt("estrellas"),
                    rs.getString("comentario"),
                    rs.getInt("usuario_id"),
                    rs.getString("fehca"),
                    rs.getInt("libro_id")
                    );
                resennas.add(resenna);
            } 
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
        return resennas;
    }

    @Override
    public Resenna findById(Integer id) {
        Resenna resenna;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reseñas WHERE id=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resenna = new Resenna(
                    rs.getInt("id"), 
                    rs.getInt("estrellas"),
                    rs.getString("comentario"),
                    rs.getInt("usuario_id"),
                    rs.getString("fehca"),
                    rs.getInt("libro_id")
                    );
            } else {
                resenna = new Resenna();
            }
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            resenna = new Resenna(); // si error usuario vacío
        }
        return resenna;
    }

    @Override
    public List<Resenna> findByTitle(String title) {
        List<Resenna> resennas = new ArrayList<Resenna>();
        Resenna resenna;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM reseñas WHERE title=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                resenna = new Resenna(
                    rs.getInt("id"), 
                    rs.getInt("estrellas"),
                    rs.getString("comentario"),
                    rs.getInt("usuario_id"),
                    rs.getString("fehca"),
                    rs.getInt("libro_id")
                    );
                resennas.add(resenna);
            } 
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
        }
        return resennas;
    }

    @Override
    public boolean update(Resenna oldLibro, Resenna newLibro) {
        return update(oldLibro.getId(), newLibro);

    }

    @Override
    public boolean update(Integer oldLibro, Resenna newLibro) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "UPDATE FROM resennas SET id=?, estrellas=?, comentario=?, usuario_id=?, fecha=?, libro_id WHERE id=?");
            ps.setInt(1, newLibro.getId());
            ps.setInt(2, newLibro.getEstrellas());
            ps.setString(3, newLibro.getComentario());
            ps.setInt(4, newLibro.getUsuario_id());
            ps.setString(5, newLibro.getFecha());
            ps.setInt(6, newLibro.getLibro_id());
            ps.setInt(7, oldLibro);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

    
}