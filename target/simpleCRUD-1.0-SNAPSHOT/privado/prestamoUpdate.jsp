<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="prestamoList" dataSource="jdbc/gestionBiblioteca">
    select id, fecha_inicio, fecha_fin, usuario_id, prorroga, estado, libro_id from prestamos;
</sql:query>


<%@ include file="../header.jsp" %>
<div id="paso1" align="center">
    <div class="form" id="prestamo-form">
        <caption><h2>Seleccione el prestamo que desea actualizar</h2></caption>
        <select id="prestamoId">
            <c:forEach var="prestamo" items="${prestamoList.rows}">
                <option value="${prestamo.id}"/> 
                    <c:out value="${prestamo.id}" />
                </option>
            </c:forEach>
        </select>
    </div>
    <button onclick="recargar()">Enviar</button>
</div>

<div id="paso2" align="center">
    <div class="form">
        ID: <input id="prestamoid" type="text" disabled /> <br/>
        Fecha Inicio: <input id="fecha_inicio" type="date" placeholder="Fecha de inicio" disabled/> <br/>
        Fecha Fin: <input id="fecha_fin" type="date" placeholder="Fecha fin" disabled/><br/>
        Usuario ID: <input id="usuario_id" type="text" placeholder="ID del usuario" disabled/><br/>
        Prorroga: <input id="prorroga" type="date" placeholder="Prorroga" /><br/>
        Estado: <input id="estado" type="text" placeholder="Estado" /><br/>
        Libro ID: <input id="libro_id" type="text" placeholder="ID del libro" disabled/><br/>
        <button onclick="enviar()">Enviar</button>
    </div>
</div>


<script type="text/javascript">
    $("#paso2").hide();
    $("#prestamo-form > option").first().attr("selected", true);
    // $("#user-form > option").first().prop("selected", true);
    
    function recargar(){
        var $form = $("#prestamo-form");
        var prestamoId = $("#prestamoId").val();
        var url = 'http://localhost:9090/prestamo/'+prestamoId;
        
        console.log('Intentando borrar presamo: id='+prestamoId);
        $.ajax({
            type : 'GET',
            url : url,
            contentType: 'application/json',
            // data : JSON.stringify({name: userName, email: userEmail}),
            success : function(data, status, xhr){
                let prestamo = data;
                $("#paso1").hide();
                $("#paso2").show();
                $("#prestamoid").val(prestamo.id);
                $("#fecha_inicio").val(prestamo.fecha_inicio);
                $("#fecha_fin").val(prestamo.fecha_fin);
                $("#usuario_id").val(prestamo.usuario_id);
                $("#prorroga").val(prestamo.prorroga);
                $("#estado").val(prestamo.estado);
                $("#libro_id").val(prestamo.libro_id);

            },
            error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
            }
        });
        $("#paso1").hide();
        $("#paso2").show();
    };
    
    
    function enviar(){
        var url = 'http://localhost:9090/prestamo/'+$("#prestamoid").val();
        var datos = {};
        datos.id = $("#prestamoid").val();
        datos.fecha_inicio = $("#fecha_inicio").val();
        datos.fecha_fin = $("#fecha_fin").val();
        datos.usuario_id = $("#usuario_id").val();
        datos.prorroga = $("#prorroga").val();
        datos.estado = $("#estado").val();
        datos.libro_id = $("#libro_id").val();

        alert(datos.libro_id)
        $.ajax({
            type : 'PUT',
            complete: function(data, status, xhr){
                console.log("EXITO!!!!!!" + data);
                window.location.replace("prestamoRead.jsp");          
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
