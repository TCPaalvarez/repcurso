<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es">
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="formato.css" /> 
<script type="text/javascript" src="js/validacion.js" > 
</script> 
</head>
<body>
<form id="formularioInsercion" action="InsertarLibro.do"> 
<fieldset><legend>Formularioaltalibro</legend> 
<p><label for="isbn">ISBN:</label> 
<input type="text" id="isbn" name="isbn" /></p> 
<p><label for="titulo">Titulo:</label> 
<input type="text" id="titulo" name="titulo" /></p> 
<p><label for="categoria">Categoria :</label> 
<select  name="categoria"> 
  <c:forEach var="categoria" items="${listaDeCategorias}"> 
    <option value="${categoria.id}">${categoria.descripcion}</option> 
  </c:forEach> 
</select><br /> 
</p><p><input type="submit" value="Insertar" /></p> 
</fieldset> 
</form> 
</body>
</html>


