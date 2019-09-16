package com.accenture.model;

import java.sql.SQLException;
import java.util.List;

public class Teste {
	public static void main(String[] args) throws SQLException {
		Aluno al = new Aluno();
		al.setCodMatricula(12);
		AlunoDAO alu = new AlunoDAO();
		Avaliacao av = new Avaliacao();
		av.setCodMatricula(12);
		int param=av.getCodMatricula();

		
		List<Avaliacao> ret = alu.getConsulta(param);
		
		 for (Avaliacao ava : ret) {
	          System.out.println("Matricula: " + ava.getCodMatricula());
	          System.out.println("Nota 1: " + ava.getNota1());
	          System.out.println("Nota 2: " +ava.getNota2());
	          System.out.println("Nota 3: " +ava.getNota3()); 
	                
	      }
		 
		 //testa calculo de nota
		 AvaliacaoDAO ava = new AvaliacaoDAO();
		 av.setNota1("7");
		 av.setNota2("7.5");
		
		 System.out.println(ava.calcularMedia(av));

	}

}
