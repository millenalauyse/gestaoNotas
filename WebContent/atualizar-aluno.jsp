<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Aluno</title>
</head>
<body>
<h3>Atualização de cadastro de Aluno</h3>

<form method="post" action = "atualizarCampoAluno">
<!-- Código da Matrícula: <br/><input type="number" name="codMatricula" /><br /> -->
<c:choose>

	<c:when test= "${param.dado=='nome'}">
	Nome: <br/><input type="text" name="nome" /><br/>
	 <input type="submit" value="Atualizar" />
	</c:when>
	
	<c:when test= "${param.dado=='email'}">
	E-mail: <br/><input type="text" name="email" /><br /> 
	 <input type="submit" value="Atualizar" />
	</c:when>
	
	<c:when test= "${param.dado=='curso'}">
	Curso: <br/><input type="text" name="curso" /><br />
	 <input type="submit" value="Atualizar" />
	</c:when>
	
	<c:when test= "${param.dado=='todos'}">
	Nome: <br/><input type="text" name="nome" /><br/>
	E-mail: <br/><input type="text" name="email" /><br /> 
	Curso: <br/><input type="text" name="curso" /><br />
	<input type="submit" value="Atualizar" />
	</c:when>

<c:otherwise>
Selecione o dado para ser alterado
</c:otherwise>

</c:choose>
</form>

<a href="index.html">Pagina Inicial</a>    
<a href="selecionar-campo-atualizar-aluno.html">Voltar</a>    


</body>
</html>