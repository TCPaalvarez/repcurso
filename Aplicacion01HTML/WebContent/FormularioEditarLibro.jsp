<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
<%@page import="com.arquitecturajava.Libro"%> 
<%Libro libro= Libro.buscarPorClave(request.getParameter("isbn"));%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/formato.css" /> 
<script type="text/javascript" src="js/validacion.js" > 
</script> 
</head>
<body> 
<form id="formularioEdicion" action="SalvarLibro.do"> 
<fieldset><legend>Formularioaltalibro</legend> 
<p><label for="isbn">ISBN:</label><input type="text" id="isbn" name="isbn" value="${libro.isbn}" /></p> 
<p><label for="titulo">Titulo:</label><input type="text" id="titulo" name="titulo" value="${libro.titulo}" /></p> 
<p><label for="categoria">Categoria :</label><select   name="categoria"> 
  <c:forEach var="categoria" items="${listaDeCategorias}"> 
    <option value="${categoria.id}">${categoria.descripcion}</option> 
  </c:forEach> 
</select><br/> 
</p> 
<p><input type="submit" value="Salvar" /></p> 
</fieldset> 
</form> 
</body> 
</html> 