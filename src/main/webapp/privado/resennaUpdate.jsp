<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="resennaList" dataSource="jdbc/gestionBiblioteca">
    select * from reseñas;
</sql:query>


<%@ include file="../header.jsp" %>
<div id="paso1" align="center">
    <div class="form" id="resenna-form">
        <caption><h2>Seleccione la reseña que desea actualizar</h2></caption>
        <select id="resennaId">
            <c:forEach var="resenna" items="${resennaList.rows}">
                <option value="${resenna.id}"/> 
                    <c:out value="${resenna.id}" />
                </option>
            </c:forEach>
        </select>
    </div>
    <button onclick="recargar()">Enviar</button>
</div>

<div id="paso2" align="center">
    <div class="form">
        ID: <input id="resennaid" type="text" disabled /> <br/>
        Estrellas: <input id="estrellas" type="text" placeholder="Estrellas" /> <br/>
        Comentario: <input id="comentario" type="text" placeholder="comentario" /><br/>
        Usuario_id: <input id="usuario_id" type="text" placeholder="usuario_id" disabled /><br/>
        Fecha: <input id="fecha" type="date" placeholder="fecha"disabled /><br/>
        Libro_id: <input id="libro_id" type="text" placeholder="libro_id" disabled/><br/>
        
        <button onclick="enviar()">Enviar</button>
    </div>
</div>


<script type="text/javascript">
    $("#paso2").hide();
    $("#resenna-form > option").first().attr("selected", true);
    // $("#user-form > option").first().prop("selected", true);
    
    function recargar(){
        var $form = $("#resenna-form");
        var resennaId = $("#resennaId").val();
        var url = 'http://localhost:9090/resenna/'+resennaId;
        
        console.log('Intentando borrar usuario: id='+resennaId);
        $.ajax({
            type : 'GET',
            url : url,
            contentType: 'application/json',
            // data : JSON.stringify({name: userName, email: userEmail}),
            success : function(data, status, xhr){
                console.log(data);
                let resenna = data;
                $("#paso1").hide();
                $("#paso2").show();
                $("#estrellas").val(resenna.estrellas);
                $("#comentario").val(resenna.comentario);
                $("#usuario_id").val(resenna.usuario_id);
                $("#fecha").val(resenna.fecha);
                $("#libro_id").val(resenna.libro_id);
                $("#resennaid").val(resenna.id);
                
            },
            error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
            }
        });
        $("#paso1").hide();
        $("#paso2").show();
    };
    
    
    function enviar(){
        var url = 'http://localhost:9090/resenna/'+$("#resennaid").val();
        var datos = {};
        datos.estrellas = $("#estrellas").val();
        datos.comentario = $("#comentario").val();
        datos.usuario_id = $("#usuario_id").val();
        datos.fecha = $("#fecha").val();
        datos.libro_id = $("#libro_id").val();
        datos.id = $("#resennaid").val();
        
    
        $.ajax({
            type : 'PUT',
            complete: function(data, status, xhr){
                console.log("EXITO!!!!!!");
                window.location.replace("resennaRead.jsp");          
            },
            url : url,
            contentType: 'application/json',
            data : JSON.stringify(datos),
            error: function(xhr, status, error){
                $('#msg').html('<span style=\'color:red;\'>'+error+'</span>');
            }
        });
    }
    </script>
        
        

<%@ include file="../footer.jsp"%> 
