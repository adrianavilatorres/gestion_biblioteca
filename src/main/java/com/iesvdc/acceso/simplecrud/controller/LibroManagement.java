package com.iesvdc.acceso.simplecrud.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.stream.Collectors;

import javax.json.Json;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.model.Libro;

public class LibroManagement extends HttpServlet {

    // private static final String JDBC_MYSQL_GESTION_RESERVAS =
    // "jdbc:mysql://192.168.99.101:33306/gestion_reservas";
    // private static final String JDBC_MYSQL_GESTION_RESERVAS =
    // "jdbc:mysql://localhost:33306/gestion_reservas";

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
        id = id.replace("/libro/", "");
        jsonObject = "{salida: '" + id + "'}";

        // String id = req.getParameter("userid");

        try {

            String sql = "SELECT * FROM libros WHERE id=?";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String editorial = rs.getString("editorial");
                String titulo = rs.getString("titulo");
                Date anno_publicacion = rs.getDate("anno_publicacion");
                String isbn = rs.getString("isbn");
                jsonObject = "{" + "\n" + "'id':'" + id + "'," + "\n" + "'editorial':'" + editorial + "'," + "\n"
                        + "'titulo':'" + titulo + "'," + "\n" + "'anno_publicacion':'" + anno_publicacion + "'," + "\n"
                        + "'isbn':'" + isbn + "'" + "\n" + "}";

                System.out.println("{" + "\n" + "'id':'" + id + "'," + "\n" + "'editorial':'" + editorial + "'," + "\n"
                        + "'titulo':'" + titulo + "'," + "\n" + "'anno_publicacion':'" + anno_publicacion + "'," + "\n"
                        + "'isbn':'" + isbn + "'" + "\n" + "}");

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

        String editorial = req.getParameter("editorial");
        String titulo = req.getParameter("titulo");
        String anno_publicacion = req.getParameter("anno_publicacion");
        String isbn = req.getParameter("isbn");

        try {
            String sql = "INSERT INTO libros (editorial,titulo,anno_publicacion,isbn) VALUES(?,?,?,?)";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setString(1, editorial);
            pstm.setString(2, titulo);
            pstm.setString(3, anno_publicacion);
            pstm.setString(4, isbn);

            if (pstm.executeUpdate() == 1) {
                resp.sendRedirect("/privado/libroRead.jsp");
            } else {
                resp.sendRedirect("error.jsp");
            }

        } catch (Exception ex) {
            resp.sendRedirect("error.jsp");

        }

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
        id = id.replace("/libro/", "");
        jsonObject = "{'error': '" + id + "'}";

        // String id = req.getParameter("userid");

        PreparedStatement pstm;

        try {
            String sql = "DELETE FROM libros WHERE id=?";

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
        

        Libro libro = new Gson().fromJson(req.getReader(), Libro.class);

            


        try {
            String sql = "UPDATE libros SET editorial=?, titulo=?, anno_publicacion=?, isbn=? WHERE id=?";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            
            pstm.setString(1, libro.getEditorial());
            pstm.setString(2, libro.getTitulo());
            pstm.setString(3, libro.getAnno_publicacion());
            pstm.setString(4, libro.getIsbn());
            pstm.setInt(5, libro.getId());
            

            if (pstm.executeUpdate() > 0) {
            } else {
                resp.getWriter().println("No se ha podido insertar");
            }
        } catch (Exception ex) {
            resp.sendRedirect("error.jsp");
            
        }

        resp.sendRedirect(".er");

    }

    public void destroy() {

        if (conexion != null)
            try {
                conexion.close();
            } catch (SQLException e) {
                
            }
    }
}