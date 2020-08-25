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


   String usuario = request.getParameter("usuario");
   String passw = request.getParameter("passw");
   
    
   Class.forName("com.mysql.cj.jdbc.Driver");
   try{
   Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/Estetica","root","pragnananda");
   PreparedStatement c_preparada = miConexion.prepareStatement("select * from Usuarios where usuario=? and passw=?",
   ResultSet.TYPE_SCROLL_SENSITIVE, 
   ResultSet.CONCUR_UPDATABLE);
   c_preparada.setString(1, usuario);
   c_preparada.setString(2, passw);
   ResultSet miResultset= c_preparada.executeQuery();
  
  if(miResultset.absolute(1)) {
	  out.println("usuario autorizado");
	  //manda a la pagina seleccionada 
	 //response.sendRedirect("/Controlador_E_P");
  }else  out.println("no hay usuario registrado");
   }catch(Exception e){
     out.println("ha habido un error");
     e.printStackTrace();
   }
%>
</body>
</html>