<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="prestamosList" dataSource="jdbc/gestionBiblioteca">
    select * from prestamos;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de reservas</h2>
        <table class="table" >            
            <thead>
            <tr>
                <th>#</th>
                <th>fecha_inicio</th>
                <th>fecha_fin</th>
                <th>usuario_id</th>
                <th>prorroga</th>
                <th>estado</th>
                <th>libro_id</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="prestamos" items="${prestamosList.rows}">
                <tr>
                    <td><c:out value="${prestamos.id}" /></td>
                    <td><c:out value="${prestamos.fecha_inicio}" /></td>
                    <td><c:out value="${prestamos.fecha_fin}" /></td>
                    <td><c:out value="${prestamos.usuario_id}" /></td>
                    <td><c:out value="${prestamos.prorroga}" /></td>
                    <td><c:out value="${prestamos.estado}" /></td>
                    <td><c:out value="${prestamos.libro_id}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%@ include file="../footer.jsp"%> 
