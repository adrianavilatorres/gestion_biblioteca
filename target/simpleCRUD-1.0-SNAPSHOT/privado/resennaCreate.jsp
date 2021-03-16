<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
    <div class="card">
        <form class="form" action="/resenna" method="POST">
            Estellas <select id="example-1to10" name="estrellas" autocomplete="off">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                
            </select>
            <input name="comentario" type="text" placeholder="comentario" />
            <input name="usuario_id" type="text" placeholder="usuario_id" />
            <input name="fecha" type="date" placeholder="fecha" />
            <input name="libro_id" type="text" placeholder="libro_id" />
            
            <button type="submit">Enviar</button>
        </form>
    </div>
    
<%@ include file="../footer.jsp"%> 
