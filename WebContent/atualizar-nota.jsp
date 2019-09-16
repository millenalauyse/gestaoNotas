<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,
com.accenture.model.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Nota</title>
</head>
<body>
<h3>Atualizacao de Notas</h3>
 <% String codigo=(String)session.getAttribute("codMatricula"); %>
Informe a 3ª nota do(a) Aluno(a) <b>${param.nome}</b></br> 
Código de matrícula: <b> <% out.print(codigo); %></b>


<form action="atualizarNota">

		Nota 3: <input type="text" name="nota3" /><br /> <br />
		  <input type="submit" value="Atualizar" />
		  </form>
</body>
</html>