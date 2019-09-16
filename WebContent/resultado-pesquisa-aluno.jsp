<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*,
com.accenture.model.*" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado da Pesquisa</title>
</head>
<body>
 <h3>Consultar Aluno</h3>
 Notas do(a) Aluno(a): <b>${param.nome}</b><br/>

  <table border ="1">
  <thead>
      <tr>
      <th>Codigo da Matricula</th>
      <th>Nota 1</th>   
      <th>Nota 2</th> 
      <th>Nota 3</th>
      <th>Média Ponderada</th>
      <th>Nota Final</th>
       <th>Situação</th>
      </tr>
   </thead>
   <tbody>
	  <c:forEach var="result" items ="${retornoConsulta}">
  		<td>${result.codMatricula}</td>
  		<td>${result.nota1}</td>
  		<td>${result.nota2}</td>
  		<td>${result.nota3}</td>
  		<td>${result.mediaponderada}</td>	
  		<td>${result.notafinal}</td>
  		<td>
  		<c:choose>
  			<c:when test="${result.mediaponderada < 7  && empty result.nota3}">
  			Em recuperação
  			<a href="atualizar-nota.jsp?=${result.codMatricula}&nome=${param.nome}">Atualizar Nota</a>
  			</c:when>
  			<c:when test="${result.notafinal > 7 }">
  				Aprovado
  			</c:when>
  			<c:when test="${result.notafinal < 7 }">
  			Reprovado
  			</c:when>
  			<c:otherwise>
  			Aprovado
  			</c:otherwise>
  		
  		</c:choose>
  		</td>
  		</c:forEach>
  		</tbody>
  </table>
 
<a href="finalizar-sessao.jsp">Página Inicial</a> 
<a href="consulta-por-aluno.html">Nova Consulta</a> 

</body>
</html>