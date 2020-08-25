<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
  font-family: arial;
  background-image: url('images/bg.png');
}
.cabecera{
border: 1px solid #017bab;
  margin-bottom: 15px;
  padding: 11px 10px;
  background: #252323;
  font-size: 14px;
  font-weight: bold;
  color: white;
}
.filas{
background: #4e4d4d;
  margin: auto;
  margin-top: 180px;
  box-shadow: 7px 13px 37px #000;
  padding: 20px 30px;
  border-top: 4px solid #017bab;
  color: white;
}
table{
float:left;
}
#contenedorbtn{
margin-left: 600px;
  height: 40px;
  background: #017bab;
  border: none;
  color: white;
  margin-bottom: 16px;

}
.filas a {
  color: white;
  text-decoration: none;
  font-size: 14px;
}
.buttons {
  
  height: 40px;
  background: #017bab;
  border: none;
  color: white;
  margin-bottom: 16px;
}
</style>
</head>

<body>
<table>
<tr>
<th Class="cabecera">Id articulo</th>
<th Class="cabecera">Descripcion</th>
<th Class="cabecera">Precio</th>
<th Class="cabecera">Duracion</th>
<th Class="cabecera">Accion</th>

</tr>
<c:forEach var="temProd" items="${ProductosEstetica}">


<!-- Link para cada Producto -->
<c:url var="linkTemp" value="Controlador_E_P" >
<c:param name="instruccion" value="cargar"></c:param>
<c:param name="idarticulo" value="${temProd.id}"></c:param>
</c:url>

<c:url var="linkTempEliminar" value="Controlador_E_P" >
<c:param name="instruccion" value="eliminar"></c:param>
<c:param name="idarticulo" value="${temProd.id}"></c:param>
</c:url>

<tr>

<td Class="filas">${temProd.id }</td>
<td Class="filas">${temProd.producto}</td>
<td Class="filas">${temProd.precio}</td>
<td Class="filas">${temProd.tiempo}</td>
<td Class="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>
</tr>


</c:forEach>
</table>
<div id="contenedorbtn">
<!-- Link para abiri la ventana inserta producto-->
<input type="button" value="Insertar Registro" Class="buttons" onclick="window.location.href='inserta_producto.jsp'">
</div>
</body>
</html>