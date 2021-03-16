<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    <div class="card">
        <form class="form" action="/user" method="POST">
            <input name="username" type="text" placeholder="Nombre de usuario" />
            <input name="password" type="password" placeholder="Contraseña" />
            <select name="userType" id="userType">
                <option value="alumno">Alumno</option>
                <option value="profesor">Profesor</option>
                <option value="admin">Admin</option>
              </select>
            <button type="submit">Enviar</button>
        </form>
    </div>
<%@ include file="../footer.jsp"%> 
