package com.accenture.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Aluno;
import com.accenture.model.AlunoDAO;
import com.accenture.model.Avaliacao;

@WebServlet("/consultarAluno")

public class ServletConsulta extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String codMatricula = req.getParameter("codMatricula");
		HttpSession sessao = req.getSession();
		int codMatriculaInt = Integer.parseInt(codMatricula);
		

		 Avaliacao avaliacao = new Avaliacao();
		 avaliacao.setCodMatricula(codMatriculaInt);
		 
		 AlunoDAO dao = new AlunoDAO();
		 List<Avaliacao> consulta = dao.getConsulta(codMatriculaInt);
		 req.setAttribute("retornoConsulta", consulta);

		 sessao.setAttribute("codMatricula", codMatricula);


		 RequestDispatcher rd = req
		           .getRequestDispatcher("/resultado-pesquisa-aluno.jsp");
		   rd.forward(req,resp);


	}
	
	
	}
