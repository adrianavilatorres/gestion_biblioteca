package com.iesvdc.acceso.simplecrud.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.dao.PrestamosDao;
import com.iesvdc.acceso.simplecrud.model.Prestamos;

public class PrestamosDaoImpl implements PrestamosDao {

    @Override
    public boolean create(Prestamos prestamo) {
        boolean exito = true;
        try{
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO prestamos (id,fecha_inicio,fecha_fin,usuario_id,prorroga,estado,libro_id) VALUES (NULL,?,?,?,?,?,?)";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, prestamo.getId());
            pstmt.setString(2, prestamo.getFecha_inicio());
            pstmt.setString(3, prestamo.getFecha_fin());
            pstmt.setInt(4, prestamo.getUsuario_id());
            pstmt.setString(5, prestamo.getProrroga());
            pstmt.setString(6, prestamo.getEstado());
            pstmt.setInt(7, prestamo.getlibro_id());
            
            pstmt.executeUpdate();
            conexion.destroy();
        }catch(SQLException ex){
            System.out.println("ERROR:  " + ex.getMessage());
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean update(Prestamos oldPrestamo, Prestamos newPrestamo) {
        return update(oldPrestamo.getId(), newPrestamo);
    }

    @Override
    public boolean update(Integer oldPrestamo, Prestamos newPrestamo) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "UPDATE FROM prestamos SET id=?, fecha_inicio=?, fecha_fin=?, usuario_id=?, prorroga=?, estado=?, libro_id=? WHERE id=?");
            ps.setInt(1, newPrestamo.getId());
            ps.setString(2, newPrestamo.getFecha_inicio());
            ps.setString(3, newPrestamo.getFecha_fin());
            ps.setInt(4, newPrestamo.getUsuario_id());
            ps.setString(5, newPrestamo.getProrroga());
            ps.setString(6, newPrestamo.getEstado());
            ps.setInt(7, newPrestamo.getlibro_id());
            ps.setInt(8, oldPrestamo);
            System.out.println(oldPrestamo.toString());
            System.out.println(newPrestamo.toString());
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean delete(Prestamos prestamo) {
        return delete(prestamo.getId());
    }

    @Override
    public boolean delete(Integer prestamo) {
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.getConnection().prepareStatement(
                "DELETE FROM prestamos WHERE id=?");
            ps.setInt(1, prestamo);
            if (ps.executeUpdate() > 0) {
                resultado = true;
            }
        } catch (SQLException se) {
            System.out.println("ERROR:  " + se.getMessage());
        }
        return resultado;
    }

    @Override
    public Prestamos findById(Integer id) {
        Prestamos prestamo;
        try {
            Conexion conexion = new Conexion();
            String sql = "SELECT * FROM prestamos WHERE id=?";
            PreparedStatement pstmt = conexion.getConnection().prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                prestamo = new Prestamos(
                    rs.getInt("id"), 
                    rs.getString("fecha_inicio"),
                    rs.getString("fecha_fin"),
                    rs.getInt("usuario_id"),
                    rs.getString("prorroga"),
                    rs.getString("estado"),
                    rs.getInt("libro_id")
                    );
            } else {
                prestamo = new Prestamos();
            }
            rs.close();
            conexion.destroy();
        } catch (SQLException ex) {
            System.out.println("ERROR:  " + ex.getMessage());
            prestamo = new Prestamos(); // si error usuario vacío
        }
        return prestamo;
    }

   
    
}
