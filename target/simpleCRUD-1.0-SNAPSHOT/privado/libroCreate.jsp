<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    <div class="card">
        <form class="form" action="/libro" method="POST">
            <input name="editorial" type="text" placeholder="editorial" />
            <input name="titulo" type="text" placeholder="titulo" />
            <input name="anno_publicacion" type="text" placeholder="año publicacion" />
            <input name="isbn" type="text" placeholder="isbn" />
            <button type="submit">Enviar</button>
        </form>
    </div>
<%@ include file="../footer.jsp"%> 
