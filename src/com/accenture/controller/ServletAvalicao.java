package com.accenture.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.model.Aluno;
import com.accenture.model.AlunoDAO;
import com.accenture.model.Avaliacao;
import com.accenture.model.AvaliacaoDAO;

@WebServlet("/cadastrarNota")
public class ServletAvalicao extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 String nota1 = req.getParameter("nota1");
		 String nota2 = req.getParameter("nota2");
	//	 String nota3 = req.getParameter("nota3");
		 String codMatricula = req.getParameter("codMatricula");
		
		 
		 int codMatriculaInt = Integer.parseInt(codMatricula);
//		 
//		 float nota1C = Float.parseFloat(nota1);
//		 float nota2C = Float.parseFloat(nota2);
//		 float nota3C = Float.parseFloat(nota3);
		 
		 
	//	 Aluno aluno = new Aluno();
		 Avaliacao avaliacao = new Avaliacao();
		 avaliacao.setCodMatricula(codMatriculaInt);
		 avaliacao.setNota1(nota1);
		 avaliacao.setNota2(nota2);
		// avaliacao.setNota3(nota3);
		 
//		 if (nota3 == null) {
//			
//			 avaliacao.setNota3(null);
//		 } else {
//			 avaliacao.setNota3(nota3);
//		 }
 
		AvaliacaoDAO dao = new AvaliacaoDAO();
		dao = new AvaliacaoDAO();
		dao.cadastrarNota(avaliacao);
		

		
		 RequestDispatcher rd = req
                .getRequestDispatcher("/nota-cadastrada.jsp");
        rd.forward(req,resp);

		

	}	

}
