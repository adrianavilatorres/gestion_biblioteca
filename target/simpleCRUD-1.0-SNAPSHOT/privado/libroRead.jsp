<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="libroList" dataSource="jdbc/gestionBiblioteca">
    select * from libros;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de usuarios</h2>
        <table class="table" >            
            <thead>
            <tr>
                <th>#</th>
                <th>Editorial</th>
                <th>Titulo</th>
                <th>Año de publicacion</th>
                <th>ISBN</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="libro" items="${libroList.rows}">
                <tr>
                    <td><c:out value="${libro.id}" /></td>
                    <td><c:out value="${libro.editorial}" /></td>
                    <td><c:out value="${libro.titulo}" /></td>
                    <td><c:out value="${libro.anno_publicacion}" /></td>
                    <td><c:out value="${libro.isbn}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%@ include file="../footer.jsp"%> 
