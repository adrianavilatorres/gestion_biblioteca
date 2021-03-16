<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="prestamoList" dataSource="jdbc/gestionBiblioteca">
    select id, fecha_fin, usuario_id, prorroga, estado, libro_id from prestamos;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <form id="user-form">
            <caption><h2>Seleccione la reserva que desea eliminar</h2></caption>
            <select id="reservaId">
                <c:forEach var="prestamo" items="${prestamoList.rows}">
                    <option value="${prestamo.id}"/> 
                        <c:out value="${prestamo.id}" />
                    </option>
                </c:forEach>
            </select>
        </form>
        <button onclick="enviar()">Enviar</button>
    </div>

    <div id="msg"></div>

<script type="text/javascript">

$("#user-form > option").first().attr("selected", true);
// $("#user-form > option").first().prop("selected", true);

function enviar(){
    var $form = $("#user-form");
    var reservaId = $("#reservaId").val();
    var username = $("#reservaId option:selected").text();
    var url = 'http://localhost:9090/prestamo/'+reservaId;
    //var userName = $form.find('input[name="name"]').val();
    //var userEmail = $form.find('input[name="email"]').val();
    $.ajax({
        type : 'DELETE',
        url : url,
        contentType: 'application/json',
        // data : JSON.stringify({name: userName, email: userEmail}),
        success : function(data, status, xhr){
            // window.location.replace("http://localhost:8080/users/"+userId);
            window.location.replace("prestamoRead.jsp");
        },
        error: function(xhr, status, error){
        $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
        }
    });
};
</script>



<%@ include file="../footer.jsp"%> 
