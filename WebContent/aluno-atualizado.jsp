<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.*, com.accenture.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualiza��o realizada</title>
</head>
<body>
<h3>Atualiza��o de Aluno</h3>
<% String codigo=(String)session.getAttribute("codMatricula"); %>
Atualiza��o do aluno com c�digo de matr�cula= <b><% out.print(codigo); %></b>  realizada com sucesso!<br/>
<a href="finalizar-sessao.jsp">Pagina Inicial</a> 
<a href="selecionar-campo-atualizar-aluno.html">Nova Altera��o</a>    
</body>
</html>