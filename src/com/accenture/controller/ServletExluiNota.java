package com.accenture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.model.Aluno;
import com.accenture.model.AvaliacaoDAO;

@WebServlet("/excluirNota")
public class ServletExluiNota extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codMatriculaString = req.getParameter("codMatricula");
		int codMatriculaInt = Integer.parseInt(codMatriculaString);
		
		 Aluno aluno = new Aluno();
		 aluno.setCodMatricula(codMatriculaInt);
		 
		 AvaliacaoDAO dao = new AvaliacaoDAO();
		 dao.excluirNota(codMatriculaInt);
		 
		 RequestDispatcher rd = req
	                .getRequestDispatcher("/nota-excluida.jsp");
	        rd.forward(req,resp);

	}


}
