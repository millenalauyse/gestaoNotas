package com.accenture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Aluno;
import com.accenture.model.AlunoDAO;

@WebServlet("/atualizarCampoAluno")
public class ServletAtualizarAluno  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession sessao = req.getSession();
		String dado = (String) sessao.getAttribute("dado");
		String codMatriculaString = (String) sessao.getAttribute("codMatricula");
		int codMatriculaInt = Integer.parseInt(codMatriculaString);

		Aluno aluno = new Aluno();
		aluno.setCodMatricula(codMatriculaInt);
	
		
		AlunoDAO dao = new AlunoDAO();
		dao = new AlunoDAO();
		
		if(dado.equals("nome")) {
			 String nome = req.getParameter("nome");
			 aluno.setNome(nome);
			
		}
		else if(dado.equals("email")) {
			String email = req.getParameter("email");
			aluno.setEmail(email);
			
		}
		else if(dado.equals("curso")) {
			String curso = req.getParameter("curso");
			aluno.setCurso(curso);
		}
		
		else if(dado.equals("todos")) {
			String nome = req.getParameter("nome");
			aluno.setNome(nome);
			
			String email = req.getParameter("email");
			aluno.setEmail(email);
			
			String curso = req.getParameter("curso");
			aluno.setCurso(curso);
		}
	
		 dao.atualizarAluno(dado, codMatriculaInt, aluno);
		
		 RequestDispatcher rd = req
	             .getRequestDispatcher("/aluno-atualizado.jsp");
	     rd.forward(req,resp);
	}
	

	
}
