package com.accenture.controller;

import java.io.IOException;
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
import com.accenture.model.AvaliacaoDAO;

@WebServlet("/atualizarNota")
public class ServletAtualizaNota extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession();
    	String codmatricula = (String) sessao.getAttribute("codMatricula");
	//	String codmatricula= req.getParameter("codMatricula");
	//	String nome = req.getParameter("nome");
		String nota3 = req.getParameter("nota3");
		
		int codMatriculaInt = Integer.parseInt(codmatricula);

		 Aluno aluno = new Aluno();
		 aluno.setCodMatricula(codMatriculaInt);
	//	 aluno.setNome(nome);
		 
		 Avaliacao avaliacao = new Avaliacao();
		 avaliacao.setCodMatricula(codMatriculaInt);
		 avaliacao.setNota3(nota3);
		
		AvaliacaoDAO dao = new AvaliacaoDAO();
		dao.atualizarNota(avaliacao);
			
		AlunoDAO alunodao = new AlunoDAO();
		 List<Avaliacao> atualizanotas = alunodao.getConsulta(codMatriculaInt);
		 req.setAttribute("retornoAtualizaNotas", atualizanotas);
		sessao.setAttribute("codMatricula", codmatricula);

		 RequestDispatcher rd = req
               .getRequestDispatcher("/nota-atualizada.jsp");
       rd.forward(req,resp);

		
	}

}
