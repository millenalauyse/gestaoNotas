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
import javax.websocket.Session;

import com.accenture.model.Aluno;
import com.accenture.model.AlunoDAO;


@WebServlet("/selecionarCampoAtualizarAluno")
public class ServletSelecionarCampoAluno extends HttpServlet{
	
	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//salvar o dado selecionado em uma sessão e jogar para proxima pagina
		
		String dado = req.getParameter("dado");
		String codMatricula = req.getParameter("codMatricula");
		
	
		HttpSession sessao = req.getSession();
		sessao.setAttribute("dado", req.getParameter("dado"));
		sessao.setAttribute("codMatricula", codMatricula);

		RequestDispatcher rd = req
                .getRequestDispatcher("/atualizar-aluno.jsp");
        rd.forward(req,resp);

	}	
	

}
