<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="userList" dataSource="jdbc/gestionBiblioteca">
    select * from usuarios;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <h2>Lista de usuarios</h2>
        <table class="table" >            
            <thead>
            <tr>
                <th>#</th>
                <th>username</th>
                <th>password</th>
                <th>type</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${userList.rows}">
                <tr>
                    <td><c:out value="${usuario.id}" /></td>
                    <td><c:out value="${usuario.username}" /></td>
                    <td><c:out value="${usuario.password}" /></td>
                    <td><c:out value="${usuario.userType}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
<%@ include file="../footer.jsp"%> 
