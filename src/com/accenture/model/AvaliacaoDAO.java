package com.accenture.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AvaliacaoDAO {
	
	private Connection connection;
	
	

	public AvaliacaoDAO()  {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	
	public void cadastrarNota(Avaliacao avaliacao)  {
		String insertSql =  "insert into avaliacao (cod_matricula, nota1, nota2, media_ponderada, nota_final)"
				+ "values(?,?,?,?,?)";
		AvaliacaoDAO dao= new AvaliacaoDAO();
		double mediaponderada = dao.calcularMedia(avaliacao);
		avaliacao.setMediaponderada(mediaponderada);
		
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(insertSql);
			
	        stmt.setInt(1,avaliacao.getCodMatricula());
	        stmt.setString(2,avaliacao.getNota1());
	        stmt.setString(3, avaliacao.getNota2());
	        stmt.setDouble(4,mediaponderada);
	        stmt.setDouble(5,mediaponderada);
	        stmt.execute();
	        stmt.close();
	        
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
}
	
	public void atualizarNota(Avaliacao avaliacao) {
		String sqlupdate = "update avaliacao set nota3=?, nota_final=? where cod_matricula=?" ;

		double nota3c = Double.parseDouble(avaliacao.getNota3());
		
		int codmatricula = avaliacao.getCodMatricula();
		
		AvaliacaoDAO dao= new AvaliacaoDAO();
		double mediaponderada = dao.getMediaPonderada(codmatricula);
		avaliacao.setMediaponderada(mediaponderada);
		double notafinal=dao.calcularMediaRecuperacao(avaliacao);
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sqlupdate);
			stmt.setDouble(1,nota3c);
			stmt.setDouble(2,notafinal);
			stmt.setInt(3,codmatricula);
			
			 stmt.execute();
		     stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void excluirNota(int codmatricula) {
		String sqldelete = "delete from avaliacao where cod_matricula =?";
		PreparedStatement stmt;
		
		try {
			stmt = connection.prepareStatement(sqldelete);
			stmt.setInt(1, codmatricula);
			 stmt.execute();
		     stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public double calcularMedia(Avaliacao avaliacao) {
		double nota1c = Double.valueOf(avaliacao.getNota1());
		double nota2c = Double.valueOf(avaliacao.getNota2());
		double mediaPonderada=  ((nota1c * 4) + (nota2c *6))/10;
		return mediaPonderada;
	}
	
	public double calcularMediaRecuperacao(Avaliacao avaliacao) {

		AvaliacaoDAO dao = new AvaliacaoDAO();
		String nota3 = avaliacao.getNota3();
		int codmatricula = avaliacao.getCodMatricula();
		double mediaponderada=dao.getMediaPonderada(codmatricula);
	
		
		//calculo da nota final
		double nota3c = Integer.parseInt(nota3);
		double resultadoRecuperacao = (mediaponderada +nota3c)/2;
		
		return resultadoRecuperacao;
	}
	
	
	public double getMediaPonderada(int codmatricula) {
		String retorno= null;
		String consultasql= "select media_ponderada from avaliacao where cod_matricula =?";
		PreparedStatement st;
	
		try {
			st = connection.prepareStatement(consultasql);
			st.setInt(1, codmatricula);
			st.execute();
			
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				retorno = rs.getString(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		double mediaponderada = Double.parseDouble(retorno);
		return mediaponderada;
		
	}
	

}
