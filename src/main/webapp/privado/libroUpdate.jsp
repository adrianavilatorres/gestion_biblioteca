<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<sql:query var="libroList" dataSource="jdbc/gestionBiblioteca">
    select id, editorial, titulo, anno_publicacion, isbn from libros;
</sql:query>


<%@ include file="../header.jsp" %>
<div id="paso1" align="center">
    <div class="form" id="libro-form">
        <caption><h2>Seleccione el libro que desea actualizar</h2></caption>
        <select id="libroId">
            <c:forEach var="libro" items="${libroList.rows}">
                <option value="${libro.id}"/> 
                    <c:out value="${libro.isbn}" />
                    /
                    <c:out value="${libro.titulo}" />
                </option>
            </c:forEach>
        </select>
    </div>
    <button onclick="recargar()">Enviar</button>
</div>

<div id="paso2" align="center">
    <div class="form">
        ID: <input id="libroid" type="text" disabled /> <br/>
        editorial: <input id="editorial" type="text" placeholder="editorial" /> <br/>
        titulo: <input id="titulo" type="text" placeholder="titulo" /><br/>
        año publicacion: <input id="anno_publicacion" type="text" placeholder="año publicacion" /><br/>
        isbn: <input id="isbn" type="text" placeholder="isbn" /><br/>
        <button onclick="enviar()">Enviar</button>
    </div>
</div>


<script type="text/javascript">
    $("#paso2").hide();
    $("#libro-form > option").first().attr("selected", true);
    // $("#user-form > option").first().prop("selected", true);
    
    function recargar(){
        var $form = $("#libro-form");
        var libroId = $("#libroId").val();
        var isbn = $("#libroId option:selected").text();
        var url = 'http://localhost:9090/libro/'+libroId;
        
        console.log('Intentando borrar libro: id='+libroId+' isbn='+isbn);
        $.ajax({
            type : 'GET',
            url : url,
            contentType: 'application/json',
            // data : JSON.stringify({name: userName, email: userEmail}),
            success : function(data, status, xhr){
                console.log(data);
                let libro = data;
                $("#paso1").hide();
                $("#paso2").show();
                $("#titulo").val(libro.titulo);
                $("#editorial").val(libro.editorial);
                $("#anno_publicacion").val(libro.anno_publicacion);
                $("#isbn").val(libro.isbn);
                $("#libroid").val(libro.id);
                
            },
            error: function(xhr, status, error){
            $('#msg').html('<span style=\'color:red;\'>'+error+'</span>')
            }
        });
        $("#paso1").hide();
        $("#paso2").show();
    };
    
    
    function enviar(){
        var url = 'http://localhost:9090/libro/'+$("#libroid").val();
        var datos = {};
        datos.editorial = $("#editorial").val();
        datos.titulo = $("#titulo").val();
        datos.anno_publicacion = $("#anno_publicacion").val();
        datos.isbn = $("#isbn").val();
        datos.id = $("#libroid").val();
        
    console.log(datos.anno_publicacion + "wwe");
    
        $.ajax({
            type : 'PUT',
            complete: function(data, status, xhr){
                console.log("EXITO!!!!!!" + datos.anno_publicacion);
                window.location.replace("libroRead.jsp");          
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
