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
import com.iesvdc.acceso.simplecrud.conexion.Conexion;
import com.iesvdc.acceso.simplecrud.dao.PrestamosDao;
import com.iesvdc.acceso.simplecrud.daoimpl.PrestamosDaoImpl;
import com.iesvdc.acceso.simplecrud.model.Prestamos;

public class PrestamosManagement extends HttpServlet {
    private Conexion conn;
    private Connection conexion;

    @Override
    public void init() {
        this.conn = new Conexion();
        this.conexion = conn.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        String jsonObject = "{}";
        // buscamos en la base de datos el objeto y devolvemos sus datos

        String id = req.getRequestURI().substring(req.getContextPath().length());
        id = id.replace("/prestamo/", "");
        jsonObject = "{salida: '" + id + "'}";

        // String id = req.getParameter("userid");

        
        try {
        
            String sql = "SELECT * FROM prestamos WHERE id=?";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                String fecha_inicio = rs.getString("fecha_inicio");
                String fecha_fin = rs.getString("fecha_fin");
                String usuario_id = rs.getString("usuario_id");
                String prorroga = rs.getString("prorroga");
                String estado = rs.getString("estado");
                String libro_id = rs.getString("libro_id");

                jsonObject = "{" + "\n" + "'id':'" + id + "'," + "\n" + "'fecha_inicio':'" + fecha_inicio + "'," + "\n"+ "'fecha_fin':'" + fecha_fin + "'," + "\n"+ "'usuario_id':'" + usuario_id + "'," + "\n" +  "'prorroga':'" + prorroga + "'," + "\n" + "'estado':'" + estado + "'," + "\n"+ "'libro_id':'" + libro_id + "'" + "\n" + "}";
                System.out.println("{" + "\n" + "'id':'" + id + "'," + "\n" + "'fecha_inicio':'" + fecha_inicio + "'," + "\n"+ "'fecha_fin':'" + fecha_fin + "'," + "\n"+ "'usuario_id':'" + usuario_id + "'," + "\n" +  "'prorroga':'" + prorroga + "'," + "\n" + "'estado':'" + estado + "'," + "\n"+ "'libro_id':'" + libro_id + "'" + "\n" + "}");
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

        String fecha_inicio = req.getParameter("fecha_inicio");
        String fecha_fin = req.getParameter("fecha_fin");
        String usuario_id = req.getParameter("usuario_id");
        String prorroga = req.getParameter("prorroga");
        String estado = req.getParameter("estado");
        String libro_id = req.getParameter("libro_id");

        

        try {
            String sql = "INSERT INTO prestamos (fecha_inicio,fecha_fin,usuario_id,prorroga,estado,libro_id) VALUES(?,?,?,?,?,?)";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            pstm.setString(1, fecha_inicio);
            pstm.setString(2, fecha_fin);
            pstm.setString(3, usuario_id);
            pstm.setString(4, prorroga);
            pstm.setString(5, estado);
            pstm.setString(6, libro_id);
            //pstm.setString(3, email);

            if (pstm.executeUpdate() == 1) {
                // resp.getWriter().println("Usuario insertado");
                resp.sendRedirect("/privado/prestamoRead.jsp");
            } else {
                // resp.getWriter().println("No se ha podido insertar");
                resp.sendRedirect("error.jsp");
            }

        } catch (Exception ex) {
            resp.sendRedirect("error.jsp");
            // resp.getWriter().println(ex.getMessage());
            // resp.getWriter().println(ex.getLocalizedMessage());
            // resp.getWriter().println("Imposible conectar a la BBDD");
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
        id = id.replace("/prestamo/", "");
        jsonObject = "{'error': '" + id + "'}";

        // String id = req.getParameter("userid");

        PreparedStatement pstm;

        try {
            String sql = "DELETE FROM prestamos WHERE id=?";

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

    @Override
    protected void doPut(HttpServletRequest req, // parámetros de la petición
            HttpServletResponse resp) // respuesta que genero
            throws IOException {
                //System.out.println(req.getReader().readLine());
        Prestamos prestamo = new Gson().fromJson(req.getReader(), Prestamos.class);

        try {
            String sql = "UPDATE prestamos SET fecha_inicio=?, fecha_fin=?, usuario_id=?, prorroga=?, estado=?, libro_id=? WHERE id=?";

            PreparedStatement pstm = conexion.prepareStatement(sql);

            //System.out.println(pstm + "-----------------");
            
            pstm.setString(1, prestamo.getFecha_inicio());
            //System.out.println(prestamo.getFecha_inicio());
            pstm.setString(2, prestamo.getFecha_fin());
            pstm.setInt(3, prestamo.getUsuario_id());
            pstm.setString(4, prestamo.getProrroga());
            pstm.setString(5, prestamo.getEstado());
            pstm.setInt(6, prestamo.getlibro_id());
            pstm.setInt(7, prestamo.getId());

            //System.out.println(pstm + "-----------------" + prestamo.getlibro_id());

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
