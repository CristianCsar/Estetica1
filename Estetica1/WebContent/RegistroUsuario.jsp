<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: arial;
  background-image: url('images/bg.png');
}

.form-login {
  width: 550px;
  height: 440px;
  background: #4e4d4d;
  margin: auto;
  margin-top: 180px;
  box-shadow: 7px 13px 37px #000;
  padding: 20px 30px;
  border-top: 4px solid #017bab;
  color: white;
}

.form-login h5 {
  margin: 0;
  text-align: center;
  height: 40px;
  margin-bottom: 30px;
  border-bottom: 1px solid;
  font-size: 20px;
}

.controls {
  width: 100%;
  border: 1px solid #017bab;
  margin-bottom: 15px;
  padding: 11px 10px;
  background: #252323;
  font-size: 14px;
  font-weight: bold;
}

.buttons {
  width: 100%;
  height: 40px;
  background: #017bab;
  border: none;
  color: white;
  margin-bottom: 16px;
}

.form-login p{
  height: 40px;
  text-align: center;
  border-bottom: 1px solid;
}

.form-login a {
  color: white;
  text-decoration: none;
  font-size: 14px;
}

.form-login a:hover {
  text-decoration: underline;
}


</style>
<body>

<h1 style="text-align:center">Registro Usuario Nuevo</h1>
 <form action="DatosUsuario.jsp" method="post">
     <section class="form-login">
      <h5>Registrar</h5>
      <input class="controls" type="text" name="nombre" value="" placeholder="Nombre">
      <input class="controls" type="text" name="apellido" value="" placeholder="Apellido">
      <input class="controls" type="text" name="usuario" value="" placeholder="Usuario">
      <input class="controls" type="text" name="passw" value="" placeholder="Contraseña">
      <input class="controls" type="text" name="puesto" value="" placeholder="Puesto">
      <input class="buttons" type="submit" name="" value="Registrar">
      <p><a href="login.jsp">Volver</a></p>

    </section>
 </form>
</body>
</html>