package com.accenture.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.model.Aluno;
import com.accenture.model.AlunoDAO;

@WebServlet("/cadastrarAluno")
public class ServletAluno extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		 String nome = req.getParameter("nome");
		 String email = req.getParameter("email");
		 String curso = req.getParameter("curso");
		 
		 Aluno aluno = new Aluno();
		 aluno.setNome(nome);
		 aluno.setCurso(curso);
		 aluno.setEmail(email);
		 
		 
		AlunoDAO dao = new AlunoDAO();
		dao = new AlunoDAO();
		dao.cadastrarAluno(aluno);
		int codmatriculaCadastrado = dao.getCodMtriculaNovoCadastro();
		
		req.setAttribute("codmatriculanovo", codmatriculaCadastrado);
		 RequestDispatcher rd = req
                .getRequestDispatcher("/aluno-cadastrado.jsp");
        rd.forward(req,resp);
	}	
	

}
