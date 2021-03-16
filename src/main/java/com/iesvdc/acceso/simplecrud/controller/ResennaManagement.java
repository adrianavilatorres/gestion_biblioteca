package com.iesvdc.acceso.simplecrud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iesvdc.acceso.simplecrud.model.Libro;
import com.iesvdc.acceso.simplecrud.model.Resenna;
import com.iesvdc.acceso.simplecrud.model.Usuario;
import com.iesvdc.acceso.simplecrud.conexion.*;

public class ResennaManagement extends HttpServlet {

    // private static final String JDBC_MYSQL_GESTION_RESERVAS =
    // "jdbc:mysql://192.168.99.101:33306/gestion_reservas";
    // private static final String JDBC_MYSQL_GESTION_RESERVAS = "jdbc:mysql://localhost:33306/gestion_reservas";

    private Conexion conn;
    private Connection conexion;

    @Override
    public void init() {
        this.conn = new Conexion();
        this.conexion = conn.getConnection();
    }

    // findOne(id)
    @Override
    protected void doGet(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonObject = "{}";
        // buscamos en la base de datos el objeto y devolvemos sus datos

        String id = req.getRequestURI().substring(req.getContextPath().length());
        id = id.replace("/resenna/", "");
        jsonObject = "{salida: '" + id + "'}";

        // String id = req.getParameter("userid");

        
        try {
        
            String sql = "SELECT * FROM reseñas WHERE id=?";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String estrellas = rs.getString("estrellas");
                String comentario = rs.getString("comentario");
                String usuario_id = rs.getString("usuario_id");
                String userTyfechape = rs.getString("fecha");
                String libro_id = rs.getString("libro_id");
                jsonObject = "{" + "\n" + "'id':'" + id + "'," + "\n" + "'estrellas':'" + estrellas + "',"
                 + "\n"+ "'comentario':'" + comentario + "'," + "\n"+ "'usuario_id':'" + usuario_id + "',"
                 + "\n"+ "'fecha':'" + userTyfechape + "'," + "\n"+ "'libro_id':'" + libro_id + "'"
                 + "\n" + "}";

                 System.out.println("{" + "\n" + "'id':'" + id + "'," + "\n" + "'estrellas':'" + estrellas + "',"
                 + "\n"+ "'comentario':'" + comentario + "'," + "\n"+ "'usuario_id':'" + usuario_id + "',"
                 + "\n"+ "'fecha':'" + userTyfechape + "'," + "\n"+ "'libro_id':'" + libro_id + "'"
                 + "\n" + "}");

            }
        } catch (Exception ex) {
            resp.sendRedirect("/error.jsp");
        }
        out.print(jsonObject.replaceAll("'", "\""));
        out.flush();
    }

    // CREAR
    @Override
    protected void doPost(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {

        String estrellas = req.getParameter("estrellas");
        String comentario = req.getParameter("comentario");
        String usuario_id = req.getParameter("usuario_id");
        String fecha = req.getParameter("fecha");
        String libro_id = req.getParameter("libro_id");
        

        try {
            String sql = "INSERT INTO reseñas (estrellas,comentario,usuario_id,fecha,libro_id) VALUES(?,?,?,?,?)";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setString(1, estrellas);
            pstm.setString(2, comentario);
            pstm.setString(3, usuario_id);
            pstm.setString(4, fecha);
            pstm.setString(5, libro_id);

            if (pstm.executeUpdate() == 1) {
                resp.sendRedirect("/privado/resennaRead.jsp");
            } else {
                resp.sendRedirect("error.jsp");
            }

        } catch (Exception ex) {
            resp.sendRedirect("error.jsp");
            
        }

        // resp.sendRedirect("/privado/userRead.jsp");

    }

    // BORRAR
    @Override
    protected void doDelete(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonObject = "{}";
        // buscamos en la base de datos el objeto y devolvemos sus datos

        String id = req.getRequestURI().substring(req.getContextPath().length());
        id = id.replace("/resenna/", "");
        jsonObject = "{'error': '" + id + "'}";

        // String id = req.getParameter("userid");

        PreparedStatement pstm;

        try {
            String sql = "DELETE FROM reseñas WHERE id=?";

            pstm = conexion.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            if (pstm.executeUpdate() == 0) {

                jsonObject = "{ " + "'id':'" + id + "'}";

            }
        } catch (Exception ex) {
            resp.sendRedirect("error.jsp");
        }
        out.print(jsonObject.replaceAll("'", "\""));
        out.flush();
    }

    // ACTUALIZAR
    @Override
    protected void doPut(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {

        Resenna resenna = new Gson().fromJson(req.getReader(), Resenna.class);

        try {
            String sql = "UPDATE reseñas SET estrellas=?, comentario=?, usuario_id=?, fecha=?,libro_id=? WHERE id=?";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setInt(1, resenna.getEstrellas());
            pstm.setString(2, resenna.getComentario());
            pstm.setInt(3, resenna.getUsuario_id());
            pstm.setString(4, resenna.getFecha());
            pstm.setInt(5, resenna.getLibro_id());
            pstm.setInt(6, resenna.getId());

            if (pstm.executeUpdate() > 0) {
                // resp.getWriter().println("Usuario insertado");
            } else {
                resp.getWriter().println("No se ha podido insertar");
            }
        } catch (Exception ex) {
            resp.sendRedirect("error.jsp");
            //resp.getWriter().println(ex.getMessage());
            //resp.getWriter().println(ex.getLocalizedMessage());
            // resp.getWriter().println("Imposible conectar a la BBDD");
        }

        resp.sendRedirect(".");

    }

    public void destroy() {

        if (conexion != null)
            try {
                conexion.close();
            } catch (SQLException e) {
                
            }
    }
}