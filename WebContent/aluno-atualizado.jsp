<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.util.*, com.accenture.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização realizada</title>
</head>
<body>
<h3>Atualização de Aluno</h3>
<% String codigo=(String)session.getAttribute("codMatricula"); %>
Atualização do aluno com código de matrícula= <b><% out.print(codigo); %></b>  realizada com sucesso!<br/>
<a href="finalizar-sessao.jsp">Pagina Inicial</a> 
<a href="selecionar-campo-atualizar-aluno.html">Nova Alteração</a>    
</body>
</html>