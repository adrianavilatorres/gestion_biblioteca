<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="resennaList" dataSource="jdbc/gestionBiblioteca">
    select * from reseñas;
</sql:query>


<%@ include file="../header.jsp" %>
    <div align="center">
        <form id="resenna-form">
            <caption><h2>Seleccione la reseña que desea eliminar</h2></caption>
            <select id="resennaId">
                <c:forEach var="resenna" items="${resennaList.rows}">
                    <option value="${resenna.id}" /> 
                        <c:out value="${resenna.id}" />
                    </option>
                </c:forEach>
            </select>
        </form>
        <button onclick="enviar()">Enviar</button>
    </div>

    <div id="msg"></div>

<script type="text/javascript">

$("#resenna-form > option").first().attr("selected", true);
// $("#user-form > option").first().prop("selected", true);

function enviar(){
    var $form = $("#resenna-form");
    var resennaId = $("#resennaId").val();
    var username = $("#resennaId option:selected").text();
    var url = 'http://localhost:9090/resenna/'+resennaId;
    //var userName = $form.find('input[name="name"]').val();
    //var userEmail = $form.find('input[name="email"]').val();
    console.log('Intentando borrar usuario: id='+resennaId+' username='+username);
    $.ajax({
        type : 'DELETE',
        url : url,
        contentType: 'application/json',
        // data : JSON.stringify({name: userName, email: userEmail}),
        success : function(data, status, xhr){
            // window.location.replace("http://localhost:8080/users/"+userId);
            window.location.replace("resennaRead.jsp");
        },
        error: function(xhr, status, error){
        $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
        }
    });
};
</script>



<%@ include file="../footer.jsp"%> 
