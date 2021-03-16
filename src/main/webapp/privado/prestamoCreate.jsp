<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    <div class="card">
        <form class="form" action="/prestamo" method="POST">
            <input name="fecha_inicio" type="date" placeholder="fecha de inicio" />
            <input name="fecha_fin" type="date" placeholder="fecha fin" />
            <input name="usuario_id" type="text" placeholder="usuario id" />
            <input name="prorroga" type="date" placeholder="prorroga" />
            <select name="estado" id="estado">
                <option value="bueno">Bueno</option>
                <option value="malo">Malo</option>
                <option value="excelente">Excelente</option>
              </select>
            <input name="libro_id" type="text" placeholder="libro id" />
            <button type="submit">Enviar</button>
        </form>
    </div>
<%@ include file="../footer.jsp"%> 
