<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

body {
  font-family: arial;
  background-image: url('images/bg.png');
}
.controls {
 border: 1px solid #017bab;
  margin-bottom: 15px;
  padding: 11px 10px;
  background: #252323;
  font-size: 14px;
  font-weight: bold;
  color:white;
  }
  .form-login {
  width: 350px;
  height: 380px;
  background: #4e4d4d;
  margin: auto;
  margin-top: 180px;
  box-shadow: 7px 13px 37px #000;
  padding: 20px 30px;
  border-top: 4px solid #017bab;
  color: white;
}
.buttons {
  width: 100%;
  height: 40px;
  background: #017bab;
  border: none;
  color: white;
  margin-bottom: 16px;

}
</style>
<body>

	<h1 style="text-align:center">Actualizar Producto </h1>
	
	<form name="form1" method="get" action="Controlador_E_P">
	<section class="form-login">
	<input type="hidden" name="instruccion" value="actualizarBD">
	
	<input type="hidden" name="id" value="${ProductoActualizar.id }">
	
		<table width="50%" border="0">
		<!--  
			<tr>
				<td width="27%">Id</td>
				<td width="73%"><label for="id"></label><input type="text" name="id" id="id"></td>
			</tr>
			<tr>-->
				<td Class="controls">Descripcion</td>
				<td Class="controls"><label for="descripcion"></label>
				<input type="text" name="descripcion" Class="controls" id="descripcion" value="${ProductoActualizar.producto }"></td>
			</tr>
			<tr>
				<td Class="controls">Precio</td>
				<td Class="controls"><label for="precio"></label>
				<input type="text" name="precio" Class="controls" id="precio" value="${ProductoActualizar.precio}"></td>
			</tr>
			<tr>
				<td Class="controls">Duracion</td>
				<td Class="controls"><label for="tiempo"></label>
				<input type="text" name="tiempo" Class="controls" id="tiempo" value="${ProductoActualizar.tiempo }"></td>
			</tr>
			<tr>
				<td><input type="submit" name="envio" Class="buttons" id="envio" value="Actualizar"></td>
				<td><input type="button" value="volver" Class="buttons" onclick="window.location.href='Lista_E_Productos'"></td>
			</tr>
		</table>
		</section>
	</form>
</body>
</html>