<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="resennaList" dataSource="jdbc/gestionBiblioteca">
select re.id ,re.estrellas, re.comentario ,u.username, re.fecha, li.titulo   from reseñas re,usuarios u, libros li where re.usuario_id = u.id AND li.id=re.libro_id</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista reseñas</h2>
        <table class="table" >            
            <thead>
            <tr>
                <th>#</th>
                <th>Estrellas</th>
                <th>Comentario</th>
                <th>Usuario</th>
                <th>fecha</th>
                <th>Libro</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="resenna" items="${resennaList.rows}">
                <tr>
                    <td><c:out value="${resenna.id}" /></td>
                    <td><c:out value="${resenna.estrellas}" /></td>
                    <td><c:out value="${resenna.comentario}" /></td>
                    <td><c:out value="${resenna.username}" /></td>
                    <td><c:out value="${resenna.fecha}" /></td>
                    <td><c:out value="${resenna.titulo}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%@ include file="../footer.jsp"%> 
