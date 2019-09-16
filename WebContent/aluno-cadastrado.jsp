<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,
com.accenture.controller.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Realizado</title>
</head>
<body>
<h3>Cadastro de aluno realizado </h3>
   Aluno(a) <b>${param.nome}</b> cadastrado(a) com sucesso </br>
 Código de Matrícula: <b>${codmatriculanovo}</b>  </br> 
    <a href="index.html">Pagina Inicial</a> </br>
    <a href="cadastrar-aluno.html">Novo Cadastro</a> 
   

</body>
</html>