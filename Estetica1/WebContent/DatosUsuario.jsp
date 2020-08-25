<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.sql.*" %>
<% 
  
  String nombre = request.getParameter("nombre");
   String apellido = request.getParameter("apellido");
   String usuario = request.getParameter("usuario");
   String contraseña = request.getParameter("passw");
   String puesto= request.getParameter("puesto");
  
    
   Class.forName("com.mysql.cj.jdbc.Driver");
   try{
	   Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Estetica","root","pragnananda");
	   Statement miStatement=miConexion.createStatement();
	   String instruccionSql="insert into Usuarios(Nombre,Apellido,usuario,pasww,puesto) values ('"+nombre+"','"+apellido+"','"+usuario+"','"+contraseña+"','"+puesto+"')";
	   miStatement.executeUpdate(instruccionSql );
	   out.print("Registro exitoso");
	   response.sendRedirect("login.html");
	   }catch(Exception e){
	     out.println("ha habido un error");
	     e.printStackTrace();
	   }
   %>
</body>
</html>